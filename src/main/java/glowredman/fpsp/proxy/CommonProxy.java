package glowredman.fpsp.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.FPSP;
import glowredman.fpsp.world.FPSPWorldGenerator;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerItem(FPSP.ITEM, FPSP.ITEM.getUnlocalizedName());
		GameRegistry.registerWorldGenerator(new FPSPWorldGenerator(), 0);
	}

}
