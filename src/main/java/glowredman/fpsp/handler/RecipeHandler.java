package glowredman.fpsp.handler;

import static glowredman.fpsp.item.ItemDefinitions.*;

import cpw.mods.fml.common.registry.GameRegistry;
import glowredman.fpsp.Utils;
import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeInputOreDict;
import ic2.api.recipe.Recipes;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import reborncore.common.util.OreUtil;
import techreborn.api.recipe.machines.CentrifugeRecipe;
import techreborn.items.ItemDusts;

public class RecipeHandler {

	public static void init() {

		// Shaped Recipes

		GameRegistry.addShapedRecipe(new ItemStack(Items.bread, 9), "HHH", 'H', Blocks.hay_block);

		// Centrifuge Recipes - Dust to cooler Dust(s)

		// Moon Rock Dust
		addCentrifugeRecipe(MoonRockDust.getItem(32), null, MeteoricIronDust.getItem(), getIC2Item("copperDust", 2),
				IC2Items.getItem("tinDust"), null, 300, 25);

		// Mars Rock Dust
		addCentrifugeRecipe(MarsRockDust.getItem(32), null, DeshDust.getItem(), getIC2Item("copperDust", 2),
				IC2Items.getItem("tinDust"), getIC2Item("ironDust", 3), 300, 25);

		// Phobos Rock Dust
		addCentrifugeRecipe(PhobosRockDust.getItem(32), null, OreUtil.getStackFromName("dustCoablt", 2),
				getIC2Item("copperDust", 2), IC2Items.getItem("tinDust"), getIC2Item("ironDust", 3), 300, 25);

		// Deimos Rock Dust
		addCentrifugeRecipe(DeimosRockDust.getItem(32), null, OriharukonDust.getItem(), getIC2Item("copperDust", 2),
				IC2Items.getItem("tinDust"), getIC2Item("ironDust", 3), 300, 25);

		// Ceres Rock Dust
		addCentrifugeRecipe(CeresRockDust.getItem(32), null, ItemDusts.getDustByName("tungsten"),
				getIC2Item("silverDust", 2), MeteoricIronDust.getItem(), null, 300, 25);

		// Asteroid Rock Dust
		addCentrifugeRecipe(AsteroidRockDust.getItem(32), null, ItemDusts.getDustByName("aluminium", 2),
				IC2Items.getItem("ironDust"), MeteoricIronDust.getItem(2), new ItemStack(GCItems.basicItem, 1, 2), 300,
				25);

		// Callisto Rock Dust
		addCentrifugeRecipe(CallistoRockDust.getItem(32), null, PalladiumDust.getItem(2),
				OreUtil.getStackFromName("dustCertusQuartz", 4), null, null, 300, 25);

		// Ganymede Rock Dust
		addCentrifugeRecipe(GanymedeRockDust.getItem(32), null, ItemDusts.getDustByName("magnesium", 2),
				getIC2Item("ironDust", 3), ItemDusts.getDustByName("titanium"), null, 300, 25);

		// Europa Dust
		addCentrifugeRecipe(EuropaDust.getItem(32), null, EuropiumDust.getItem(3), null, null, null, 300, 25);

		// Europa Rock Dust
		addCentrifugeRecipe(EuropaRockDust.getItem(32), null, EuropiumDust.getItem(),
				ItemDusts.getDustByName("peridot"), ItemDusts.getDustByName("ruby"),
				ItemDusts.getDustByName("sapphire"), 300, 25);

		// Io Rock Dust
		addCentrifugeRecipe(IoRockDust.getItem(32), null, MetalMeteoricIronDust.getItem(2),
				IC2Items.getItem("copperDust"), getIC2Item("sulfurDust", 3), ItemDusts.getDustByName("saltpeter"), 300,
				25);

		// Io Dust
		addCentrifugeRecipe(IoDust.getItem(32), null, MetalMeteoricIronDust.getItem(4), null, null, null, 300, 25);

		// Mercury Rock Dust
		addCentrifugeRecipe(MercuryRockDust.getItem(32), null, MercurianIronDust.getItem(2), MetallicDust.getItem(2),
				ItemDusts.getDustByName("nickel"), getIC2Item("leadDust", 2), 300, 25);

		// Venus Rock Dust
		addCentrifugeRecipe(VenusRockDust.getItem(32), null, CitrineDust.getItem(), getIC2Item("leadDust", 2),
				getIC2Item("copperDust", 2), IC2Items.getItem("tinDust"), 300, 25);

		// Enceladus Rock Dust
		addCentrifugeRecipe(EnceladusRockDust.getItem(32), null, FrozenIronDust.getItem(2), null, null, null, 300, 25);

		// Enceladus Dust
		addCentrifugeRecipe(EnceladusDust.getItem(32), null, FrozenIronDust.getItem(4), null, null, null, 300, 25);

		// Titan Rock Dust
		addCentrifugeRecipe(TitanRockDust.getItem(32), null, PetaliteDust.getItem(2), RhodiumDust.getItem(2),
				ItemDusts.getDustByName("osmium"), null, 300, 25);

		// Miranda Rock Dust
		addCentrifugeRecipe(MirandaRockDust.getItem(32), null, getIC2Item("ironDust", 3), JadeDust.getItem(2), null,
				null, 300, 25);

		// Oberon Rock Dust
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, AdamantiteDust.getItem(2), null, null, null, 300, 25);

