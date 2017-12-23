package com.sprutusraypus;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;

public abstract class SpecialProjectile{
	
	protected Projectile projectile;
	
	public SpecialProjectile(Projectile projectile) {
		this.projectile = projectile;
	}
	
	public abstract void entityHit(Projectile projectile, Entity entity);
	
	public abstract void blockHit(Projectile projectile, Block block);
	
	public void dispose() {
		projectile.remove();
	}
}