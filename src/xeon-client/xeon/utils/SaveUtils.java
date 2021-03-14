package xeon.utils;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import xeon.Client;
import xeon.manager.ModuleManager;
import xeon.manager.ValueManager;
import xeon.module.Module;
import xeon.value.Type;
import xeon.value.Value;

public class SaveUtils {
	private static SaveUtils instance;
	private Client client = Client.getInstance();
	private ValueManager valuemanager = client.getValuemanager();
	private ModuleManager modulemanager = client.getModulemanager();
	private Utils utils = Utils.getInstance();
	
	private String getAppPath() {
		return this.getDefaultPath() + File.separator + "Xeon-Client-Config" + File.separator;
	}
	
	private String getDefaultPath() {
		String OS = System.getProperty("os.name").toLowerCase();
		
		if (this.isWindows(OS)) {
			return System.getenv("APPDATA");
		} else if (this.isMac(OS)) {
			return System.getProperty("user.home") + File.separator + "Library" + File.separator + "Application Support";
		} else if (this.isUnix(OS)) {
			return System.getProperty("user.home");
		}
		return "/";
	}
	
	private boolean isWindows(String OS) {
		return (OS.indexOf("win") >= 0);
	}

	private boolean isMac(String OS) {
		return (OS.indexOf("mac") >= 0);
	}

	private boolean isUnix(String OS) {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 || OS.indexOf("sunos") >= 0);
	}
	
	public static SaveUtils getInstance() {
		return instance == null ? instance = new SaveUtils() : instance;
	}

	private void createSaveDirIfNotExist() {
		File dir = new File(this.getAppPath());
		if (!dir.exists())
			dir.mkdir();
	}
	
	private void createFileIfNotExist(File file) throws IOException {
		if (!file.exists())
			file.createNewFile();
	}
	
	private void saveContentToFile(String filename, String content) throws IOException {
		this.createSaveDirIfNotExist();
		File file = new File(this.getAppPath() + filename + ".txt");
		this.createFileIfNotExist(file);

		FileWriter fw = new FileWriter(file);
		fw.write(content);
		fw.close();
	}
	
	private List<String> getContentFromFile(String filename) throws IOException {
		this.createSaveDirIfNotExist();
		File file = new File(getAppPath() + filename + ".txt");

		if (file.exists()) {
			return Files.readAllLines(file.toPath());
		}

		return null;
	}
	
	public void saveValues() throws IOException {
		String content = "";
		
		for (Value v : valuemanager.getValues()) {
			if (!content.isEmpty())
				content += "\n";
			
			content += v.getName().name() + "=";
			if (v.getValue() instanceof String) {
				content += v.getValueAsString();
			}else if (v.getValue() instanceof Boolean) {
				content += v.getValueAsBoolean();
			}
		}
		
		this.saveContentToFile("values", content);
	}
	
	public void saveModules() throws IOException {
		String content = "";
		
		for (String m : modulemanager.getEnabledModules()) {
			if (!content.isEmpty())
				content += "\n";
			content += m;
		}
		
		this.saveContentToFile("modules", content);
	}
	
	public void loadValues() throws IOException {
		List<String> content = this.getContentFromFile("values");
		if (content != null) {
			for (String line : content) {
				String[] values = line.split("=");
				String type = values[0];
				String rawValue = values[1];
				
				if (!utils.isValueType(type))
					continue;
				
				Value value = utils.getValueByType(Type.valueOf(type));
				
				if (value.getValue() instanceof String) {
					value.setValue(rawValue);
				}else if (value.getValue() instanceof Boolean) {
					Boolean booleanValue = Boolean.parseBoolean(rawValue);
	                value.setValue(booleanValue);
	            }
			}
		}
	}
	
	public void loadModules() throws IOException {
		List<String> content = this.getContentFromFile("modules");
		if (content != null) {
			for (String line : content) {
				utils.toggleModule(line);
			}
		}
	}
	
}