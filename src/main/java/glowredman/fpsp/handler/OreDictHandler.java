package glowredman.fpsp.handler;

import glowredman.fpsp.Utils;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

	public static void init() {
		OreDictionary.registerOre("oreHeeStardust", Utils.getItem("HardcoreEnderExpansion", "sphalerite", 1));
		OreDictionary.registerOre("itemSkull", Utils.getItem("HardcoreEnderExpansion", "enderman_head"));
		OreDictionary.registerOre("skullEnderman", Utils.getItem("HardcoreEnderExpansion", "enderman_head"));
		OreDictionary.registerOre("obsidianRod", Utils.getItem("HardcoreEnderExpansion", "obsidian_rod"));
	}

}
