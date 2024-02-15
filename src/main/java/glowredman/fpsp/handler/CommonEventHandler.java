package glowredman.fpsp.handler;

import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.railcraft.common.worldgen.SulfurGenerator;

public class CommonEventHandler {

    @SubscribeEvent
    public void onGenerateMinable(GenerateMinable event) {
        if (event.world.provider.dimensionId == 7 && event.type == SulfurGenerator.EVENT_TYPE) event.setCanceled(true);
    }

}
