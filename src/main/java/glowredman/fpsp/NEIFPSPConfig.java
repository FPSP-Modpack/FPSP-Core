package glowredman.fpsp;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIFPSPConfig implements IConfigureNEI {

    @Override
    public String getName() {
        return "FPSP NEI Plugin";
    }

    @Override
    public String getVersion() {
        return "1.1";
    }

    @Override
    public void loadConfig() {
        API.hideItem(new ItemStack(FPSP.itemIcon));

        hide("ArchitectureCraft", "cladding");
        hide("BiblioCraft", "BiblioClipboard");
        hide("BuildCraft|Core", "buildToolBlock");
        hide("BuildCraft|Transport", "pipeBlock");
        hide("CarpentersBlocks", "blockCarpentersBed");
        hide("CarpentersBlocks", "blockCarpentersDoor");
        hideAll("CaveBiomes", "frozen_roots", 1, 7);
        hideAll("CaveBiomes", "frozen_redstone_stalactite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_redstone_stalactite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_redstone_stalactite_tip", 1, 7);
        hideAll("CaveBiomes", "frozen_redstone_column", 1, 7);
        hideAll("CaveBiomes", "frozen_redstone_stalagmite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_redstone_stalagmite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_redstone_stalagmite_tip", 1, 7);
        hideAll("CaveBiomes", "frozen_lit_redstone_stalactite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_lit_redstone_stalactite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_lit_redstone_stalactite_tip", 1, 7);
        hideAll("CaveBiomes", "frozen_lit_redstone_column", 1, 7);
        hideAll("CaveBiomes", "frozen_lit_redstone_stalagmite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_lit_redstone_stalagmite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_lit_redstone_stalagmite_tip", 1, 7);
        hideAll("CaveBiomes", "frozen_stone_stalactite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_stone_stalactite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_stone_stalactite_tip", 1, 7);
        hideAll("CaveBiomes", "frozen_stone_column", 1, 7);
        hideAll("CaveBiomes", "frozen_stone_stalagmite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_stone_stalagmite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_stone_stalagmite_tip", 1, 7);
        hideAll("CaveBiomes", "frozen_sandstone_stalactite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_sandstone_stalactite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_sandstone_stalactite_tip", 1, 7);
        hideAll("CaveBiomes", "frozen_sandstone_column", 1, 7);
        hideAll("CaveBiomes", "frozen_sandstone_stalagmite_small", 1, 7);
        hideAll("CaveBiomes", "frozen_sandstone_stalagmite_base", 1, 7);
        hideAll("CaveBiomes", "frozen_sandstone_stalagmite_tip", 1, 7);
        hide("CaveBiomes", "dripping_water_stone", 1);
        hide("CaveBiomes", "raining_water_stone", 1);
        hide("CaveBiomes", "dripping_lava_stone", 1);
        hide("CaveBiomes", "raining_lava_stone", 1);
        hide("EnderIO", "blockConduitBundle");
        hideAll("ExtrabiomesXL", "tile.extrabiomes.crop.strawberry", 1, 7);
        hide("ForgeRelocation", "relocation.blockmovingrow");
        hide("amunra", "tile.blockFake");
        hide("GraviSuite", "BlockRelocatorPortal");
        hide("HardcoreEnderExpansion", "death_flower_pot");
        hide("HardcoreEnderExpansion", "corrupted_energy_high");
        hide("HardcoreEnderExpansion", "corrupted_energy_low");
        hide("HardcoreEnderExpansion", "item_special_effects");
        hide("HardcoreEnderExpansion", "enderman_head_block");
        hide("IC2", "blockDoorAlloy");
        hideAll("IC2", "blockWall");
        hide("IC2", "blockCable");
        hide("IC2", "blockDynamite");
        hide("IC2", "blockDynamiteRemote");
        hideAll("IC2", "plasmaLauncher");
        hide("Mantle", "mantleBook");
        hide("MorePlanet", "dark_air");
        hide("PortalGun", "Portal_BlockPortal");
        hide("PortalGun", "Portal_BlockMulti");
        hide("ProjRed|Illumination", "projectred.illumination.airousLight");
        hide("ProjectE", "pe_fire_projectile");
        hide("ProjectE", "pe_wind_projectile");
        hide("Railcraft", "firestone.recharge");
        hide("appliedenergistics2", "tile.BlockMatrixFrame");
        hide("appliedenergistics2", "tile.BlockCableBus");
        hide("appliedenergistics2", "tile.BlockPaint");
        hideAll("chisel", "bloodBrick");
        hideAll("flansmod", "flansWorkbench", 3, 15);
        hideAll("flansmod", "teamsSpawner", 3, 15);
        hide("malisisdoors", "item.custom_door");
        hide("opensecurity", "SecurityDoor");
        hide("opensecurity", "SecurityDoorPrivate");
        hideAll("voltzengine", "veGemOre");
        hideAll("voltzengine", "veStoneOre");
        hide("voltzengine", "veMultiBlock");
        hideAll("voltzengine", "gems");
        hideAll("voltzengine", "veSheetMetal");
        hideAll("voltzengine", "exSpawnEgg");
        hideAll("voltzengine", "veSheetMetalTools");
        hideAll("voltzengine", "veSimpleTools");
        hideAll("voltzengine", "veDustImpure");
        hideAll("voltzengine", "veRubble");
        hideAll("voltzengine", "veScrew");
        hideAll("voltzengine", "veWire");
    }

    private static void hide(String modId, String name) {
        API.hideItem(Utils.getItem(modId, name));
    }

    private static void hide(String modId, String name, int meta) {
        API.hideItem(Utils.getItem(modId, name, meta));
    }

    private static void hideAll(String modId, String name) {
        hide(modId, name, OreDictionary.WILDCARD_VALUE);
    }

    private static void hideAll(String modId, String name, int from, int to) {
        for (int meta = from; meta <= to; meta++) {
            hide(modId, name, meta);
        }
    }

}
