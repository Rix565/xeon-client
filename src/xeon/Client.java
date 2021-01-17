package xeon;

import xeon.manager.ModuleManager;

public class Client {
	private static Client instance = new Client();
	private ModuleManager modulemanager;
	
	public static Client getInstance() {
		return instance;
	}
	
	public void start() {
		System.out.println("[Xeon-Client] Chargement ! Version : 0.1.0");
		this.modulemanager = new ModuleManager();
	}

	public ModuleManager getModulemanager() {
		return modulemanager;
	}
}
