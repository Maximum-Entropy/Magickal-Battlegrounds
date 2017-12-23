package com.sprutusraypus;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SpecialProjectileListener implements Listener {

	private Map<UUID, SpecialProjectile<? extends Projectile>> specialProjectiles;

	public SpecialProjectileListener() {
		specialProjectiles = new HashMap<UUID, SpecialProjectile<? extends Projectile>>();
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent evt) {
		Projectile proj = evt.getEntity();
		UUID uniqueID = proj.getUniqueId();

		SpecialProjectile<? extends Projectile> specialProj = specialProjectiles.get(uniqueID);
		if (specialProj == null)
			return; // Not a SpecialProjectile event

		switch (proj.getType()) {
		case ARROW:
			Player player = (Player) proj.getShooter();
			player.chat("My special arrow hit the ground!");
			break;
		default:
			Bukkit.getLogger().log(Level.WARNING, proj.getType() + " is not a handled SpecialProjectile type.");
			return;
		}

		if (evt.getHitEntity() != null)
			specialProj.entityHit(evt.getHitEntity());
		if (evt.getHitBlock() != null)
			specialProj.blockHit(evt.getHitBlock());
	}

	public void registerProjectile(SpecialProjectile<? extends Projectile> specialProj) {
		specialProjectiles.put(specialProj.getUUID(), specialProj);
	}
}
