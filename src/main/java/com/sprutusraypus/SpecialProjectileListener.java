package com.sprutusraypus;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class SpecialProjectileListener implements Listener {
	
	private Map<Integer, SpecialProjectile> specialProjectiles;

	public SpecialProjectileListener() {
		specialProjectiles = new HashMap<Integer, SpecialProjectile>();
	}
	
	//@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {
		
	}
	
	public void registerProjectile(SpecialProjectile specialProjectile) {
		
	}
}
