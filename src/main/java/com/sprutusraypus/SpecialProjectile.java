package com.sprutusraypus;

import java.util.UUID;

import org.bukkit.FireworkEffect;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Projectile;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class SpecialProjectile<P extends Projectile> {

	private MagickalBattlegrounds context;
	protected final P projectile;

	public SpecialProjectile(MagickalBattlegrounds plugin, P proj) {
		this.context = plugin;
		this.projectile = proj;
	}
	
	public void explode(float str, boolean fire) {
		projectile.getWorld().createExplosion(projectile.getLocation(), str, fire);
	}
	
	public void firework(Iterable<?> colors) {
		final Firework fwk = (Firework) projectile.getWorld().spawnEntity(projectile.getLocation(), EntityType.FIREWORK);
		FireworkMeta fwkm = fwk.getFireworkMeta();
		fwkm.clearEffects();
		FireworkEffect effect = FireworkEffect.builder().withColor(colors).trail(false).build();
		fwkm.addEffect(effect);
		fwk.setFireworkMeta(fwkm);
		new BukkitRunnable() {
		    @Override
		    public void run() {
		      fwk.detonate();
		    }
		}.runTask(context);
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