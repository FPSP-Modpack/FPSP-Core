package glowredman.fpsp.handler;

import static glowredman.fpsp.item.ItemDefinitions.*;

import cpw.mods.fml.common.registry.GameRegistry;
import galaxyspace.BarnardsSystem.BRItems;
import galaxyspace.core.register.GSBlocks;
import glowredman.fpsp.FPSP;
import glowredman.fpsp.Utils;
import glowredman.fpsp.block.BlockMeta;
import glowredman.fpsp.item.ItemDefinitions;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import mods.railcraft.common.items.RailcraftItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

	public static void init() {
		registerItem("oreHeeStardust", "HardcoreEnderExpansion", "sphalerite", 1);
		registerItem("itemSkull", "HardcoreEnderExpansion", "enderman_head");
		registerItem("skullEnderman", "HardcoreEnderExpansion", "enderman_head");
		registerItem("obsidianRod", "HardcoreEnderExpansion", "obsidian_rod");
		registerItem("blockCrystal", "wizardry", "crystal_block");
		registerItem("blockSalt", "harvestcraft", "spamcompressedsaltBlockalt");
		registerItem("blockSoulium", "SSTOW", "sstow_soulium_block");
		registerItem("blockPolongniusMeteoricIron", "MorePlanet", "polongnius_block", 10);
		registerItem("blockKoentusMeteoricIron", "MorePlanet", "koentus_block", 15);
		registerItem("gemFlonium", "MorePlanet", "polongnius_item");
		registerItem("gemMineral", "MorePlanet", "fronos_item");
		registerItem("gemXeonium", "MorePlanet", "pluto_item");
		registerItem("itemBacterialFossil", "MorePlanet", "koentus_item", 2);
		registerItem("cropBerry", "MorePlanet", "fronos_food", 1);
		registerItem("cropInfectedVines", "MorePlanet", "infected_vine");
		registerItem("cropInfectedVines", "MorePlanet", "infected_cavernous_vine");
		registerItem("listAllmushroom", "BiomesOPlenty", "mushrooms", OreDictionary.WILDCARD_VALUE);
		registerItem("listAllmushroom", "Botania", "mushroom", OreDictionary.WILDCARD_VALUE);
		registerItem("listAllmushroom", "MorePlanet", "fronos_flower", 4);
		registerItem("listAllmushroom", "MorePlanet", "fronos_flower", 7);
		registerItem("listAllmushroom", "wildcaves3", "Flora", OreDictionary.WILDCARD_VALUE);
		registerItem("listAllmushroom", "Natura", "Glowshroom", OreDictionary.WILDCARD_VALUE);
		registerItem("listAllmushroom", "TwilightForest", "tile.TFPlant", 9);
		registerItem("dustQuartz", "appliedenergistics2", "item.ItemMultiMaterial", 3);

		registerDust(DeshDust);
		registerDust(OriharukonDust);
		registerDust(MeteoricIronDust);
		registerDust(PalladiumDust);
		registerDust(EuropiumDust);
		registerDust(MetalMeteoricIronDust);
		registerDust(MetallicDust);
		registerDust(MercurianIronDust);
		registerDust(CitrineDust);
		registerDust(FrozenIronDust);
		registerDust(RhodiumDust);
		registerDust(PetaliteDust);
		registerDust(JadeDust);
		registerDust(AdamantiteDust);
		registerDust(WhiteCrystalDust);
		registerDust(OnyxDust);
		registerDust(BismuthDust);
		registerDust(KoentusMeteoricIronDust);
		registerDust(QuontoniumDust);
		registerDust(FronisiumDust);
		registerDust(CentauriumDust);
		registerDust(PolongniusMeteoricIronDust);
		registerDust(FloniumDust);
		registerDust(PinkQuartzDust);
		registerDust(CarnelianDust);
		registerDust(ChalcedonyDust);
		registerDust(IchoriusDust);
		registerDust(RedGemDust);
		registerDust(EMPDust);
		registerDust(NoriumDust);
		registerDust(ViriniumDust);
		registerDust(NameriumDust);
		registerDust(BlackDiamondDust);
		registerDust(HeartiumDust);
		registerDust(ChioniteDust);
		registerDust(BacterialFossilDust);
		registerDust(PurpleGemDust);
		registerDust(AlphereDust);
		OreDictionary.registerOre("dustPromethean", XathianPrometheanDust.getItem());
		OreDictionary.registerOre("circuitUltimate", QuantumMainframe.getItem());
		OreDictionary.registerOre("sandstone", new ItemStack(FPSP.blockRedSandstone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("redSandstone", new ItemStack(FPSP.blockRedSandstone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("slabSandstone", FPSP.blockRedSandstoneSlab);
		OreDictionary.registerOre("slabRedSandstone", FPSP.blockRedSandstoneSlab);
		OreDictionary.registerOre("blockLead", new ItemStack(GSBlocks.MetalsBlock));
		OreDictionary.registerOre("blockAdamantite", new ItemStack(GSBlocks.MetalsBlock, 1, 1));
		OreDictionary.registerOre("blockCobalt", new ItemStack(GSBlocks.MetalsBlock, 1, 2));
		OreDictionary.registerOre("blockMagnesium", new ItemStack(GSBlocks.MetalsBlock, 1, 3));
		OreDictionary.registerOre("blockMithril", new ItemStack(GSBlocks.MetalsBlock, 1, 4));
		OreDictionary.registerOre("blockNickel", new ItemStack(GSBlocks.MetalsBlock, 1, 5));
		OreDictionary.registerOre("blockOriharukon", new ItemStack(GSBlocks.MetalsBlock, 1, 6));
		OreDictionary.registerOre("blockPlatinum", new ItemStack(GSBlocks.MetalsBlock, 1, 7));
		OreDictionary.registerOre("blockTungsten", new ItemStack(GSBlocks.MetalsBlock, 1, 8));
		OreDictionary.registerOre("blockCopper", new ItemStack(GSBlocks.MetalsBlock, 1, 9));
		OreDictionary.registerOre("cropUnknownFruits", BRItems.BarnardaStrawberry);
		OreDictionary.registerOre("blockDesh", new ItemStack(MarsBlocks.marsBlock, 1, 8));
		OreDictionary.registerOre("plateIron", new ItemStack(RailcraftItem.plate.item(), 1, 0));
		OreDictionary.registerOre("plateSteel", new ItemStack(RailcraftItem.plate.item(), 1, 1));
		OreDictionary.registerOre("plateTin", new ItemStack(RailcraftItem.plate.item(), 1, 2));
		OreDictionary.registerOre("plateCopper", new ItemStack(RailcraftItem.plate.item(), 1, 3));
		OreDictionary.registerOre("plateLead", new ItemStack(RailcraftItem.plate.item(), 1, 4));

		for (int i = 0; i < BlockMeta.types.length; i++) {
			OreDictionary.registerOre("block" + BlockMeta.types[i], new ItemStack(FPSP.blockMeta, 1, i));
		}
	}

	private static void registerItem(String oreDict, String modID, String itemName) {
		OreDictionary.registerOre(oreDict, GameRegistry.findItem(modID, itemName));
	}

	private static void registerItem(String oreDict, String modID, String itemName, int meta) {
		OreDictionary.registerOre(oreDict, Utils.getItem(modID, itemName, meta));
	}

	private static void registerDust(ItemDefinitions item) {
		OreDictionary.registerOre("dust" + item.getName().replace("Dust", ""), item.getItem());
	}

}
