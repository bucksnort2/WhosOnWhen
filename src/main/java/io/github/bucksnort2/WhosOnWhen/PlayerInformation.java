package io.github.bucksnort2.WhosOnWhen;

import java.util.LinkedHashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class PlayerInformation {
	private long startTime, endTime;
	private Player p;
	private Map<Player, String> commandList;

	public PlayerInformation() {
		startTime = 0;
		endTime = 0;
		p = null;
		commandList = new LinkedHashMap<Player, String>();
	}

	public PlayerInformation(Player p) {
		this.p = p;
		commandList = new LinkedHashMap<Player, String>();
	}

	public void addCommand(Player pKey, String cmdValue) {
		commandList.put(pKey, cmdValue);
	}

	public void printInfo() {

	}

}
