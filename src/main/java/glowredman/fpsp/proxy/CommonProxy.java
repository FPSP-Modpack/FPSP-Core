package glowredman.fpsp.proxy;

import static glowredman.fpsp.FPSP.*;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.block.BlockFluidBase;
import glowredman.fpsp.block.BlockMeta;
import glowredman.fpsp.block.BlockRedSandstone;
import glowredman.fpsp.block.BlockRedSandstoneSlab;
import glowredman.fpsp.block.BlockRedSandstoneStairs;
import glowredman.fpsp.handler.CommonEventHandler;
import glowredman.fpsp.handler.OreDictHandler;
import glowredman.fpsp.handler.RecipesHandler;
import glowredman.fpsp.item.ItemBlockMeta;
import glowredman.fpsp.item.ItemBlockRedSandstone;
import glowredman.fpsp.item.ItemBlockRedSandstoneSlab;
import glowredman.fpsp.item.ItemCell;
import glowredman.fpsp.item.ItemFPSPSingularity;
import glowredman.fpsp.item.ItemIcon;
import glowredman.fpsp.item.ItemMeta;
import glowredman.fpsp.world.OreGenerator;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {

		// ITEMS
		itemMeta = new ItemMeta();
		itemIcon = new ItemIcon();
		itemSingularity = new ItemFPSPSingularity();
		itemCell = new ItemCell();
		GameRegistry.registerItem(itemMeta, itemMeta.getUnlocalizedName());
		GameRegistry.registerItem(itemIcon, "item.icon");
		GameRegistry.registerItem(itemCell, itemCell.getUnlocalizedName());
		GameRegistry.registerItem(itemSingularity, itemSingularity.getUnlocalizedName());

		// FLUIDS
		fluidTinPlasma = new Fluid("tinplasma");
		fluidNitrogenPlasma = new Fluid("nitrogenplasma");
		fluidZincPlasma = new Fluid("zincplasma");
		fluidCalciumPlasma = new Fluid("calciumplasma");
		fluidSulfurPlasma = new Fluid("sulfurplasma");
		fluidIronPlasma = new Fluid("ironplasma");
		fluidTinMolten = new Fluid("molten.tin");
		fluidZincMolten = new Fluid("molten.zinc");
		fluidIronMolten = new Fluid("molten.iron");
		FluidRegistry.registerFluid(fluidTinPlasma);
		FluidRegistry.registerFluid(fluidNitrogenPlasma);
		FluidRegistry.registerFluid(fluidZincPlasma);
		FluidRegistry.registerFluid(fluidCalciumPlasma);
		FluidRegistry.registerFluid(fluidSulfurPlasma);
		FluidRegistry.registerFluid(fluidIronPlasma);
		FluidRegistry.registerFluid(fluidTinMolten);
		FluidRegistry.registerFluid(fluidZincMolten);
		FluidRegistry.registerFluid(fluidIronMolten);

		// FLUID BLOCKS
		blockCalciumPlasma = new BlockFluidBase(fluidCalciumPlasma);
		blockIronPlasma = new BlockFluidBase(fluidIronPlasma);
		blockNitrogenPlasma = new BlockFluidBase(fluidNitrogenPlasma);
		blockSulfurPlasma = new BlockFluidBase(fluidSulfurPlasma);
		blockTinPlasma = new BlockFluidBase(fluidTinPlasma);
		blockZincPlasma = new BlockFluidBase(fluidZincPlasma);
		blockIronMolten = new BlockFluidBase(fluidIronMolten);
		blockTinMolten = new BlockFluidBase(fluidTinMolten);
		blockZincMolten = new BlockFluidBase(fluidZincMolten);
		GameRegistry.registerBlock(blockCalciumPlasma, fluidCalciumPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockIronPlasma, fluidIronPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockNitrogenPlasma, fluidNitrogenPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockSulfurPlasma, fluidSulfurPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockTinPlasma, fluidTinPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockZincPlasma, fluidZincPlasma.getUnlocalizedName());
		GameRegistry.registerBlock(blockIronMolten, fluidIronMolten.getUnlocalizedName());
		GameRegistry.registerBlock(blockTinMolten, fluidTinMolten.getUnlocalizedName());
		GameRegistry.registerBlock(blockZincMolten, fluidZincMolten.getUnlocalizedName());

		// BLOCKS
		blockMeta = new BlockMeta();
		blockRedSandstone = new BlockRedSandstone();
		blockRedSandstoneSlab = new BlockRedSandstoneSlab(false);
		blockRedSandstoneSlabDouble = new BlockRedSandstoneSlab(true);
		blockRedSandstoneStairs = new BlockRedSandstoneStairs();
		GameRegistry.registerBlock(blockMeta, ItemBlockMeta.class, blockMeta.getLocalizedName());
		GameRegistry.registerBlock(blockRedSandstone, ItemBlockRedSandstone.class,
				blockRedSandstone.getUnlocalizedName());
		GameRegistry.registerBlock(blockRedSandstoneSlab, ItemBlockRedSandstoneSlab.class, "tile.redSandstoneSlab",
				blockRedSandstoneSlab, blockRedSandstoneSlabDouble);
		GameRegistry.registerBlock(blockRedSandstoneSlabDouble, ItemBlockRedSandstoneSlab.class,
				"tile.redSandstoneSlabDouble", blockRedSandstoneSlab, blockRedSandstoneSlabDouble);
		GameRegistry.registerBlock(blockRedSandstoneStairs, blockRedSandstoneStairs.getUnlocalizedName());

		// FLUID CONTAINERS
		itemCell.register();
		
		// LOOT
		ChestGenHooks.getInfo("fpsp:lootStageI");
		ChestGenHooks.getInfo("fpsp:lootStageII");
		ChestGenHooks.getInfo("fpsp:lootStageIII");
		ChestGenHooks.getInfo("fpsp:lootStageIV");
	}

	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
		MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
		OreDictHandler.init();
	}

	public void postInit(FMLPostInitializationEvent event) {
		RecipesHandler.init();
	}

}
