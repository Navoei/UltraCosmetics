package be.isach.ultracosmetics.cosmetics.deatheffects;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.Cosmetic;
import be.isach.ultracosmetics.cosmetics.type.DeathEffectType;
import be.isach.ultracosmetics.player.UltraPlayer;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public abstract class DeathEffect extends Cosmetic<DeathEffectType> {

    public DeathEffect(UltraPlayer owner, DeathEffectType type, UltraCosmetics ultraCosmetics) {
        super(owner, type, ultraCosmetics);
    }

    @Override
    protected void onEquip() {
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() == getPlayer().getKiller()) {
            displayParticles(event.getEntity().getKiller(), event.getEntity().getLocation());
        }
    }

    public void displayParticles(Player killer, Location deadPlayerLocation) {
        getType().getEffect().display(deadPlayerLocation);
    }
}
