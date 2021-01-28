package xeon.command.commands;

import xeon.command.Command;
import xeon.command.CommandType;
import xeon.value.Type;

public class Prefix extends Command {
	public Prefix() {
		super("prefix", "Changer le préfix du client Xeon", 2, "prefix [nouveau_prefix]", CommandType.Other);
	}
	
	public void onCommand(String[] args) {
		utils.getValueByType(Type.prefixCmd).setValue(args[1]);
		utils.sendChat("Prefix de Xeon redéfini en : " + args[1]);
	}
}
