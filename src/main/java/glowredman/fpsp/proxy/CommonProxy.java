package glowredman.fpsp.proxy;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.BlockFluidBase;
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
		
		FPSP.CALCIUM_PLASMA_BLOCK = new BlockFluidBase(FPSP.CALCIUM_PLASMA);
		FPSP.IRON_PLASMA_BLOCK = new BlockFluidBase(FPSP.IRON_PLASMA);
		FPSP.NITROGEN_PLASMA_BLOCK = new BlockFluidBase(FPSP.NITROGEN_PLASMA);
		FPSP.SULFUR_PLASMA_BLOCK = new BlockFluidBase(FPSP.SULFUR_PLASMA);
		FPSP.TIN_PLASMA_BLOCK = new BlockFluidBase(FPSP.TIN_PLASMA);
		FPSP.ZINC_PLASMA_BLOCK = new BlockFluidBase(FPSP.ZINC_PLASMA);
		
		GameRegistry.registerBlock(FPSP.CALCIUM_PLASMA_BLOCK, FPSP.CALCIUM_PLASMA.getUnlocalizedName());
		GameRegistry.registerBlock(FPSP.IRON_PLASMA_BLOCK, FPSP.IRON_PLASMA.getUnlocalizedName());
		GameRegistry.registerBlock(FPSP.NITROGEN_PLASMA_BLOCK, FPSP.NITROGEN_PLASMA.getUnlocalizedName());
		GameRegistry.registerBlock(FPSP.SULFUR_PLASMA_BLOCK, FPSP.SULFUR_PLASMA.getUnlocalizedName());
		GameRegistry.registerBlock(FPSP.TIN_PLASMA_BLOCK, FPSP.TIN_PLASMA.getUnlocalizedName());
		GameRegistry.registerBlock(FPSP.ZINC_PLASMA_BLOCK, FPSP.ZINC_PLASMA.getUnlocalizedName());
		
		FPSP.ITEM_CELL.register();

		GameRegistry.registerWorldGenerator(new FPSPWorldGenerator(), 0);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

}
