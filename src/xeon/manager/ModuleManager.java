package xeon.manager;

import java.util.ArrayList;

import xeon.module.Module;
import xeon.module.modules.*;

public class ModuleManager {
	private ArrayList<Module> modules = new ArrayList<Module>();

	public ArrayList<Module> getModules() {
		return modules;
	}
	
	public ModuleManager() {
		this.modules.add(new Sprint());
	}
}
