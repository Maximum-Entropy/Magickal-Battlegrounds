package com.sprutusraypus;

import java.util.UUID;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;

public abstract class SpecialProjectile<P extends Projectile> {

	protected final P projectile;

	public SpecialProjectile(P proj) {
		this.projectile = proj;
	}

	public abstract void entityHit(Entity entity);

	public abstract void blockHit(Block block);

	public P getProjectile() {
		return projectile;
	}

	public UUID getUUID() {
		return projectile.getUniqueId();
	}

	public void dispose() {
		projectile.remove();
	}
}