package glowredman.fpsp.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.railcraft.common.worldgen.SulfurGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

public class CommonEventHandler {

	@SubscribeEvent
	public void onGenerateMinable(GenerateMinable event) {
		if (event.world.provider.dimensionId == 7 && event.type == SulfurGenerator.EVENT_TYPE)
			event.setCanceled(true);
	}

}
