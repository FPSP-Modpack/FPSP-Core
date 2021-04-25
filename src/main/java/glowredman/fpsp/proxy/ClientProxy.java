package glowredman.fpsp.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import fox.spiteful.avaritia.render.FancyHaloRenderer;
import glowredman.fpsp.FPSP;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		MinecraftForgeClient.registerItemRenderer(FPSP.itemSingularity, new FancyHaloRenderer());
	}

}
