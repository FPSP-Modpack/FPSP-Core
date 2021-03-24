package glowredman.fpsp.handler;

import static glowredman.fpsp.item.ItemDefinitions.*;

import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.Utils;
import glowredman.fpsp.item.ItemDefinitions;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

	public static void init() {
		registerItem("oreHeeStardust", "HardcoreEnderExpansion", "sphalerite", 1);
		registerItem("itemSkull", "HardcoreEnderExpansion", "enderman_head");
		registerItem("skullEnderman", "HardcoreEnderExpansion", "enderman_head");
		registerItem("obsidianRod", "HardcoreEnderExpansion", "obsidian_rod");

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
		registerDust(EveniumDust);
		registerDust(ChioniteDust);
		registerDust(BacterialFossilDust);
		registerDust(PurpleGemDust);
		registerDust(AlphereDust);
		OreDictionary.registerOre("dustPromethean", XathianPrometheanDust.getItem());
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
