package io.github.bucksnort2.WhosOnWhen;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WhosOnWhen extends JavaPlugin{
	List<PlayerInformation> playerList;
	@Override
	public void onEnable() {
		getLogger().info("\"Who's on When\" has been enabled!");
		playerList = new LinkedList<PlayerInformation>();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("\"Who's on When\" has been disabled!");		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			String wholeCommand = cmd.toString() + " " + args;
		}
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
		long time = System.currentTimeMillis();
	}
}
