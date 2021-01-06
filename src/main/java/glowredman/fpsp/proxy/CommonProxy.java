package glowredman.fpsp.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.FPSP;
import glowredman.fpsp.handler.FPSPEventHandler;
import glowredman.fpsp.world.FPSPWorldGenerator;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerItem(FPSP.ITEM, FPSP.ITEM.getUnlocalizedName());
		GameRegistry.registerWorldGenerator(new FPSPWorldGenerator(), 0);
		MinecraftForge.EVENT_BUS.register(new FPSPEventHandler());
	}

}
