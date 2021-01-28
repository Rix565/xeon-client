package xeon.module.modules;

import org.lwjgl.input.Keyboard;

import xeon.module.Category;
import xeon.module.Module;

public class Sprint extends Module {
	public Sprint() {
		super("Sprint", Keyboard.KEY_K, Category.Movement);
	}
	
	public void onDisabled() {
		mc.thePlayer.setSprinting(false);
		super.onDisabled();
	}
	
	public void onUpdate() {
		mc.thePlayer.setSprinting(true);
	}
}
