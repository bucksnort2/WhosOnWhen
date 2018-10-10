package io.github.bucksnort2.WhosOnWhen;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class WhosOnWhen extends JavaPlugin{
	Map<Player, PlayerInformation> allPlayerInfo;
	
	@Override
	public void onEnable() {
		getLogger().info("\"Who's on When\" has been enabled!");
		allPlayerInfo = new LinkedHashMap<Player, PlayerInformation>();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("\"Who's on When\" has been disabled!");
		allPlayerInfo.clear();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			PlayerInformation pInfo = allPlayerInfo.get(p);
			pInfo.addCommand(cmd);
			allPlayerInfo.put(p, pInfo);
		}
		
		if (cmd.getName().equalsIgnoreCase("whoson")) {
			if (sender instanceof Player) {
				sender.sendMessage("This command can only be run by the console.");
				return false;
			}
			for(Player p : allPlayerInfo.keySet()) {
				PlayerInformation pInfo = allPlayerInfo.get(p);
				System.out.println(p.getName());
				pInfo.display();
			}
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		long startTime = System.currentTimeMillis();
		PlayerInformation pInfo = new PlayerInformation();
		pInfo.setStartTime(startTime);
		allPlayerInfo.put(p, pInfo);
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		long endTime = System.currentTimeMillis();
		PlayerInformation pInfo = allPlayerInfo.get(p);
		pInfo.setEndTime(endTime);
		allPlayerInfo.put(p, pInfo);
	}
}
