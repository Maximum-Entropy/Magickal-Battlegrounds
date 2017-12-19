package com.sprutusraypus.mb;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
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
	
	private int arrow(Player player, String[] args) {
		float speed = Float.parseFloat(args[0]);
		float spread = Float.parseFloat(args[1]);
		Arrow arrow = player.getWorld().spawnArrow(player.getLocation(), player.getLocation().getDirection(), speed, spread);
		arrow.setShooter(player);
		return arrow.getEntityId();
	}
	
	private int grenade(Player player, String[] args) {
		float speed = Float.parseFloat(args[0]);
		Projectile grenade = (Projectile) player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.SNOWBALL);
		grenade.setVelocity(player.getLocation().getDirection().multiply(speed));
		grenade.setShooter(player);
		grenade.setBounce(true);
		return grenade.getEntityId();
	}

}
