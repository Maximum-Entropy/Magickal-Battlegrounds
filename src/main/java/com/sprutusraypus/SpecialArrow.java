package com.sprutusraypus;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;

public class SpecialArrow extends SpecialProjectile{

	public SpecialArrow(Projectile projectile) {
		super(projectile);
	}

	@Override
	public void entityHit(Projectile projectile, Entity entity) {
		
	}

	@Override
	public void blockHit(Projectile projectile, Block block) {
		
	}

}
