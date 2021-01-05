package glowredman.fpsp.handler;

import glowredman.fpsp.Utils;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {
	
	public static void init() {
		OreDictionary.registerOre("oreHeeStardust", Utils.getItem("HardcoreEnderExpansion", "sphalerite", 1));
	}

}
