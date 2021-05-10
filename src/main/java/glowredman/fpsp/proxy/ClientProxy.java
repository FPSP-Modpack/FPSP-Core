package glowredman.fpsp.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import fox.spiteful.avaritia.render.FancyHaloRenderer;
import glowredman.fpsp.FPSP;
import glowredman.fpsp.handler.ClientEventHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		MinecraftForgeClient.registerItemRenderer(FPSP.itemSingularity, new FancyHaloRenderer());

		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
	}

}
