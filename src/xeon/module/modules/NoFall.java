package xeon.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import xeon.module.Category;
import xeon.module.Module;

public class NoFall extends Module {
	public NoFall() {
		super("NoFall", Keyboard.KEY_N, Category.Render);
	}
	
	
	public void onUpdate() {
		if (mc.thePlayer.fallDistance >= 2F) {
		    mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
		    mc.thePlayer.fallDistance=0.0F;
		}
	}
}
