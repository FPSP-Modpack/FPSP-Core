package glowredman.fpsp;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import glowredman.fpsp.block.BlockRedSandstone;
import glowredman.fpsp.block.BlockRedSandstoneSlab;
import glowredman.fpsp.block.BlockRedSandstoneStairs;
import glowredman.fpsp.handler.OreDictHandler;
import glowredman.fpsp.handler.RecipesHandler;
import glowredman.fpsp.item.ItemCell;
import glowredman.fpsp.item.ItemMeta;
import glowredman.fpsp.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

@Mod(acceptedMinecraftVersions = "1.7.10", dependencies = FPSP.DEPENDENCIES, modid = FPSP.MODID, name = FPSP.MODNAME, version = FPSP.VERSION)
public class FPSP {

	public static final String DEPENDENCIES = "after:magicalcrops;after:ProjRed|Exploration;";
	public static final String MODID = "fpsp";
	public static final String MODNAME = "FPSP Core";
	public static final String VERSION = "@version@";

	public static final Item ITEM_META = new ItemMeta();
	public static final ItemCell ITEM_CELL = new ItemCell();
	public static final Fluid TIN_PLASMA = new Fluid("tinplasma");
	public static final Fluid NITROGEN_PLASMA = new Fluid("nitrogenplasma");
	public static final Fluid ZINC_PLASMA = new Fluid("zincplasma");
	public static final Fluid CALCIUM_PLASMA = new Fluid("calciumplasma");
	public static final Fluid SULFUR_PLASMA = new Fluid("sulfurplasma");
	public static final Fluid IRON_PLASMA = new Fluid("ironplasma");
	public static final Block RED_SANDSTONE = new BlockRedSandstone();
	public static final Block RED_SANDSTONE_SLAB = (Block) new BlockRedSandstoneSlab(false);
	public static final Block RED_SANDSTONE_SLAB_DOUBLE = (Block) new BlockRedSandstoneSlab(true);
	public static final Block RED_SANDSTONE_STAIRS = new BlockRedSandstoneStairs();
	public static Block TIN_PLASMA_BLOCK;
	public static Block NITROGEN_PLASMA_BLOCK;
	public static Block ZINC_PLASMA_BLOCK;
	public static Block CALCIUM_PLASMA_BLOCK;
	public static Block SULFUR_PLASMA_BLOCK;
	public static Block IRON_PLASMA_BLOCK;

	@Instance
	public static FPSP instance;

	@SidedProxy(clientSide = "glowredman.fpsp.proxy.ClientProxy", serverSide = "glowredman.fpsp.proxy.CommonProxy")
	public static CommonProxy proxy;

	public static Logger logger;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
		OreDictHandler.init();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		RecipesHandler.init();
	}
}
