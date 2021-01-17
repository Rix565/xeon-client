package xeon.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Utils {
	private static Utils instance = new Utils();
	private Minecraft mc = Minecraft.getMinecraft();
	
	public static Utils getInstance() {
		return instance;
	}
	
	public void sendChat(String text) {
		mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("[Xeon-Client]"+ text));
	}
}
