package io.github.bucksnort2.WhosOnWhen;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.command.Command;

public class PlayerInformation {
	private long startTime, endTime;
	private List<Command> cmdList;

	public PlayerInformation() {
		this.startTime = 0;
		this.endTime = 0;
		cmdList = new LinkedList<Command>();
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getStartTime() {
		return this.startTime;
	}

	public long getEndTime() {
		return this.endTime;
	}

	public long getTotalTime() {
		if (this.endTime == 0) {
			return System.currentTimeMillis() - this.startTime;
		}
		return this.endTime - this.startTime;
	}

	public void addCommand(Command cmd) {
		this.cmdList.add(cmd);
	}

	public void display() {
		System.out.println("\t" + getTotalTime());
		for (Command cmd : cmdList) {
			System.out.println("\t\t" + cmd.getName() + " " + cmd.getLabel());
		}
	}
}
