package com.sprutusraypus;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.plugin.java.JavaPlugin;

public class MagickalBattlegrounds extends JavaPlugin {

	public SpecialProjectileListener SpecialProjectileListener;
	
	@Override
	public void onEnable() {
		SpecialProjectileListener = new SpecialProjectileListener();
		this.getServer().getPluginManager().registerEvents(SpecialProjectileListener, this);
	}

	@Override
	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player))
			return false;
		Player player = (Player) sender;

		switch (label) {
		case "test":
			return test(player);
		case "testargs":
			return testArgs(player, args);
		case "arrow":
			arrow(player, args);
			return true;
		case "grenade":
			grenade(player, args);
		case "wand":
			wand(player, args);
		case "for":
			forCommand(player, args);
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
		Arrow arrow = player.getWorld().spawnArrow(player.getEyeLocation(), player.getLocation().getDirection(), speed,
				spread);
		arrow.setShooter(player);
		SpecialArrow arrowProjectile = new SpecialArrow(arrow);
		SpecialProjectileListener.registerProjectile(arrowProjectile);
		return arrow.getEntityId();
	}

	private boolean grenade(Player player, String[] args) {
		float speed = Float.parseFloat(args[0]);
		Projectile snowball = (Projectile) player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.SNOWBALL);
		snowball.setVelocity(player.getLocation().getDirection().multiply(speed));
		snowball.setShooter(player);
		return true;
	}
	
	private boolean wand(Player player, String[] args) {
		String command = args[0];
		
		//TODO
		
		return true;
	}
	
	private boolean forCommand(Player player, String[] args) {
		int count = Integer.parseInt(args[0]);
		String command = args[1];
		String output = "";
		for (int i = 2; i < args.length; i++) {
			output += " "+args[i];
		}
		for (int i = 0; i < count; i++) {
			player.chat("/"+command+output);
		}
		return true;
	}

}
