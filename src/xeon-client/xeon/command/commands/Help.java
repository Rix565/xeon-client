package xeon.command.commands;

import java.util.ArrayList;

import xeon.command.Command;
import xeon.command.CommandType;
import xeon.value.Type;

public class Help extends Command {
	public Help() {
		super("help", "Affiche la description du cheat", 1, "help [nom_du_cheat]", CommandType.Other);
	}
	public void onCommand(String[] args) {
		ArrayList<Command> list = new ArrayList<Command>();
		String prefix = utils.getValueByType(Type.prefixCmd).getValueAsString();
		if (args.length == 1) {
			list = utils.getCommandByType(CommandType.Other);
		} else if (CommandType.valueOf(args[1].toLowerCase()) != null) {
			System.out.println(CommandType.valueOf(args[1].toLowerCase()).name());
			list = utils.getCommandByType(CommandType.valueOf(args[1].toLowerCase()));
		} else {
			utils.sendChat("$c Cette page d'aide n'existe pas.");
		}
		for (Command cmd : list) {
			utils.sendChat(prefix + cmd.getHelp() + ": " + cmd.getDescription());
		}
	}
}

