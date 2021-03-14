package xeon.manager;

import java.util.ArrayList;

import xeon.command.Command;
import xeon.command.commands.*;

public class CommandManager {
	private ArrayList<Command> commands = new ArrayList<Command>();
	
	public CommandManager() {
		this.commands.add(new Help());
		this.commands.add(new Prefix());
		this.commands.add(new EnableDiscordRP());
	}

	public ArrayList<Command> getCommands() {
		return commands;
	}
}
