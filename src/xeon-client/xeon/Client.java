//Xeon Client
//All your dreams in Minecraft becomes true !

package xeon;

import xeon.manager.CommandManager;
import xeon.manager.ModuleManager;
import xeon.manager.ValueManager;
import xeon.utils.DiscordRP;
import java.io.IOException;
import xeon.utils.SaveUtils;
import xeon.utils.Utils;
import xeon.value.Type;

public class Client {
	private static Client instance = new Client();
	public static String ClientVersion = "Xeon Client 0.3.0 DEV";
	public String SlimVersion = "0.3.0 DEV";
	private ModuleManager modulemanager;
	private ValueManager valuemanager;
	private CommandManager commandmanager;
	private DiscordRP discordRP = new DiscordRP();
	
	public static Client getInstance() {
		return instance;
	}
	
	public void start() {
		System.out.println("[Xeon-Client]Chargement en cours... (Version "+ this.SlimVersion + ")");
		this.modulemanager = new ModuleManager();
		this.valuemanager = new ValueManager();
		this.commandmanager = new CommandManager();
		try {
			SaveUtils.getInstance().loadModules();
			SaveUtils.getInstance().loadValues();
		} catch (IOException e) {
			System.out.println("Error while loading data: "+e.getMessage());
		}
		if(Utils.getInstance().getValueByType(Type.enableDiscordRP).getValueAsBoolean()){
			discordRP.start();
		}
		System.out.println("[Xeon-Client]Chargement terminé ! Lancement de Minecraft...");
	}
	
	public CommandManager getCommandmanager() {
		return commandmanager;
	}
	public ValueManager getValuemanager() {

		return valuemanager;
	}

	public void stop() {
		System.out.println("[Xeon-Client]Extinction !");
		discordRP.shutdown();
	}

	public ModuleManager getModulemanager() {
		return modulemanager;
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
}
