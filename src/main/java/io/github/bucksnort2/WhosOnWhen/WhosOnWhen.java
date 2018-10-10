package io.github.bucksnort2.WhosOnWhen;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WhosOnWhen extends JavaPlugin{
	@Override
	public void onEnable() {
		getLogger().info("\"Who's on When\" has been enabled!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("\"Who's on When\" has been disabled!");		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("whoson")) {
			if (sender instanceof Player) {
				sender.sendMessage("This command can only be run by the console.");
				return false;
			}
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		long startTime = System.currentTimeMillis();
	}
}
