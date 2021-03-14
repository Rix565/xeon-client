package xeon.command.commands;

import xeon.command.Command;
import xeon.command.CommandType;
import xeon.value.Type;
import java.io.IOException;
import xeon.utils.SaveUtils;

public class EnableDiscordRP extends Command {
	public EnableDiscordRP() {
		super("enablediscordrp", "Activer/Désactiver la Rich Presence discord de Xeon Client", 0, "enablediscordrp", CommandType.other);
	}
	
	public void onCommand(String args[]) throws IOException {
		if(utils.getValueByType(Type.enableDiscordRP).getValueAsBoolean() == true){
			utils.getValueByType(Type.enableDiscordRP).setValue(false);
			utils.sendChat("Discord Rich Presence désactivé !");
		}else{
			utils.getValueByType(Type.enableDiscordRP).setValue(true);
			utils.sendChat("Discord Rich Presence activé !");
		}
		SaveUtils.getInstance().saveValues();
	}
}

