package com.sprutusraypus.mb;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MagickalBattlegrounds extends JavaPlugin {

	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player)
			return false;
		Player player = (Player) sender;

		switch (label) {
		case "test":
			return test(player);
		case "testArgs":
			return testArgs(player, args);
		default:
			return false;
		}
	}

	private boolean test(Player player) {
		// TODO

		return true;
	}

	private boolean testArgs(Player player, String[] args) {
		// TODO

		return true;
	}

}