		// Proteus Rock Dust
		addCentrifugeRecipe(ProteusRockDust.getItem(32), null, ItemDusts.getDustByName("tungsten", 2),
				ItemDusts.getDustByName("platinum"), null, null, 300, 25);

		// Triton Rock Dust
		addCentrifugeRecipe(TritonRockDust.getItem(32), null, ItemDusts.getDustByName("uranium", 2),
				OreUtil.getStackFromName("dustMithril"), null, null, 300, 25);

		// Vega B Rock Dust
		addCentrifugeRecipe(VegaBRockDust.getItem(32), null, WhiteCrystalDust.getItem(2),
				OreUtil.getStackFromName("dustIridium"), null, null, 300, 25);

		// Pluto Rock Dust
		addCentrifugeRecipe(PlutoRockDust.getItem(32), null, PlutoniumDust.getItem(2), MeteoricIronDust.getItem(),
				XeoniumDust.getItem(2), FrozenIronDust.getItem(), 300, 25);

		// Pluto Dust
		addCentrifugeRecipe(PlutoDust.getItem(32), null, PlutoniumDust.getItem(3), XeoniumDust.getItem(2), null, null,
				300, 25);

		// Kuiper Belt
		addCentrifugeRecipe(DenseIceDust.getItem(32), null, IC2Items.getItem("ironDust"), null, null, null, 300, 25);

		// Haumea Rock Dust
		addCentrifugeRecipe(HaumeaRockDust.getItem(32), null, OnyxDust.getItem(2), AdamantiteDust.getItem(1),
				OriharukonDust.getItem(1), null, 300, 25);

		// Makemake Rock Dust
		addCentrifugeRecipe(MakemakeRockDust.getItem(32), null, BismuthDust.getItem(2), EuropiumDust.getItem(), null,
				null, 300, 25);

		// Koentus Rock Dust
		addCentrifugeRecipe(KoentusRockDust.getItem(32), null, KoentusMeteoricIronDust.getItem(2),
				WhiteCrystalDust.getItem(), getIC2Item("copperDust", 2), IC2Items.getItem("tinDust"), 300, 25);

