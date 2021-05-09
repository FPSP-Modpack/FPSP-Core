package glowredman.fpsp;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import glowredman.fpsp.item.ItemCell;
import glowredman.fpsp.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;

@Mod(acceptedMinecraftVersions = "1.7.10", dependencies = FPSP.DEPENDENCIES, modid = FPSP.MODID, name = FPSP.MODNAME, version = FPSP.VERSION)
public class FPSP {

	public static final String DEPENDENCIES = "after:appliedenergistics2;after:BloodArsenal;after:Botania;before:eternalsingularity;after:magicalcrops;after:ProjRed|Exploration;after:SSTOW;after:TwilightForest";
	public static final String MODID = "fpsp";
	public static final String MODNAME = "FPSP Core";
	public static final String VERSION = "@version@";

	public static Item itemMeta;
	public static Item itemIcon;
	public static Item itemSingularity;
	public static ItemCell itemCell;
	public static Fluid fluidTinPlasma;
	public static Fluid fluidNitrogenPlasma;
	public static Fluid fluidZincPlasma;
	public static Fluid fluidCalciumPlasma;
	public static Fluid fluidSulfurPlasma;
	public static Fluid fluidIronPlasma;
	public static Fluid fluidTinMolten;
	public static Fluid fluidZincMolten;
	public static Fluid fluidIronMolten;
	public static Block blockMeta;
	public static Block blockRedSandstone;
	public static Block blockRedSandstoneSlab;
	public static Block blockRedSandstoneSlabDouble;
	public static Block blockRedSandstoneStairs;
	public static Block blockTinPlasma;
	public static Block blockNitrogenPlasma;
	public static Block blockZincPlasma;
	public static Block blockCalciumPlasma;
	public static Block blockSulfurPlasma;
	public static Block blockIronPlasma;
	public static Block blockTinMolten;
	public static Block blockZincMolten;
	public static Block blockIronMolten;

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
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
