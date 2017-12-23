package com.sprutusraypus;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SpecialProjectileListener implements Listener {
	
	private Map<Integer, SpecialProjectile> specialProjectiles;

	public SpecialProjectileListener() {
		specialProjectiles = new HashMap<Integer, SpecialProjectile>();
	}
	
	//@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		Projectile projectile = event.getEntity();
		if (projectile instanceof Arrow) {
			if (specialProjectiles.containsKey(projectile.getEntityId())) {
				Player player = (Player) projectile.getShooter();
				player.chat("My special arrow hit the ground!");
			}
		}
	}
	
	public void registerProjectile(SpecialProjectile specialProjectile) {
		specialProjectiles.put(specialProjectile.projectile.getEntityId(), specialProjectile);
	}
}
