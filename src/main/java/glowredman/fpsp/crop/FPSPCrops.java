package glowredman.fpsp.crop;

import java.util.Arrays;

import com.github.bartimaeusnek.cropspp.crops.cpp.SpacePlantCrop;

import glowredman.fpsp.Utils;
import glowredman.fpsp.item.ItemDefinitions;
import ic2.api.crops.Crops;
import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import techreborn.items.ItemDusts;
import techreborn.items.ItemDustsSmall;
import techreborn.items.ItemGems;

public class FPSPCrops {

	public static BaseCrop bauxia, blazereed, bobsyeruncleranks, corium, corpseplant, creeperweed, diareed, eggplant,
			enderbloom, evilOre, fertilia, flax, galvania, glowheat, godOfThunder, lazulia, liveroots, meatrose,
			milkwart, nickelback, oilberries, olivia, platina, pyrolusium, quantaria, reactoria, sapphirum, scheelium,
			slimeplant, spidernip, starwart, steeleafranks, tearstalks, titania, transformium, trollplant, withereed,
			zomplant;

	public static void init() {
		flax				= new BaseCrop("Flax",				"Eloraam",					2, 4,  200, 1, 4, 1, 1, 2, 0, 1, new String[] {"Silk",        "Tendrilly", "Addictive"},																								  new ItemStack(Items.string),																																																															   new ItemStack(Items.string),								null);
		oilberries			= new BaseCrop("Oilberries",		"Spacetoad",				9, 4,  200, 1, 4, 6, 1, 2, 1,12, new String[] {"Fire",        "Dark",      "Reed",       "Rotten",    "Coal",       "Oil"},																  ItemDefinitions.OilBerry.getItem(),																																																													   ItemDefinitions.OilBerry.getItem(),						null);
		bobsyeruncleranks	= new BaseCrop("Bobsyeruncleranks",	"GenerikB",				   11, 4,  200, 1, 4, 4, 0, 8, 2, 9, new String[] {"Shiny",       "Tendrilly", "Emerald",    "Beryllium", "Crystal"},						 Arrays.asList("oreEmerald",   "blockEmerald"),	  ItemDustsSmall.getSmallDustByName("emerald"),			 new ItemStack[] {new ItemStack(Items.emerald)},																																												   new ItemStack(Items.emerald),							Arrays.asList("Requires Emerald Ore or Block of Emerald to reach full growth."));
		diareed				= new BaseCrop("Diareed",			"Direwolf20",			   12, 4,  200, 1, 4, 5, 0,10, 2,10, new String[] {"Fire",        "Shiny",     "Reed",       "Coal",      "Diamond",    "Crystal"},			 Arrays.asList("oreDiamond",   "blockDiamond"),	  ItemDustsSmall.getSmallDustByName("diamond"),			 new ItemStack[] {new ItemStack(Items.diamond)},																																												   new ItemStack(Items.diamond),							Arrays.asList("Requires Diamond Ore or Block of Diamond to reach full growth."));
		withereed			= new BaseCrop("Withereed",			"CovertJaguar",				8, 4,  200, 1, 4, 2, 0, 4, 1, 3, new String[] {"Fire",        "Undead",    "Reed",       "Coal",      "Rotten",     "Wither"},			 Arrays.asList("oreCoal",	   "blockCoal"),	  IC2Items.getItem("coalDust"),							 new ItemStack[] {new ItemStack(Items.coal),				  new ItemStack(Items.coal)},																																		   new ItemStack(Items.coal),								Arrays.asList("Requires Coal Ore or Block of Coal to reach full growth."));
		blazereed			= new BaseCrop("Blazereed",			"Mr. Brain",				6, 4,  200, 1, 4, 0, 4, 1, 0, 0, new String[] {"Fire",        "Blaze",     "Reed",       "Sulfur"},																						  new ItemStack(Items.blaze_powder),					 new ItemStack[] {new ItemStack(Items.blaze_rod)},																																												   new ItemStack(Items.blaze_powder),						null);
		eggplant			= new BaseCrop("Eggplant",			"Link",						6, 3,  900, 2, 3, 0, 4, 1, 0, 0, new String[] {"Chicken",     "Egg",       "Food",       "Feather",   "Flower",     "Addictive"},														  new ItemStack(Items.egg),								 new ItemStack[] {new ItemStack(Items.chicken),				  new ItemStack(Items.feather),							   new ItemStack(Items.feather),	   new ItemStack(Items.feather)},										   new ItemStack(Items.egg),								null);
		corium				= new BaseCrop("Corium",			"Gregorius Techneticies",	6, 4,  200, 1, 4, 0, 2, 3, 1, 0, new String[] {"Cow",         "Silk",      "Tendrilly"},																								  new ItemStack(Items.leather),																																																															   new ItemStack(Items.leather),							null);
		corpseplant			= new BaseCrop("Corpseplant",		"Mr. Kenny",				5, 4,  200, 1, 4, 0, 2, 1, 0, 3, new String[] {"Toxic",       "Undead",    "Tendrilly",  "Food",      "Rotten"},																		  new ItemStack(Items.rotten_flesh),					 new ItemStack[] {new ItemStack(Items.dye, 1, 15),			  new ItemStack(Items.dye, 1, 15),						   new ItemStack(Items.bone)},																				   new ItemStack(Items.rotten_flesh),						null);
		creeperweed			= new BaseCrop("Creeperweed",		"General Spaz",				7, 4,  200, 1, 4, 3, 0, 5, 1, 3, new String[] {"Creeper",     "Tendrilly", "Explosive",  "Fire",      "Sulfur",     "Saltpeter", "Coal"},												  new ItemStack(Items.gunpowder),																																																														   new ItemStack(Items.gunpowder),							null);
		enderbloom			= new BaseCrop("Enderbloom",		"RichardG",				   10, 4,  200, 1, 4, 5, 0, 2, 1, 6, new String[] {"Ender",       "Flower",    "Shiny"},													Arrays.asList("blockEnder"),					  ItemDusts.getDustByName("enderpearl"),				 new ItemStack[] {new ItemStack(Items.ender_pearl),			  new ItemStack(Items.ender_pearl),						   new ItemStack(Items.ender_eye)},																			   new ItemStack(Items.ender_pearl),						Arrays.asList("Requires Block of Ender to reach full growth."));
		meatrose			= new BaseCrop("Meatrose",			"VintageBeef",				7, 4, 1500, 1, 4, 0, 4, 1, 3, 0, new String[] {"Food",        "Flower",    "Cow",        "Fish",      "Chicken",    "Pig"},																  new ItemStack(Items.dye, 1, 9),						 new ItemStack[] {new ItemStack(Items.beef),				  new ItemStack(Items.porkchop),						   new ItemStack(Items.chicken),	   new ItemStack(Items.fish)},											   new ItemStack(Items.porkchop),							null);
		milkwart			= new BaseCrop("Milkwart",			"Mr. Brain",				6, 3,  900, 1, 3, 0, 3, 0, 1, 0, new String[] {"Food",        "Milk",      "Cow"},																										  ItemDefinitions.Milkwart.getItem(),																																																													   ItemDefinitions.Milkwart.getItem(),						null);
		slimeplant			= new BaseCrop("Slimeplant",		"Neowulf",					6, 4,  200, 3, 4, 3, 0, 0, 0, 2, new String[] {"Slime",       "Bouncy",    "Sticky",     "Bush"},																						  new ItemStack(Items.slime_ball),																																																														   new ItemStack(Items.slime_ball),							null);
		spidernip			= new BaseCrop("Spidernip",			"Mr. Kenny",				4, 4,  600, 1, 4, 2, 1, 4, 1, 3, new String[] {"Toxic",       "Silk",      "Spider",     "Flower",    "Ingredient", "Addictive"},														  new ItemStack(Items.string),							 new ItemStack[] {new ItemStack(Items.spider_eye),			  new ItemStack(Blocks.web)},																																		   new ItemStack(Blocks.web),								null);
		tearstalks			= new BaseCrop("Tearstalks",		"Neowulf",					8, 4,  200, 1, 4, 1, 2, 0, 0, 0, new String[] {"Healing",     "Nether",    "Ingredient", "Reed",      "Ghast"},																			  new ItemStack(Items.ghast_tear),																																																														   new ItemStack(Items.ghast_tear),							null);
		steeleafranks		= new BaseCrop("Steeleafranks",		"Benimatic",			   10, 4,  200, 1, 4, 3, 0, 7, 2, 8, new String[] {"Metal",       "Tendrilly", "Iron"},														 Arrays.asList("blockSteeleaf"),				  Utils.getItem("ingotSteeleaf"),						 null,																																																							   Utils.getItem("ingotSteeleaf"),							Arrays.asList("Requires Steeleaves to reach full growth."));
		liveroots			= new BaseCrop("Liveroots",			"Benimatic",				8, 4,  200, 1, 4, 2, 0, 5, 2, 6, new String[] {"Wood",        "Tendrilly"},																												  Utils.getItem("TwilightForest", "item.liveRoot"),																																																										   Utils.getItem("TwilightForest", "item.liveRoot"),		null);
		trollplant			= new BaseCrop("Trollplant",		"unknown",					6, 5, 1000, 1, 4, 0, 0, 5, 2, 8, new String[] {"Troll",       "Bad",       "Scrap"},													 Arrays.asList("orePlutonium", "blockPlutonium"), ItemDustsSmall.getSmallDustByName("plutonium"),		 new ItemStack[] {IC2Items.getItem("plantBall"),			  IC2Items.getItem("scrap"),							   IC2Items.getItem("smallPlutonium")},																		   ItemDustsSmall.getSmallDustByName("plutonium"),			Arrays.asList("Requires Plutonium Ore or Plutonium Block to reach full growth."));
		lazulia				= new BaseCrop("Lazulia",			"unknown",					7, 4,  200, 2, 4, 4, 2, 5, 7, 4, new String[] {"Shiny",       "Bad",       "Crystal",    "Lapis"},										 Arrays.asList("oreLapis",	   "blockLapis"),	  IC2Items.getItem("lapiDust"),							 new ItemStack[] {new ItemStack(Items.dye, 1, 4)},																																												   new ItemStack(Items.dye, 1, 4),							Arrays.asList("Requires Lapis Lazuli Ore or Lapis Lazuli Block to reach full growth."));
		glowheat			= new BaseCrop("Glowheat",			"unknown",				   10, 7,  200, 5, 7, 3, 3, 3, 5, 4, new String[] {"Light",       "Shiny",     "Crystal"},													 Arrays.asList("glowstone"),					  new ItemStack(Items.glowstone_dust),					 null,																																																							   new ItemStack(Items.glowstone_dust),						Arrays.asList("Requires Glowstone to reach full growth."));
		fertilia			= new BaseCrop("Fertilia",			"unknown",					3, 4,  200, 1, 4, 2, 3, 5, 4, 8, new String[] {"Growth",      "Healing",   "Flower"},																									  ItemDustsSmall.getSmallDustByName("calcite"),			 new ItemStack[] {IC2Items.getItem("fertilizer"),			  ItemDustsSmall.getSmallDustByName("tricalciumphosphate")},																										   IC2Items.getItem("fertilizer"),							null);
		bauxia				= new BaseCrop("Bauxia",			"unknown",					6, 3,  200, 2, 3, 5, 0, 2, 3, 3, new String[] {"Metal",       "Aluminium", "Reed",       "Aluminium"},									 Arrays.asList("oreAluminium", "blockAluminium"), ItemDustsSmall.getSmallDustByName("aluminium"),		 null,																																																							   ItemDustsSmall.getSmallDustByName("aluminium"),			Arrays.asList("Requires Aluminium Ore or Block of Aluminium to reach full growth."));
		titania				= new BaseCrop("Titania",			"unknown",					9, 3,  200, 2, 3, 5, 0, 3, 3, 1, new String[] {"Metal",       "Heavy",     "Reed",       "Titanium"},									 Arrays.asList("oreIlmenite",  "blockTitanium"),  ItemDustsSmall.getSmallDustByName("titanium"),		 null,																																																							   ItemDustsSmall.getSmallDustByName("titanium"),			Arrays.asList("Requires Ilmenite Ore or Block of Titanium to reach full growth."));
		reactoria			= new BaseCrop("Reactoria",			"unknown",				   12, 4,  200, 2, 4, 4, 0, 1, 2, 1, new String[] {"Radioactive", "Metal",     "Danger",     "Uranium"},									 Arrays.asList("oreUranium",   "blockUranium"),	  ItemDustsSmall.getSmallDustByName("uranium"),			 new ItemStack[] {Utils.getItem("crushedUranium")},																																												   ItemDustsSmall.getSmallDustByName("uranium"),			Arrays.asList("Requires Uranium Ore or Block of Uranium to reach full growth."));
		godOfThunder		= new BaseCrop("God of Thunder",	"unknown",					9, 4,  200, 2, 4, 3, 0, 5, 1, 2, new String[] {"Radioactive", "Metal",     "Coal",       "Thorium"},																					  ItemDustsSmall.getSmallDustByName("thorium"),			 																																																								   ItemDustsSmall.getSmallDustByName("thorium"),			null);
		transformium		= new BaseCrop("Transformium",		"unknown",				   12, 4, 2500, 1, 4, 6, 2, 1, 6, 1, new String[] {"Transform",   "Coal",      "Reed"},																										  ItemDefinitions.UUABerry.getItem(),					 new ItemStack[] {ItemDefinitions.UUABerry.getItem(),		  ItemDefinitions.UUABerry.getItem(),					   ItemDefinitions.UUABerry.getItem(), ItemDefinitions.UUMBerry.getItem()},									   ItemDefinitions.UUMBerry.getItem(),						null);
		starwart			= new BaseCrop("Starwart",			"unknown",				   12, 4, 4000, 1, 4, 2, 0, 0, 1, 0, new String[] {"Wither",      "Nether",    "Undead",     "Netherstar"},									 Arrays.asList("blockNetherStar"),				  ItemDustsSmall.getSmallDustByName("coal"),			 new ItemStack[] {new ItemStack(Items.coal),				  new ItemStack(Items.skull),							   new ItemStack(Items.skull, 1, 1),   new ItemStack(Items.skull, 1, 1),	new ItemStack(Items.nether_star)}, new ItemStack(Items.nether_star),						Arrays.asList("Requires Nether Star Block to reach full growth."));
		zomplant			= new BaseCrop("Zomplant",			"unknown",					3, 4,  200, 1, 4, 1, 3, 4, 2, 6, new String[] {"Zombie",      "Rotten",    "Undead"},																									  new ItemStack(Items.rotten_flesh),																																																													   new ItemStack(Items.rotten_flesh),						null);
		nickelback			= new BaseCrop("Nickelback",		"unknown",					5, 3,  200, 2, 3, 3, 0, 1, 2, 2, new String[] {"Metal",       "Fire",      "Alloy"},													 Arrays.asList("oreNickel",	   "blockNickel"),	  ItemDustsSmall.getSmallDustByName("nickel"),			 null,																																																							   ItemDustsSmall.getSmallDustByName("nickel"),				Arrays.asList("Requires Nickel Ore or Block of Nickel to reach full growth."));
		galvania			= new BaseCrop("Galvania",			"unknown",					6, 3,  200, 2, 3, 3, 0, 2, 2, 3, new String[] {"Metal",       "Alloy",     "Bush"},														 Arrays.asList("blockZinc"),					  ItemDustsSmall.getSmallDustByName("zinc"),			 null,																																																							   ItemDustsSmall.getSmallDustByName("zinc"),				Arrays.asList("Requires Block of Zinc to reach full growth."));
		evilOre				= new BaseCrop("Evil Ore",			"unknown",					8, 4,  200, 3, 4, 4, 0, 2, 1, 3, new String[] {"Crystal",     "Fire",      "Nether"},													 Arrays.asList("oreQuartz",	   "blockQuartz"),	  Utils.getItem("dustTinyQuartz"),						 new ItemStack[] {new ItemStack(Items.quartz),				  Utils.getItem("dustQuartz"),							   Utils.getItem("dustCertusQuartz")},																		   new ItemStack(Items.quartz),								Arrays.asList("Requires Nether Quartz Ore or Block of Quartz to reach full growth."));
		olivia				= new BaseCrop("Olivia",			"unknown",					2, 4,  200, 3, 4, 1, 0, 1, 4, 0, new String[] {"Crystal",     "Shiny",     "Processing", "Olivine"},									 Arrays.asList("oreOlivine",   "blockOlivine"),	  ItemDustsSmall.getSmallDustByName("olivine"),			 new ItemStack[] {ItemGems.getGemByName("olivine")},																																											   ItemGems.getGemByName("olivine"),						Arrays.asList("Requires Olivine Ore or Block of Olivine to reach full growth."));
		sapphirum			= new BaseCrop("Sapphirum",			"unknown",					4, 4,  200, 3, 4, 1, 0, 1, 5, 0, new String[] {"Crystal",     "Shiny",     "Metal",      "Sapphire"},									 Arrays.asList("oreSapphire",  "blockSapphire"),  ItemDustsSmall.getSmallDustByName("sapphire"),		 new ItemStack[] {ItemGems.getGemByName("sapphire")},																																											   ItemGems.getGemByName("sapphire"),						Arrays.asList("Requires Sapphire Ore or Block of Sapphire to reach full growth."));
		pyrolusium			= new BaseCrop("Pyrolusium",		"unknown",				   12, 3,  200, 2, 3, 1, 0, 1, 1, 0, new String[] {"Metal",       "Clean",     "Bush",       "Manganese"},									 Arrays.asList("blockManganese"),				  ItemDustsSmall.getSmallDustByName("manganese"),		 null,																																																							   ItemDustsSmall.getSmallDustByName("manganese"),			Arrays.asList("Requires Manganese Block to reach full growth."));
		scheelium			= new BaseCrop("Scheelium",			"unknown",				   12, 3,  200, 2, 3, 3, 0, 1, 1, 0, new String[] {"Metal",       "Hard",      "Bush",       "Tungsten"},									 Arrays.asList("oreTungsten",  "blockTungsten"),  ItemDustsSmall.getSmallDustByName("tungsten"),		 null,																																																							   ItemDustsSmall.getSmallDustByName("tungsten"),			Arrays.asList("Requires Tungsten Ore or Block of Tungsten to reach full growth."));
		platina				= new BaseCrop("Platina",			"unknown",				   11, 4,  200, 1, 4, 3, 0, 0, 3, 0, new String[] {"Metal",       "Shiny",     "Reed",       "Platinum"},									 Arrays.asList("orePlatinum", "blockPlatinum"),	  ItemDustsSmall.getSmallDustByName("platinum"),		 null,																																																							   ItemDustsSmall.getSmallDustByName("platinum"),			Arrays.asList("Requires Platinum Ore or Block of Platinum to reach full growth."));
		quantaria			= new BaseCrop("Quantaria",			"unknown",				   12, 4, 1000, 1, 4, 4, 0, 0, 1, 0, new String[] {"Metal",       "Iridium",   "Reed"},														 Arrays.asList("oreIridium",  "blockIridium"),	  Utils.getItem("dustTinyIridium"),						 new ItemStack[] {Utils.getItem("dustSmallOsmium")},																																											   Utils.getItem("dustTinyIridium"),						Arrays.asList("Requires Iridium Ore or Block of Iridium to reach full growth."));
		
		
		Crops.instance.registerBaseSeed(ItemDefinitions.Milkwart.getItem(), milkwart, 1, 1, 1, 1);
		Crops.instance.registerCrop(new SpacePlantCrop());
	}

}