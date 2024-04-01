package glowredman.fpsp.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import WayofTime.alchemicalWizardry.ModItems;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import fox.spiteful.avaritia.DamageSourceInfinitySword;

public class AchievementHandler {

    private static final Map<UUID, Integer> LAST_DEATHCOUNT = new HashMap<>();
    private static final Map<UUID, Float> LAST_DAMAGE = new HashMap<>();

    private static StatBase omegaArmorAchievement;
    private static StatBase damageAchievement;
    public static StatBase beaconAchievement;
    public static Block beaconBase;

    public static void init() {
        omegaArmorAchievement = StatList.func_151177_a("omega_armor");
        damageAchievement = StatList.func_151177_a("10k_damage");
        beaconAchievement = StatList.func_151177_a("soul_beacon");
        beaconBase = GameRegistry.findBlock("DraconicEvolution", "draconium");
    }

    @SubscribeEvent
    public void onEntityUpdate(PlayerTickEvent event) {
        if (event.side == Side.CLIENT || event.phase == Phase.START) {
            return;
        }

        EntityPlayer player = event.player;
        UUID uuid = player.getUniqueID();
        int currentDeathCount = FMLCommonHandler.instance()
            .getMinecraftServerInstance()
            .getConfigurationManager()
            .func_152602_a(player)
            .writeStat(StatList.deathsStat);
        Float lastDamage = LAST_DAMAGE.get(uuid);
        if (lastDamage != null && lastDamage >= 10000.0f && LAST_DEATHCOUNT.get(uuid) == currentDeathCount) {
            player.triggerAchievement(damageAchievement);
        }

        ItemStack[] armor = player.inventory.armorInventory;
        if (hasArmor(
            armor,
            ModItems.boundHelmetEarth,
            ModItems.boundPlateEarth,
            ModItems.boundLeggingsEarth,
            ModItems.boundBootsEarth)
            || hasArmor(
                armor,
                ModItems.boundHelmetFire,
                ModItems.boundPlateFire,
                ModItems.boundLeggingsFire,
                ModItems.boundBootsFire)
            || hasArmor(
                armor,
                ModItems.boundHelmetWater,
                ModItems.boundPlateWater,
                ModItems.boundLeggingsWater,
                ModItems.boundBootsWater)
            || hasArmor(
                armor,
                ModItems.boundHelmetWind,
                ModItems.boundPlateWind,
                ModItems.boundLeggingsWind,
                ModItems.boundBootsWind)) {
            player.triggerAchievement(omegaArmorAchievement);
            return;
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
    public void onLivingHurt(LivingAttackEvent event) {
        if (!(event.entityLiving instanceof EntityPlayer player)) {
            return;
        }
        UUID uuid = player.getUniqueID();
        int deathCount = FMLCommonHandler.instance()
            .getMinecraftServerInstance()
            .getConfigurationManager()
            .func_152602_a(player)
            .writeStat(StatList.deathsStat);
        float amount = event.source instanceof DamageSourceInfinitySword ? Float.POSITIVE_INFINITY : event.ammount;
        LAST_DEATHCOUNT.put(uuid, deathCount);
        LAST_DAMAGE.put(uuid, amount);

    }

    private static boolean hasArmor(ItemStack[] armor, Item helmet, Item chestplate, Item leggins, Item boots) {
        ItemStack equippedHelmet = armor[3];
        ItemStack equippedChestplate = armor[2];
        ItemStack equippedLeggins = armor[1];
        ItemStack equippedBoots = armor[0];
        if (equippedHelmet == null || equippedChestplate == null || equippedLeggins == null || equippedBoots == null) {
            return false;
        }
        return equippedHelmet.getItem() == helmet && equippedChestplate.getItem() == chestplate
            && equippedLeggins.getItem() == leggins
            && equippedBoots.getItem() == boots;
    }

}
