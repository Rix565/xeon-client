package xeon.manager;

import java.util.ArrayList;

import xeon.module.Module;
import xeon.module.modules.*;

public class ModuleManager {
	private ArrayList<Module> modules = new ArrayList<Module>();
	private ArrayList<String> enabledmodules = new ArrayList<String>();

	public ArrayList<Module> getModules() {
		return modules;
	}
	public ArrayList<String> getEnabledModules() {
		return enabledmodules;
	}
	
	public ModuleManager() {
		this.modules.add(new Sprint());
		this.modules.add(new NoFall());
	}
	
	public void disableModule(String module) {
		this.enabledmodules.remove(module);
	}
	public void enableModule(String module) {
		this.enabledmodules.add(module);
	}
}
