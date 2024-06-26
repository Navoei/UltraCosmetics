package be.isach.ultracosmetics.permissions;

import be.isach.ultracosmetics.cosmetics.Category;
import be.isach.ultracosmetics.cosmetics.type.CosmeticType;
import org.bukkit.entity.Player;

import java.util.Set;

public class ProfileBukkitHybridGetter implements CosmeticPermissionGetter {
    private final ProfilePermissions profile;
    private final BukkitPermissionGetter bukkit;

    public ProfileBukkitHybridGetter(ProfilePermissions profile, BukkitPermissionGetter bukkit) {
        this.profile = profile;
        this.bukkit = bukkit;
    }

    @Override
    public boolean hasPermission(Player player, CosmeticType<?> type) {
        return profile.hasPermission(player, type) || bukkit.hasPermission(player, type);
    }

    @Override
    public Set<CosmeticType<?>> getEnabledUnlocked(Player player) {
        Set<CosmeticType<?>> unlocked = profile.getEnabledUnlocked(player);
        unlocked.addAll(bukkit.getEnabledUnlocked(player));
        return unlocked;
    }

    @Override
    public Set<CosmeticType<?>> getEnabledUnlocked(Player player, Category cat) {
        Set<CosmeticType<?>> unlocked = profile.getEnabledUnlocked(player, cat);
        unlocked.addAll(bukkit.getEnabledUnlocked(player, cat));
        return unlocked;
    }
}
