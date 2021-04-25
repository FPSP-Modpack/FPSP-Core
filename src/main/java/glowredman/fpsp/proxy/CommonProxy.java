package glowredman.fpsp.proxy;

import static glowredman.fpsp.FPSP.*;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.block.BlockFluidBase;
import glowredman.fpsp.block.BlockRedSandstone;
import glowredman.fpsp.block.BlockRedSandstoneSlab;
import glowredman.fpsp.block.BlockRedSandstoneStairs;
import glowredman.fpsp.handler.EventHandler;
import glowredman.fpsp.handler.OreDictHandler;
import glowredman.fpsp.handler.RecipesHandler;
import glowredman.fpsp.item.ItemBlockRedSandstone;
import glowredman.fpsp.item.ItemBlockRedSandstoneSlab;
import glowredman.fpsp.item.ItemCell;
import glowredman.fpsp.item.ItemIcon;
import glowredman.fpsp.item.ItemMeta;
import glowredman.fpsp.world.OreGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {

		// ITEMS
		itemMeta = new ItemMeta();
		itemIcon = new ItemIcon();
		itemCell = new ItemCell();
		GameRegistry.registerItem(itemMeta, itemMeta.getUnlocalizedName());
		GameRegistry.registerItem(itemIcon, "item.icon");
		GameRegistry.registerItem(itemCell, itemCell.getUnlocalizedName());

		// FLUIDS
		fluidTinPlasma = new Fluid("tinplasma");
		fluidNitrogenPlasma = new Fluid("nitrogenplasma");
		fluidZincPlasma = new Fluid("zincplasma");
		fluidCalciumPlasma = new Fluid("calciumplasma");
		fluidSulfurPlasma = new Fluid("sulfurplasma");
		fluidIronPlasma = new Fluid("ironplasma");
		FluidRegistry.registerFluid(fluidTinPlasma);
		FluidRegistry.registerFluid(fluidNitrogenPlasma);
		FluidRegistry.registerFluid(fluidZincPlasma);
		FluidRegistry.registerFluid(fluidCalciumPlasma);
		FluidRegistry.registerFluid(fluidSulfurPlasma);
		FluidRegistry.registerFluid(fluidIronPlasma);

		// FLUID BLOCKS
		blockCalciumPlasma = new BlockFluidBase(fluidCalciumPlasma);
		blockIronPlasma = new BlockFluidBase(fluidIronPlasma);
		blockNitrogenPlasma = new BlockFluidBase(fluidNitrogenPlasma);
		blockSulfurPlasma = new BlockFluidBase(fluidSulfurPlasma);
		blockTinPlasma = new BlockFluidBase(fluidTinPlasma);
		blockZincPlasma = new BlockFluidBase(fluidZincPlasma);
		GameRegistry.registerBlock(blockCalciumPlasma, fluidCalciumPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockIronPlasma, fluidIronPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockNitrogenPlasma, fluidNitrogenPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockSulfurPlasma, fluidSulfurPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockTinPlasma, fluidTinPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockZincPlasma, fluidZincPlasma.getUnlocalizedName());

		// BLOCKS
		blockRedSandstone = new BlockRedSandstone();
		blockRedSandstoneSlab = new BlockRedSandstoneSlab(false);
		blockRedSandstoneSlabDouble = new BlockRedSandstoneSlab(true);
		blockRedSandstoneStairs = new BlockRedSandstoneStairs();
		GameRegistry.registerBlock(blockRedSandstone, ItemBlockRedSandstone.class,
				blockRedSandstone.getUnlocalizedName());
		GameRegistry.registerBlock(blockRedSandstoneSlab, ItemBlockRedSandstoneSlab.class, "tile.redSandstoneSlab",
				blockRedSandstoneSlab, blockRedSandstoneSlabDouble);
		GameRegistry.registerBlock(blockRedSandstoneSlabDouble, ItemBlockRedSandstoneSlab.class,
				"tile.redSandstoneSlabDouble", blockRedSandstoneSlab, blockRedSandstoneSlabDouble);
		GameRegistry.registerBlock(blockRedSandstoneStairs, blockRedSandstoneStairs.getUnlocalizedName());

		itemCell.register();
	}

	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		OreDictHandler.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
		RecipesHandler.init();
	}

}
