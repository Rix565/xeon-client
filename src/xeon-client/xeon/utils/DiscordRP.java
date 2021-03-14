package xeon.utils;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;
public class DiscordRP {
	private boolean running = true;
	private long created = 1;
	
	public void start() {
		this.created = System.currentTimeMillis();
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			@Override
			public void apply(DiscordUser user) {
				System.out.println("[Xeon-Client Discord-RP]Bienvenue, " + user.username + "#" + user.discriminator + " !");
				update("Chargement...", "");
			}
		}).build();
		
		DiscordRPC.discordInitialize("820228478687379486", handlers, true);
		
		new Thread("Discord RPC Callback") {
			@Override
			public void run() {
				while(running) {
					DiscordRPC.discordRunCallbacks();
				}
			}
		}.start();
	}

	public void update(String firstline, String secondline) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondline);
		b.setBigImage("large", "Xeon Client 0.3.0 Pre 2");
		b.setDetails(firstline);
		b.setStartTimestamps(created);
		DiscordRPC.discordUpdatePresence(b.build());
	}
	
	public void shutdown() {
		running = false;
		DiscordRPC.discordShutdown();
	}
}
