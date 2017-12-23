package com.sprutusraypus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;

public class SpecialArrow extends SpecialProjectile<Arrow> {

	public SpecialArrow(MagickalBattlegrounds plugin, Arrow arrow) {
		super(plugin, arrow);
	}

	@Override
	public void entityHit(Entity entity) {
		List<Color> colors = new ArrayList<Color>();
		colors.add(Color.BLUE);
		colors.add(Color.AQUA);
		firework(colors);
		dispose();
	}

	@Override
	public void blockHit(Block block) {
		explode(3, false);
		dispose();
	}

}
