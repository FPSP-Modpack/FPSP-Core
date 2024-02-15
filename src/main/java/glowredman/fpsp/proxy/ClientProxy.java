package glowredman.fpsp.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import fox.spiteful.avaritia.render.FancyHaloRenderer;
import glowredman.fpsp.FPSP;
import tconstruct.client.HealthBarRenderer;

public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        MinecraftForgeClient.registerItemRenderer(FPSP.itemSingularity, new FancyHaloRenderer());

        final HealthBarRenderer healthBarRenderer = new HealthBarRenderer();
        MinecraftForge.EVENT_BUS.register(healthBarRenderer);
        FMLCommonHandler.instance()
            .bus()
            .register(healthBarRenderer);
    }

}
