package com.sprutusraypus.commands;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

import com.sprutusraypus.MagickalBattlegrounds;
import com.sprutusraypus.SpecialArrow;

public class ArrowCommand implements CommandExecutor {
	private MagickalBattlegrounds context;

	public ArrowCommand(MagickalBattlegrounds plugin) {
		this.context = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Bukkit.getLogger().log(Level.WARNING, "\"arrow\" command must be executed by an in-game Player.");
			return false;
		}
		Player player = (Player) sender;

		float speed = Float.parseFloat(args[0]);
		float spread = Float.parseFloat(args[1]);
		Arrow arrow = player.getWorld().spawnArrow(player.getEyeLocation(), player.getLocation().getDirection(), speed,
				spread);
		arrow.setShooter(player);
		SpecialArrow arrowProjectile = new SpecialArrow(arrow);
		context.projectileListener.registerProjectile(arrowProjectile);
		return true;
	}

}
