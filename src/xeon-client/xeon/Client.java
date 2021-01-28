//Xeon Client
//All your dreams in Minecraft becomes true !

package xeon;

import xeon.manager.CommandManager;
import xeon.manager.ModuleManager;
import xeon.manager.ValueManager;

public class Client {
	private static Client instance = new Client();
	public String ClientVersion = "Xeon Client 0.3.0 DEV";
	public String SlimVersion = "0.3.0 DEV";
	private ModuleManager modulemanager;
	private ValueManager valuemanager;
	private CommandManager commandmanager;
	
	public static Client getInstance() {
		return instance;
	}
	
	public void start() {
		System.out.println("[Xeon-Client]Chargement en cours... (Version "+ this.SlimVersion + ")");
		this.modulemanager = new ModuleManager();
		this.valuemanager = new ValueManager();
		this.commandmanager = new CommandManager();
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
	}

	public ModuleManager getModulemanager() {
		return modulemanager;
	}
}
