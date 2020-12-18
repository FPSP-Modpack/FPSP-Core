package glowredman.fpsp;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import glowredman.fpsp.item.ItemMeta;
import glowredman.fpsp.proxy.CommonProxy;
import net.minecraft.item.Item;

@Mod(acceptedMinecraftVersions = "1.7.10", modid = FPSP.MODID, name = FPSP.MODNAME, version = FPSP.VERSION)
public class FPSP {
	
	public static final String MODID = "fpsp";
	public static final String MODNAME = "FPSP Core";
	public static final String VERSION = "@version@";
	
	public static final Item ITEM = new ItemMeta();
	
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
	public static void postInit(FMLPostInitializationEvent event) {
		
		RecipeHandler.init();
	}
}