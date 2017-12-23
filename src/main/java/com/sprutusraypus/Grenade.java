package com.sprutusraypus;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;

public class Grenade extends SpecialProjectile<Projectile> {

	public Grenade(MagickalBattlegrounds plugin, Projectile proj) {
		super(plugin, proj);
	}

	@Override
	public void entityHit(Entity entity) {
		explode(5, true);
	}

	@Override
	public void blockHit(Block block) {
		explode(5, true);
	}
}