		// Koentus Dust
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, KoentusMeteoricIronDust.getItem(4),
				WhiteCrystalDust.getItem(2), null, null, 300, 25);

		// Diona Rock Dust
		addCentrifugeRecipe(DionaRockDust.getItem(32), null, QuontoniumDust.getItem(2), FronisiumDust.getItem(2),
				ItemDusts.getDustByName("aluminium"), new ItemStack(GCItems.basicItem, 1, 2), 300, 25);

		// alphaCentauri Bb Rock Dust
		addCentrifugeRecipe(ACentauriBbRockDust.getItem(32), null, CentauriumDust.getItem(2),
				MetalMeteoricIronDust.getItem(), MetallicDust.getItem(), null, 300, 25);

		// Polongnius Rock Dust
		addCentrifugeRecipe(PolongniusRockDust.getItem(32), null, PolongniusMeteoricIronDust.getItem(2),
				FloniumDust.getItem(2), PalladiumDust.getItem(2), IC2Items.getItem("tinDust"), 300, 25);

		// Barnarda C Dust
		addCentrifugeRecipe(BarnardaCDust.getItem(32), null, PinkQuartzDust.getItem(4), IC2Items.getItem("coalDust"),
				null, null, 300, 25);

		// Barnarda E Rock Dust
		addCentrifugeRecipe(BarnardaERockDust.getItem(32), null, CarnelianDust.getItem(2), getIC2Item("goldDust", 2),
				getIC2Item("ironDust", 2), null, 300, 25);

		// Barnarda F Rock Dust
		addCentrifugeRecipe(BarnardaFRockDust.getItem(32), null, ChalcedonyDust.getItem(2), PlutoniumDust.getItem(2),
				OreUtil.getStackFromName("dustMithril"), null, 300, 25);

		// Nibiru Rock Dust
		addCentrifugeRecipe(NibiruRockDust.getItem(32), null, RedGemDust.getItem(2), IchoriusDust.getItem(2),
				IC2Items.getItem("ironDust"), null, 300, 25);

		// T Ceti E Rock Dust
		addCentrifugeRecipe(TCetiERockDust.getItem(32), null, NoriumDust.getItem(2), EMPDust.getItem(2),
				ItemDusts.getDustByName("platinum"), IC2Items.getItem("silverDust"), 300, 25);

		// Eden Rock Dust
		addCentrifugeRecipe(EdenRockDust.getItem(32), null, ViriniumDust.getItem(2), DeshDust.getItem(2),
				ItemDusts.getDustByName("aluminium"), MeteoricIronDust.getItem(), 300, 25);

		// Eden Dust
		addCentrifugeRecipe(EdenDust.getItem(32), null, ViriniumDust.getItem(4), IC2Items.getItem("coalDust"), null,
				null, 300, 25);

		// Kapteyn B Rock Dust
		addCentrifugeRecipe(KapteynBRockDust.getItem(32), null, NameriumDust.getItem(2), FrozenIronDust.getItem(),
				ItemDusts.getDustByName("uranium"), null, 300, 25);

		// Kapteyn B Dust
		addCentrifugeRecipe(KapteynBDust.getItem(32), null, NameriumDust.getItem(4),
				ItemDusts.getDustByName("uranium", 2), null, null, 300, 25);

		// Fronos Rock Dust
		addCentrifugeRecipe(FronosRockDust.getItem(32), null, OreUtil.getStackFromName("dustIridium"),
				getIC2Item("goldDust", 2), getIC2Item("copperDust", 4), ItemDusts.getDustByName("aluminium", 2), 300,
				25);

		// Fronos Dust
		addCentrifugeRecipe(FronosDust.getItem(32), null, OreUtil.getStackFromName("dustIridium", 2),
				IC2Items.getItem("coalDust"), null, null, 300, 25);

		// Kriffon Rock Dust
		addCentrifugeRecipe(KriffonRockDust.getItem(32), null, BlackDiamondDust.getItem(1), RedGemDust.getItem(1),
				OreUtil.getStackFromName("dustCobalt"), ItemDusts.getDustByName("tungsten"), 300, 25);

		// Kriffon Dust
		addCentrifugeRecipe(KriffonDust.getItem(32), null, BlackDiamondDust.getItem(3), RedGemDust.getItem(1), null,
				null, 300, 25);

		// Zolrock Dust
		addCentrifugeRecipe(ZolrockDust.getItem(32), null, HeartiumDust.getItem(2), NoriumDust.getItem(1),
				getIC2Item("tinDust", 2), getIC2Item("copperDust", 3), 300, 25);

		// Zollus Dust
		addCentrifugeRecipe(ZollusDust.getItem(32), null, NoriumDust.getItem(1), HeartiumDust.getItem(3), null, null,
				300, 25);

		// Sirius B Rock Dust
		addCentrifugeRecipe(SiriusBRockDust.getItem(32), null, getIC2Item("sulfurDust", 4),
				ItemDusts.getDustByName("diamond", 2), ItemDusts.getDustByName("tungsten", 2), null, 300, 25);

		// Oasis Rock Dust
		addCentrifugeRecipe(OasisRockDust.getItem(32), null, getIC2Item("silverDust", 3),
				ItemDusts.getDustByName("titanium", 2), null, null, 300, 25);

		// Oasis Dust
		addCentrifugeRecipe(OasisDust.getItem(32), null, ItemDusts.getDustByName("titanium"),
				getIC2Item("silverDust", 2), getIC2Item("sulfurDust", 3), ItemDusts.getDustByName("saltpeter"), 300,
				25);

		// Xathian Rock Dust
		addCentrifugeRecipe(XathianRockDust.getItem(32), null, XathianPrometheanDust.getItem(3),
				ItemDusts.getDustByName("platinum", 2), ItemDusts.getDustByName("osmium", 2), null, 300, 25);

		// Xathian Dust
		addCentrifugeRecipe(XathianDust.getItem(32), null, XathianPrometheanDust.getItem(5), null, null, null, 300, 25);

		// Purgot Rock Dust
		addCentrifugeRecipe(PurgotRockDust.getItem(32), null, EveniumDust.getItem(3), ViriniumDust.getItem(2),
				OreUtil.getStackFromName("dustCobalt"), null, 300, 25);

		// Purgot Dust
		addCentrifugeRecipe(PurgotDust.getItem(32), null, EveniumDust.getItem(5), null, null, null, 300, 25);

		// Neper Dust
		addCentrifugeRecipe(NeperDust.getItem(32), null, PurpleGemDust.getItem(4),
				ItemDusts.getDustByName("diamond", 2), ItemDusts.getDustByName("emerald", 2), null, 300, 25);

		// Maahes Dust
		addCentrifugeRecipe(MaahesDust.getItem(32), null, getIC2Item("coalDust", 5),
				ItemDusts.getDustByName("aluminium", 2), getIC2Item("ironDust", 4), XeoniumDust.getItem(3), 300, 25);

		// Basalt Rock Dust Anubis
		addCentrifugeRecipe(BasaltRockDust.getItem(32), null, ChioniteDust.getItem(2),
				ItemDusts.getDustByName("uranium", 2), null, null, 300, 25);

		// Basalt Dust Anubis
		addCentrifugeRecipe(BasaltDust.getItem(32), null, ChioniteDust.getItem(4),
				ItemDusts.getDustByName("uranium", 4), null, null, 300, 25);

		// Obsidian Sand Dust Horus
		addCentrifugeRecipe(ObsidianSandDust.getItem(32), null, ItemDusts.getDustByName("diamond"),
				ItemDusts.getDustByName("emerald"), getIC2Item("obsidianDust", 6), null, 300, 25);

		// Coral Rock Seth
		addCentrifugeRecipe(CoralDust.getItem(32), null, BacterialFossilDust.getItem(6), null, null, null, 300, 25);

		// Dark Asteroid Rock Dust
		addCentrifugeRecipe(DarkAsteroidRockDust.getItem(32), null, AlphereDust.getItem(2),
				ItemDusts.getDustByName("diamond", 2), OreUtil.getStackFromName("dustIridium", 3),
				OreUtil.getStackFromName("dustDraconium", 2), 300, 25);

		// Dark Asteroid Dust
		addCentrifugeRecipe(DarkAsteroidDust.getItem(32), null, AlphereDust.getItem(4),
				OreUtil.getStackFromName("dustIridium", 4), OreUtil.getStackFromName("dustDraconium", 4), null, 300,
				25);

		// Macerator Recipes - Blocks to Dust

		// Moon
		addMaceratorRecipe(Utils.getItem("GalacticraftCore", "tile.moonBlock", 3), MoonDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftCore", "tile.moonBlock", 4), MoonRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftCore", "tile.moonBlock", 5), MoonDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftCore", "tile.moonBlock", 14), MoonRockDust.getItem(2));

		// Mars
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.mars", 4), MarsRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.mars", 5), MarsRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.mars", 6), MarsRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.mars", 7), MarsRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.mars", 9), MarsRockDust.getItem());

		// Phobos
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "phobosblocks"), PhobosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "phobosblocks", 1), PhobosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "phobosblocks", 2), PhobosRockDust.getItem());

		// Phobos
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "deimosblocks"), DeimosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "deimosblocks", 1), DeimosRockDust.getItem());

		// Ceres
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ceresblocks"), CeresRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ceresblocks", 1), CeresRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ceresblocks", 2), CeresRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ceresblocks", 4), CeresRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ceresblocks", 5), CeresRockDust.getItem(2));

		// Asteroids
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.asteroidsBlock"), AsteroidRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.asteroidsBlock", 1), AsteroidRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.asteroidsBlock", 2), AsteroidRockDust.getItem());

		// Callisto
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "callistoblocks"), CallistoRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "callistoblocks", 1), CallistoRockDust.getItem());

		// Europa
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "europagrunt"), EuropaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "europagrunt", 1), EuropaDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "europageyser"), EuropaRockDust.getItem(8));
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "europaunderwatergeyser"), EuropaDust.getItem(8));

		// Io
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ioblocks"), IoRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ioblocks", 1), IoDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ioblocks", 2), IoRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ioblocks", 3), IoRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ioblocks", 7), IoRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "ioblocks", 8), IoRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "iodualstone"), IoRockDust.getItem(2));

		// Mercury
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "mercuryblocks"), MercuryRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "mercuryblocks", 1), MercuryRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "mercuryblocks", 2), MercuryRockDust.getItem());

		// Venus
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "venusblocks"), VenusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "venusblocks", 1), VenusRockDust.getItem());

		// Enceladus
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "enceladusblocks"), EnceladusDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "enceladusblocks", 1), EnceladusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "enceladusblocks", 2), EnceladusRockDust.getItem(2));

		// Titan
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "titanblocks"), TitanRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "titanblocks", 1), TitanRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "titanblocks", 2), TitanRockDust.getItem());

		// Miranda
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "mirandablocks"), MirandaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "mirandablocks", 1), MirandaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "mirandablocks", 2), MirandaRockDust.getItem());

		// Oberon
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "oberonblocks"), OberonRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "oberonblocks", 1), OberonRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "oberonblocks", 2), OberonRockDust.getItem());

		// Proteus
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "proteusblocks"), ProteusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "proteusblocks", 1), ProteusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "proteusblocks", 2), ProteusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "proteusblocks", 3), ProteusRockDust.getItem(2));

		// Triton
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "tritonblocks"), TritonRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "tritonblocks", 1), TritonRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "tritonblocks", 2), TritonRockDust.getItem());

		// Vega B
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "vegabgrunt"), VegaBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "vegabsubgrunt"), VegaBRockDust.getItem());

		// Pluto
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "plutoblocks"), PlutoDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "plutoblocks", 1), PlutoDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "plutoblocks", 2), PlutoDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "plutoblocks", 3), PlutoDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "plutoblocks", 4), PlutoDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "plutoblocks", 5), PlutoRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "plutoblocks", 6), PlutoRockDust.getItem(2));

		// Kuiper Belt
		addMaceratorRecipe(Utils.getItem("GalacticraftMars", "tile.denseIce"), DenseIceDust.getItem());

		// Haumea
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "haumeablocks"), HaumeaRockDust.getItem());

		// Haumea
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "makemakegrunt"), MakemakeRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "makemakegrunt", 1), MakemakeRockDust.getItem());

		// Koentus
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_ice"), KoentusDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_ice", 1), KoentusDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 3), KoentusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_block"), KoentusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_block", 1), KoentusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_block", 2), KoentusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_block", 3), KoentusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_block", 11), KoentusRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_block", 12), KoentusRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "koentus_block", 13), KoentusRockDust.getItem(2));

		// Diona
		addMaceratorRecipe(Utils.getItem("MorePlanet", "space_mossy_cobblestone"), DionaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "diona_block"), DionaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "diona_block", 1), DionaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "diona_block", 2), DionaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "diona_block", 3), DionaRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "diona_block", 14), DionaRockDust.getItem(2));

		// aCentauri Bb
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "acentauribbgrunt"), ACentauriBbRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "acentauribbsubgrunt"), ACentauriBbRockDust.getItem());

		// Polongnius
		addMaceratorRecipe(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 1), PolongniusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "polongnius_block", 2), PolongniusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "polongnius_block", 3), PolongniusRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "polongnius_block", 13), PolongniusRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "polongnius_block", 14), PolongniusRockDust.getItem(4));

		// Barnarda C
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "barnardaCgrass"), BarnardaCDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "barnardaCdirt"), BarnardaCDust.getItem());

		// Barnarda E
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "barnardaEgrunt"), BarnardaERockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "barnardaEsubgrunt"), BarnardaERockDust.getItem());

		// Barnarda F
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "barnardaFgrunt"), BarnardaFRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "barnardaFsubgrunt"), BarnardaFRockDust.getItem());

		// Nibiru
		addMaceratorRecipe(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 2), NibiruRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "nibiru_block"), NibiruRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "nibiru_block", 1), NibiruRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "nibiru_block", 2), NibiruRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "nibiru_block", 3), NibiruRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "nibiru_block", 12), NibiruRockDust.getItem(2));

		// T Ceti E
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "tcetieblocks"), TCetiERockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "tcetieblocks", 1), TCetiERockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalaxySpace", "tcetieblocks", 2), TCetiERockDust.getItem());

		// Eden
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edencobblerock"), EdenRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edenrock"), EdenRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edenrockbricks"), EdenRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edensurfaceblock"), EdenRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edensoil"), EdenDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edengrass"), EdenDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edengoldengrass"), EdenDust.getItem(4));
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_bloodsand"), EdenDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edenwinterrock"), EdenRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_bonestone"), EdenRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edengravel"), EdenDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_bloodstone"), EdenRockDust.getItem(4));
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_edensacredstone"), EdenRockDust.getItem(4));

		// Kapteyn B
		addMaceratorRecipe(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 4), KapteynBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "kapteyn-b_block"), KapteynBDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "kapteyn-b_block", 1), KapteynBDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "kapteyn-b_block", 2), KapteynBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "kapteyn-b_block", 3), KapteynBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "kapteyn-b_block", 14), KapteynBRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "kapteyn-b_ice"), KapteynBDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "kapteyn-b_ice", 1), KapteynBDust.getItem());

		// Fronos
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_dirt"), FronosDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_dirt", 1), FronosDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_grass"), FronosDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_sand"), FronosDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_sandstone"), FronosDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_sandstone", 1), FronosDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_sandstone", 2), FronosDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_block"), FronosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_block", 1), FronosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_block", 11), FronosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_block", 12), FronosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_block", 13), FronosRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "fronos_block", 14), FronosRockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "mossy_fronos_cobblestone"), FronosRockDust.getItem());

		// Eden
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_zoldirt"), ZollusDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_zolrockbricks"), ZolrockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_solarblock"), ZolrockDust.getItem(2));
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_zolcobblerock"), ZolrockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_zolstone"), ZolrockDust.getItem());

		// Sirius B
		addMaceratorRecipe(Utils.getItem("MorePlanet", "space_mossy_cobblestone", 5), SiriusBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "sirius_block"), SiriusBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "sirius_block", 1), SiriusBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "sirius_block", 2), SiriusBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "sirius_block", 3), SiriusBRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "sirius_block", 7), SiriusBRockDust.getItem(4));
		addMaceratorRecipe(Utils.getItem("MorePlanet", "sirius_block", 9), SiriusBRockDust.getItem(2));

		// Oasis
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_oasisgrass"), OasisDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_oasisdirt"), OasisDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_oasiscobblerock"), OasisRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_oasisrock"), OasisRockDust.getItem());

		// Xathius
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_xathgrass"), XathianDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_xathdirt"), XathianDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_xathstone"), XathianRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_xathrock"), XathianRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_xathcobblerock"), XathianRockDust.getItem());

		// Purgot
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_purgdirt"), PurgotDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_purgcobblerock"), PurgotRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_purgstone"), PurgotRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_purgrock"), PurgotRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("galaxymod", "galaxymod_purgrockbricks"), PurgotRockDust.getItem());

		// Neper
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockRock", 10), NeperDust.getItem());

		// Maahes
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.wood1", 1), MaahesDust.getItem());

		// Anubis
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockRock", 1), BasaltRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockGround", 1), BasaltDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.baseFalling", 2), BasaltDust.getItem());

		// Horus
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.baseFalling"), ObsidianSandDust.getItem());
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.baseFalling", 1), ObsidianSandDust.getItem());

		// Seth
		addMaceratorRecipe(Utils.getItem("GalacticraftAmunRa", "tile.baseBlockCrystal"), CoralDust.getItem(2));

		// Dark Asteroids
		addMaceratorRecipe(Utils.getItem("MorePlanet", "dark_asteroid_block"), DarkAsteroidRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "dark_asteroid_block", 1), DarkAsteroidRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "dark_asteroid_block", 2), DarkAsteroidRockDust.getItem());
		addMaceratorRecipe(Utils.getItem("MorePlanet", "dark_asteroid_quicksand"), DarkAsteroidDust.getItem());

		// Compressor Recipes - Dust to Ingot/Something else

		// Black Diamond
		addCompressorRecipe(BlackDiamondDust.getItem(9), Utils.getItem("MorePlanet", "fronos_item", 2));

		// Desh
		addCompressorRecipe(DeshDust.getItem(9), Utils.getItem("GalacticraftMars", "item.null", 2));

		// Oriharukon
		addCompressorRecipe(OriharukonDust.getItem(9), Utils.getItem("GalaxySpace", "item.Ingots", 7));

		// Meteoric Iron
		addCompressorRecipe(MeteoricIronDust.getItem(9), Utils.getItem("GalacticraftCore", "item.meteoricIronIngot"));

		// Palladium
		addCompressorRecipe(PalladiumDust.getItem(9), Utils.getItem("galacticores", "itemIngots", 6));

		// Europium
		addCompressorRecipe(EuropiumDust.getItem(9), Utils.getItem("galacticores", "itemIngots", 5));

		// Metal Meteoric Iron
		addCompressorRecipe(MetalMeteoricIronDust.getItem(9), Utils.getItem("MorePlanet", "mercury_item", 3));

		// Metallic
		addCompressorRecipe(MetallicDust.getItem(9), Utils.getItem("MorePlanet", "mercury_item", 2));

		// Mercurian Iron
		addCompressorRecipe(MercurianIronDust.getItem(9), Utils.getItem("galacticores", "itemIngots"));

		// Citrine
		addCompressorRecipe(CitrineDust.getItem(9), Utils.getItem("galacticores", "itemDrops"));

		// Frozen Iron
		addCompressorRecipe(FrozenIronDust.getItem(9), Utils.getItem("MorePlanet", "kapteyn-b_item"));

		// Rhodium
		addCompressorRecipe(RhodiumDust.getItem(9), Utils.getItem("galacticores", "itemIngots", 7));

		// Petalite
		addCompressorRecipe(PetaliteDust.getItem(9), Utils.getItem("galacticores", "itemDrops", 7));

		// Jade
		addCompressorRecipe(JadeDust.getItem(9), Utils.getItem("galacticores", "itemDrops", 6));

		// Adamantite
		addCompressorRecipe(AdamantiteDust.getItem(9), Utils.getItem("GalaxySpace", "item.Ingots"));

		// Uranium
		addCompressorRecipe(ItemDusts.getDustByName("uranium", 9),
				Utils.getItem("GalacticraftAmunRa", "item.baseItem", 11));

		// Uranium
		// addCompressorRecipe(UraniumDust.getItem(9), Utils.getItem("IC2",
		// "itemUran235"));

		// White Crystal
		addCompressorRecipe(WhiteCrystalDust.getItem(9), Utils.getItem("MorePlanet", "koentus_item"));

		// Plutonium
		addCompressorRecipe(PlutoniumDust.getItem(9), Utils.getItem("galacticores", "itemIngots", 1));

		// Xeonium
		addCompressorRecipe(XeoniumDust.getItem(9), Utils.getItem("MorePlanet", "pluto_item"));

		// Onyx
		addCompressorRecipe(OnyxDust.getItem(9), Utils.getItem("galacticores", "itemDrops", 1));

		// Bismuth
		addCompressorRecipe(BismuthDust.getItem(9), Utils.getItem("galacticores", "itemIngots", 2));

		// Koentus Meteoric Iron
		addCompressorRecipe(KoentusMeteoricIronDust.getItem(9), Utils.getItem("MorePlanet", "koentus_item", 4));

		// Quontonium
		addCompressorRecipe(QuontoniumDust.getItem(9), Utils.getItem("MorePlanet", "diona_item"));

		// Centaurium
		addCompressorRecipe(CentauriumDust.getItem(9), Utils.getItem("galacticores", "itemIngots", 3));

		// Polongnius Meteoric Iron
		addCompressorRecipe(PolongniusMeteoricIronDust.getItem(9), Utils.getItem("MorePlanet", "polongnius_item", 4));

		// Flonium
		addCompressorRecipe(FloniumDust.getItem(9), Utils.getItem("MorePlanet", "polongnius_item"));

		// Pink Quartz
		addCompressorRecipe(PinkQuartzDust.getItem(9), Utils.getItem("galacticores", "itemDrops", 2));

		// Carnelian
		addCompressorRecipe(CarnelianDust.getItem(9), Utils.getItem("galacticores", "itemDrops", 3));

		// Chalcedony
		addCompressorRecipe(ChalcedonyDust.getItem(9), Utils.getItem("galacticores", "itemDrops", 4));

		// Ichorius
		addCompressorRecipe(IchoriusDust.getItem(9), Utils.getItem("MorePlanet", "power_crystal"));

		// Red Gem
		addCompressorRecipe(RedGemDust.getItem(9), Utils.getItem("MorePlanet", "nibiru_item"));

		// EMP
		addCompressorRecipe(EMPDust.getItem(9), Utils.getItem("MorePlanet", "koentus_item", 1));

		// Norium
		addCompressorRecipe(NoriumDust.getItem(9), Utils.getItem("MorePlanet", "nibiru_item", 1));

		// Virinium
		addCompressorRecipe(ViriniumDust.getItem(9), Utils.getItem("galaxymod", "galaxymod_ingotviri"));

		// Namerium
		addCompressorRecipe(NameriumDust.getItem(9), Utils.getItem("MorePlanet", "namerium_crystal"));

		// Heartium
		addCompressorRecipe(HeartiumDust.getItem(9), Utils.getItem("galaxymod", "galaxymod_heartofzol"));

		// Evenium
		addCompressorRecipe(EveniumDust.getItem(9), Utils.getItem("galaxymod", "galaxymod_ingotevenium"));

		// Fronisium
		addCompressorRecipe(FronisiumDust.getItem(9), Utils.getItem("MorePlanet", "diona_item", 1));

		// Chionite
		addCompressorRecipe(ChioniteDust.getItem(9), Utils.getItem("GalacticraftAmunRa", "item.baseItem", 3));

		// Bacterial Fossil
		addCompressorRecipe(BacterialFossilDust.getItem(9), Utils.getItem("MorePlanet", "koentus_item", 2));

		// Purple Crystal
		addCompressorRecipe(PurpleGemDust.getItem(9), Utils.getItem("MorePlanet", "polongnius_item", 1));

		// Alphere
		addCompressorRecipe(AlphereDust.getItem(9), Utils.getItem("MorePlanet", "alphere"));

		// Xathium
		addCompressorRecipe(XathianPrometheanDust.getItem(9),
				Utils.getItem("galaxymod", "galaxymod_prometheancrystal"));

	}

	private static void addCentrifugeRecipe(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2,
			ItemStack output3, ItemStack output4, int tickTime, int euPerTick) {
		techreborn.api.recipe.RecipeHandler.addRecipe(
				new CentrifugeRecipe(input1, input2, output1, output2, output3, output4, tickTime, euPerTick));
	}

	// Ein Item rein, ein Item raus
	private static void addMaceratorRecipe(ItemStack input, ItemStack outputs) {
		Recipes.macerator.addRecipe(new RecipeInputItemStack(input), null, outputs);
	}

	// Mehrere rein und vielleicht auch mehrere raus
	private static void addMaceratorRecipe(ItemStack input, int inputAmount, ItemStack outputs) {
		Recipes.macerator.addRecipe(new RecipeInputItemStack(input, inputAmount), null, outputs);
	}

	// Wie 1, nur anstelle von ItemStack der String von OreDict
	private static void addMaceratorRecipe(String oreDictInputnput, ItemStack outputs) {
		Recipes.macerator.addRecipe(new RecipeInputOreDict(oreDictInputnput), null, outputs);
	}

	// Wie 2, nur anstelle von ItemStack der String von OreDict
	private static void addMaceratorRecipe(String oreDictInputnput, int inputAmount, ItemStack outputs) {
		Recipes.macerator.addRecipe(new RecipeInputOreDict(oreDictInputnput, inputAmount), null, outputs);
	}

	private static void addCompressorRecipe(ItemStack input, ItemStack outputs) {
		Recipes.compressor.addRecipe(new RecipeInputItemStack(input), null, outputs);
	}

	private static ItemStack getIC2Item(String name, int amount) {
		ItemStack stack = IC2Items.getItem(name).copy();
		stack.stackSize = amount;
		return stack;
	}

}
