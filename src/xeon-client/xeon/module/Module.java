package xeon.module;

import net.minecraft.client.Minecraft;
import xeon.utils.Utils;

public class Module {
	private String name;
	private int bind;
	private Category category;
	
	protected boolean isToggled;
	protected Minecraft mc = Minecraft.getMinecraft();
	
	
	public boolean isToggled() {
		return isToggled;
	}
	
	public void toggle(boolean toggle) {
		this.isToggled = toggle;
		if(toggle) {
			this.onEnabled();
		}else {
			this.onDisabled();
		}
	}
	
	public String getName() {
		return name;
	}
	public Module(String name, int bind, Category category) {
		this.name = name;
		this.bind = bind;
		this.category = category;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBind() {
		return bind;
	}
	public void setBind(int bind) {
		this.bind = bind;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	protected void onEnabled() {
		Utils.getInstance().sendChat("§a Le module "+ this.getName() + " a été activé !");
	}
	
	protected void onDisabled() {
		Utils.getInstance().sendChat("§c Le module "+ this.getName() + " a été désactivé !");
	}
	
	public void onUpdate() {}
	
}