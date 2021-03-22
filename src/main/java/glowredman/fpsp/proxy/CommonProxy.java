package glowredman.fpsp.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.FPSP;
import glowredman.fpsp.handler.EventHandler;
import glowredman.fpsp.world.FPSPWorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		GameRegistry.registerItem(FPSP.ITEM_META, FPSP.ITEM_META.getUnlocalizedName());
		GameRegistry.registerItem(FPSP.ITEM_CELL, FPSP.ITEM_CELL.getUnlocalizedName());

		FluidRegistry.registerFluid(FPSP.TIN_PLASMA);
		FluidRegistry.registerFluid(FPSP.NITROGEN_PLASMA);
		FluidRegistry.registerFluid(FPSP.ZINC_PLASMA);
		FluidRegistry.registerFluid(FPSP.CALCIUM_PLASMA);
		FluidRegistry.registerFluid(FPSP.SULFUR_PLASMA);
		FluidRegistry.registerFluid(FPSP.IRON_PLASMA);

		GameRegistry.registerWorldGenerator(new FPSPWorldGenerator(), 0);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

}
