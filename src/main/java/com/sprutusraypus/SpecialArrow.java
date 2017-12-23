package com.sprutusraypus;

import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

public class SpecialArrow extends SpecialProjectile<Arrow> {

	public SpecialArrow(Arrow arrow) {
		super(arrow);
	}

	@Override
	public void entityHit(Entity entity) {
	}

	@Override
	public void blockHit(Block block) {
	}

}
