package glowredman.fpsp;

import static glowredman.fpsp.item.ItemDefinitions.*;

import java.util.List;

import galaxyspace.core.recipe.RecipeUtilGS;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.RecipeInputOreDict;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import techreborn.api.recipe.machines.CentrifugeRecipe;

public class RecipeHandler {

	public static void init() {

		// Dust Recipes

		// Moon Rock Dust
		addCentrifugeRecipe(MoonRockDust.getItem(32), null, MeteoricIronDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7), null, 300,
				25);

		// Mars Rock Dust
		addCentrifugeRecipe(MarsRockDust.getItem(32), null, DeshDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), 300, 25);

		// Phobos Rock Dust
		addCentrifugeRecipe(PhobosRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 20, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), 300, 25);

		// Deimos Rock Dust
		addCentrifugeRecipe(DeimosRockDust.getItem(32), null, OriharukonDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 3, 2), RecipeUtilGS.getItem("IC2", "itemDust", 7),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), 300, 25);

		// Ceres Rock Dust
		addCentrifugeRecipe(CeresRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 81),
				RecipeUtilGS.getItem("IC2", "itemDust", 6, 2), MeteoricIronDust.getItem(), null, 300, 25);

		// Asteroid Rock Dust
		addCentrifugeRecipe(AsteroidRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 2, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 5), MeteoricIronDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 69), 300, 25);

		// Callisto Rock Dust
		addCentrifugeRecipe(CallistoRockDust.getItem(32), null, PalladiumDust.getItem(2), null, null, null, 300, 25);

		// Ganymede Rock Dust
		addCentrifugeRecipe(GanymedeRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 46, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 5, 3), RecipeUtilGS.getItem("techreborn", "dust", 80), null,
				300, 25);

		// Europa Dust
		addCentrifugeRecipe(EuropaDust.getItem(32), null, EuropiumDust.getItem(3), null, null, null, 300, 25);

		// Europa Rock Dust
		addCentrifugeRecipe(EuropaRockDust.getItem(32), null, EuropiumDust.getItem(),
				RecipeUtilGS.getItem("techreborn", "dust", 57), RecipeUtilGS.getItem("techreborn", "dust", 65),
				RecipeUtilGS.getItem("techreborn", "dust", 67), 300, 25);

		// Io Rock Dust
		addCentrifugeRecipe(IoRockDust.getItem(32), null, MetalMeteoricIronDust.getItem(2),
				RecipeUtilGS.getItem("IC2", "itemDust", 3), RecipeUtilGS.getItem("IC2", "itemDust", 13, 3),
				RecipeUtilGS.getItem("techreborn", "dust", 66), 300, 25);
		
		// Io Dust
		addCentrifugeRecipe(IoDust.getItem(32), null, MetalMeteoricIronDust.getItem(4), null, null, null, 300, 25);

		// Mercury Rock Dust
		addCentrifugeRecipe(MercuryRockDust.getItem(32), null, MercurianIronDust.getItem(2), MetallicDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 54), RecipeUtilGS.getItem("IC2", "itemDust", 10, 2), 300,
				25);

		// Venus Rock Dust
		addCentrifugeRecipe(VenusRockDust.getItem(32), null, CitrineDust.getItem(),
				RecipeUtilGS.getItem("IC2", "itemDust", 10, 2), RecipeUtilGS.getItem("IC2", "itemDust", 3, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 7), 300, 25);

		// Enceladus Rock Dust
		addCentrifugeRecipe(EnceladusRockDust.getItem(32), null, FrozenIronDust.getItem(2), null, null, null, 300, 25);
		
		// Enceladus Dust
		addCentrifugeRecipe(EnceladusDust.getItem(32), null, FrozenIronDust.getItem(4), null, null, null, 300, 25);

		// Titan Rock Dust
		addCentrifugeRecipe(TitanRockDust.getItem(32), null, PetaliteDust.getItem(2), RhodiumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 56), null, 300, 25);

		// Miranda Rock Dust
		addCentrifugeRecipe(MirandaRockDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 5, 3),
				JadeDust.getItem(2), null, null, 300, 25);

		// Oberon Rock Dust
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, AdamantiteDust.getItem(2), null, null, null, 300, 25);

		// Proteus Rock Dust
		addCentrifugeRecipe(ProteusRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 81, 2),
				RecipeUtilGS.getItem("techreborn", "dust", 59), null, null, 300, 25);

		// Triton Rock Dust
		addCentrifugeRecipe(TritonRockDust.getItem(32), null, UraniumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 51), null, null, 300, 25);

		// Vega B Rock Dust
		addCentrifugeRecipe(VegaBRockDust.getItem(32), null, WhiteCrystalDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 38), null, null, 300, 25);

		// Pluto Rock Dust
		addCentrifugeRecipe(PlutoRockDust.getItem(32), null, PlutoniumDust.getItem(2), MeteoricIronDust.getItem(),
				XeoniumDust.getItem(2), FrozenIronDust.getItem(), 300, 25);
		
		// Pluto Dust
		addCentrifugeRecipe(PlutoDust.getItem(32), null, PlutoniumDust.getItem(3), XeoniumDust.getItem(2), null, null, 300, 25);

		// Kuiper Belt
		addCentrifugeRecipe(DenseIceDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 5), null, null,
				null, 300, 25);

		// Haumea Rock Dust
		addCentrifugeRecipe(HaumeaRockDust.getItem(32), null, OnyxDust.getItem(2), AdamantiteDust.getItem(1),
				OriharukonDust.getItem(1), null, 300, 25);

		// Makemake Rock Dust
		addCentrifugeRecipe(MakemakeRockDust.getItem(32), null, BismuthDust.getItem(2), EuropiumDust.getItem(), null,
				null, 300, 25);

		// Koentus Rock Dust
		addCentrifugeRecipe(KoentusRockDust.getItem(32), null, KoentusMeteoricIronDust.getItem(2),
				WhiteCrystalDust.getItem(), RecipeUtilGS.getItem("IC2", "itemDust", 3, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 7), 300, 25);
		
		// Koentus Dust
		addCentrifugeRecipe(OberonRockDust.getItem(32), null, KoentusMeteoricIronDust.getItem(4),
				WhiteCrystalDust.getItem(2), null, null, 300, 25);

		// Diona Rock Dust
		addCentrifugeRecipe(DionaRockDust.getItem(32), null, QuontoniumDust.getItem(2), FronisiumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 2), RecipeUtilGS.getItem("techreborn", "dust", 69), 300, 25);

		// alphaCentauri Bb Rock Dust
		addCentrifugeRecipe(ACentauriBbRockDust.getItem(32), null, CentauriumDust.getItem(2),
				MetalMeteoricIronDust.getItem(), MetallicDust.getItem(), null, 300, 25);

		// Polongnius Rock Dust
		addCentrifugeRecipe(PolongniusRockDust.getItem(32), null, PolongniusMeteoricIronDust.getItem(2),
				FloniumDust.getItem(2), PalladiumDust.getItem(2), RecipeUtilGS.getItem("IC2", "itemDust", 7), 300, 25);

		// Barnarda C Dust
		addCentrifugeRecipe(BarnardaCDust.getItem(32), null, PinkQuartzDust.getItem(4),
				RecipeUtilGS.getItem("IC2", "itemDust", 2), null, null, 300, 25);

		// Barnarda E Rock Dust
		addCentrifugeRecipe(BarnardaERockDust.getItem(32), null, CarnelianDust.getItem(2),
				RecipeUtilGS.getItem("IC2", "itemDust", 4, 2), RecipeUtilGS.getItem("IC2", "itemDust", 5, 2), null, 300,
				25);

		// Barnarda F Rock Dust
		addCentrifugeRecipe(BarnardaFRockDust.getItem(32), null, ChalcedonyDust.getItem(2), PlutoniumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 51), null, 300, 25);

		// Nibiru Rock Dust
		addCentrifugeRecipe(NibiruRockDust.getItem(32), null, RedGemDust.getItem(2), IchoriusDust.getItem(2),
				RecipeUtilGS.getItem("IC2", "itemDust", 5), null, 300, 25);

		// T Ceti E Rock Dust
		addCentrifugeRecipe(TCetiERockDust.getItem(32), null, NoriumDust.getItem(2), EMPDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 59), RecipeUtilGS.getItem("IC2", "itemDust", 6), 300, 25);

		// Eden Rock Dust
		addCentrifugeRecipe(EdenRockDust.getItem(32), null, ViriniumDust.getItem(2), DeshDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 2), MeteoricIronDust.getItem(), 300, 25);

		// Eden Dust
		addCentrifugeRecipe(EdenDust.getItem(32), null, ViriniumDust.getItem(4),
				RecipeUtilGS.getItem("IC2", "itemDust", 2), null, null, 300, 25); 

		// Kapteyn B Rock Dust
		addCentrifugeRecipe(KapteynBRockDust.getItem(32), null, NameriumDust.getItem(2), FrozenIronDust.getItem(),
				UraniumDust.getItem(), null, 300, 25);
		
		// Kapteyn B Dust
		addCentrifugeRecipe(KapteynBDust.getItem(32), null, NameriumDust.getItem(4), UraniumDust.getItem(2), null,
				null, 300, 25);

		// Fronos Rock Dust
		addCentrifugeRecipe(FronosRockDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 38),
				RecipeUtilGS.getItem("IC2", "itemDust", 4, 2), RecipeUtilGS.getItem("IC2", "itemDust", 3, 4),
				RecipeUtilGS.getItem("techreborn", "dust", 2, 2), 300, 25);

		// Fronos Dust
		addCentrifugeRecipe(FronosDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 38, 2),
				RecipeUtilGS.getItem("IC2", "itemDust", 2), null, null, 300, 25);

		// Kriffon Rock Dust
		addCentrifugeRecipe(KriffonRockDust.getItem(32), null, BlackDiamondDust.getItem(1), RedGemDust.getItem(1),
				RecipeUtilGS.getItem("techreborn", "dust", 20), RecipeUtilGS.getItem("techreborn", "dust", 81), 300,
				25);

		// Kriffon Dust
		addCentrifugeRecipe(KriffonDust.getItem(32), null, BlackDiamondDust.getItem(3), RedGemDust.getItem(1), null,
				null, 300, 25);

		// Zolrock Dust
		addCentrifugeRecipe(ZolrockDust.getItem(32), null, HeartiumDust.getItem(2), NoriumDust.getItem(1),
				RecipeUtilGS.getItem("IC2", "itemDust", 7, 2), RecipeUtilGS.getItem("IC2", "itemDust", 3, 3), 300, 25);

		// Zollus Dust
		addCentrifugeRecipe(ZollusDust.getItem(32), null, NoriumDust.getItem(1), HeartiumDust.getItem(3), null, null,
				300, 25);

		// Sirius B Rock Dust
		addCentrifugeRecipe(SiriusBRockDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 13, 4),
				RecipeUtilGS.getItem("techreborn", "dust", 25, 2), RecipeUtilGS.getItem("techreborn", "dust", 81, 2),
				null, 300, 25);

		// Oasis Rock Dust
		addCentrifugeRecipe(OasisRockDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 6, 3),
				RecipeUtilGS.getItem("techreborn", "dust", 80, 2), null, null, 300, 25);

		// Oasis Dust
		addCentrifugeRecipe(OasisDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 80),
				RecipeUtilGS.getItem("IC2", "itemDust", 6, 2), RecipeUtilGS.getItem("IC2", "itemDust", 13, 3),
				RecipeUtilGS.getItem("techreborn", "dust", 66), 300, 25);

		// Xathian Rock Dust
		addCentrifugeRecipe(XathianRockDust.getItem(32), null, XathiumDust.getItem(3),
				RecipeUtilGS.getItem("techreborn", "dust", 59, 2), RecipeUtilGS.getItem("techreborn", "dust", 56, 2),
				null, 300, 25);

		// Xathian Dust
		addCentrifugeRecipe(XathianDust.getItem(32), null, XathiumDust.getItem(5), null, null, null, 300, 25);

		// Purgot Rock Dust
		addCentrifugeRecipe(PurgotRockDust.getItem(32), null, EveniumDust.getItem(3), ViriniumDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 20), null, 300, 25);

		// Purgot Dust
		addCentrifugeRecipe(PurgotDust.getItem(32), null, EveniumDust.getItem(5), null, null, null, 300, 25);

		// Neper Dust
		addCentrifugeRecipe(NeperDust.getItem(32), null, PurpleGemDust.getItem(4),
				RecipeUtilGS.getItem("techreborn", "dust", 25, 2), RecipeUtilGS.getItem("techreborn", "dust", 27, 2),
				null, 300, 25);

		// Maahes Dust
		addCentrifugeRecipe(MaahesDust.getItem(32), null, RecipeUtilGS.getItem("IC2", "itemDust", 2, 5),
				RecipeUtilGS.getItem("techreborn", "dust", 2, 2), RecipeUtilGS.getItem("IC2", "itemDust", 5, 4),
				XeoniumDust.getItem(3), 300, 25);

		// Basalt Rock Dust Anubis
		addCentrifugeRecipe(BasaltRockDust.getItem(32), null, ChioniteDust.getItem(2), UraniumDust.getItem(2), null,
				null, 300, 25);
		
		// Basalt Dust Anubis
		addCentrifugeRecipe(BasaltDust.getItem(32), null, ChioniteDust.getItem(4), UraniumDust.getItem(4), null,
				null, 300, 25);

		// Obsidian Sand Dust Horus
		addCentrifugeRecipe(ObsidianSandDust.getItem(32), null, RecipeUtilGS.getItem("techreborn", "dust", 25, 1),
				RecipeUtilGS.getItem("techreborn", "dust", 27, 1), RecipeUtilGS.getItem("IC2", "itemDust", 11, 6), null,
				300, 25);

		// Coral Rock Seth
		addCentrifugeRecipe(CoralDust.getItem(32), null, BacterialFossilDust.getItem(6), null, null, null, 300,
				25);

		// Dark Asteroid Rock Dust
		addCentrifugeRecipe(DarkAsteroidRockDust.getItem(32), null, AlphereDust.getItem(2),
				RecipeUtilGS.getItem("techreborn", "dust", 25, 2), RecipeUtilGS.getItem("techreborn", "dust", 38, 3),
				null, 300, 25);
		
		// Dark Asteroid Dust
		addCentrifugeRecipe(DarkAsteroidDust.getItem(32), null, AlphereDust.getItem(4), RecipeUtilGS.getItem("techreborn", "dust", 38, 4), null, null, 300, 25);

		// Stone to Dust

		// Moon
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftCore", "tile.moonBlock", 3), MoonDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftCore", "tile.moonBlock", 4), MoonRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftCore", "tile.moonBlock", 5), MoonDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftCore", "tile.moonBlock", 14), MoonRockDust.getItem(2));
		
		// Mars
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.mars", 4), MarsRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.mars", 5), MarsRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.mars", 6), MarsRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.mars", 7), MarsRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.mars", 9), MarsRockDust.getItem());
		
		// Phobos
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "phobosblocks"), PhobosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "phobosblocks", 1), PhobosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "phobosblocks", 2), PhobosRockDust.getItem());
		
		// Phobos
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "deimosblocks"), DeimosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "deimosblocks", 1), DeimosRockDust.getItem());
		
		// Ceres
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ceresblocks"), CeresRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ceresblocks", 1), CeresRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ceresblocks", 2), CeresRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ceresblocks", 4), CeresRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ceresblocks", 5), CeresRockDust.getItem(2));
		
		// Asteroids
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.asteroidsBlock"), AsteroidRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.asteroidsBlock", 1), AsteroidRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.asteroidsBlock", 2), AsteroidRockDust.getItem());
		
		// Callisto
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "callistoblocks"), CallistoRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "callistoblocks", 1), CallistoRockDust.getItem());
		
		// Europa
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "europagrunt"), EuropaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "europagrunt", 1), EuropaDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "europageyser"), EuropaRockDust.getItem(8));
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "europaunderwatergeyser"), EuropaDust.getItem(8));
		
		// Io
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ioblocks"), IoRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ioblocks", 1), IoDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ioblocks", 2), IoRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ioblocks", 3), IoRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ioblocks", 7), IoRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "ioblocks", 8), IoRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "iodualstone"), IoRockDust.getItem(2));
		
		// Mercury
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "mercuryblocks"), MercuryRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "mercuryblocks", 1), MercuryRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "mercuryblocks", 2), MercuryRockDust.getItem());
		
		// Venus
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "venusblocks"), VenusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "venusblocks", 1), VenusRockDust.getItem());
		
		// Enceladus
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "enceladusblocks"), EnceladusDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "enceladusblocks", 1), EnceladusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "enceladusblocks", 2), EnceladusRockDust.getItem(2));
		
		// Titan
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "titanblocks"), TitanRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "titanblocks", 1), TitanRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "titanblocks", 2), TitanRockDust.getItem());
		
		// Miranda
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "mirandablocks"), MirandaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "mirandablocks", 1), MirandaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "mirandablocks", 2), MirandaRockDust.getItem());
		
		// Oberon
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "oberonblocks"), OberonRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "oberonblocks", 1), OberonRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "oberonblocks", 2), OberonRockDust.getItem());
		
		// Proteus
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "proteusblocks"), ProteusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "proteusblocks", 1), ProteusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "proteusblocks", 2), ProteusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "proteusblocks", 3), ProteusRockDust.getItem(2));
		
		// Triton
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "tritonblocks"), TritonRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "tritonblocks", 1), TritonRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "tritonblocks", 2), TritonRockDust.getItem());
		
		// Vega B
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "vegabgrunt"), VegaBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "vegabsubgrunt"), VegaBRockDust.getItem());
		
		// Pluto
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "plutoblocks"), PlutoDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "plutoblocks", 1), PlutoDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "plutoblocks", 2), PlutoDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "plutoblocks", 3), PlutoDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "plutoblocks", 4), PlutoDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "plutoblocks", 5), PlutoRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "plutoblocks", 6), PlutoRockDust.getItem(2));
		
		// Kuiper Belt
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftMars", "tile.denseIce"), DenseIceDust.getItem());
		
		// Haumea
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "haumeablocks"), HaumeaRockDust.getItem());
		
		// Haumea
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "makemakegrunt"), MakemakeRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "makemakegrunt", 1), MakemakeRockDust.getItem());
		
		// Koentus
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_ice"), KoentusDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_ice", 1), KoentusDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "space_mossy_cobblestone", 3), KoentusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_block"), KoentusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_block", 1), KoentusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_block", 2), KoentusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_block", 3), KoentusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_block", 11), KoentusRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_block", 12), KoentusRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "koentus_block", 13), KoentusRockDust.getItem(2));
		
		// Diona
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "space_mossy_cobblestone"), DionaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "diona_block"), DionaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "diona_block", 1), DionaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "diona_block", 2), DionaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "diona_block", 3), DionaRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "diona_block", 14), DionaRockDust.getItem(2));
		
		// aCentauri Bb
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "acentauribbgrunt"), ACentauriBbRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "acentauribbsubgrunt"), ACentauriBbRockDust.getItem());
		
		// Polongnius
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "space_mossy_cobblestone", 1), PolongniusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "polongnius_block", 2), PolongniusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "polongnius_block", 3), PolongniusRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "polongnius_block", 13), PolongniusRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "polongnius_block", 14), PolongniusRockDust.getItem(4));
		
		// Barnarda C
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "barnardaCgrass"), BarnardaCDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "barnardaCdirt"), BarnardaCDust.getItem());
		
		// Barnarda E
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "barnardaEgrunt"), BarnardaERockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "barnardaEsubgrunt"), BarnardaERockDust.getItem());
		
		// Barnarda F
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "barnardaFgrunt"), BarnardaFRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "barnardaFsubgrunt"), BarnardaFRockDust.getItem());
		
		// Nibiru
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "space_mossy_cobblestone", 2), NibiruRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "nibiru_block"), NibiruRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "nibiru_block", 1), NibiruRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "nibiru_block", 2), NibiruRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "nibiru_block", 3), NibiruRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "nibiru_block", 12), NibiruRockDust.getItem(2));
		
		// T Ceti E
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "tcetieblocks"), TCetiERockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "tcetieblocks", 1), TCetiERockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalaxySpace", "tcetieblocks", 2), TCetiERockDust.getItem());
		
		// Eden
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edencobblerock"), EdenRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edenrock"), EdenRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edenrockbricks"), EdenRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edensurfaceblock"), EdenRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edensoil"), EdenDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edengrass"), EdenDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edengoldengrass"), EdenDust.getItem(4));
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_bloodsand"), EdenDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edenwinterrock"), EdenRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_bonestone"), EdenRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edengravel"), EdenDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_bloodstone"), EdenRockDust.getItem(4));
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_edensacredstone"), EdenRockDust.getItem(4));
		
		// Kapteyn B
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "space_mossy_cobblestone", 4), KapteynBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "kapteyn-b_block"), KapteynBDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "kapteyn-b_block", 1), KapteynBDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "kapteyn-b_block", 2), KapteynBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "kapteyn-b_block", 3), KapteynBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "kapteyn-b_block", 14), KapteynBRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "kapteyn-b_ice"), KapteynBDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "kapteyn-b_ice", 1), KapteynBDust.getItem());
		
		// Fronos
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_dirt"), FronosDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_dirt", 1), FronosDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_grass"), FronosDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_sand"), FronosDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_sandstone"), FronosDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_sandstone", 1), FronosDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_sandstone", 2), FronosDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_block"), FronosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_block", 1), FronosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_block", 11), FronosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_block", 12), FronosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_block", 13), FronosRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "fronos_block", 14), FronosRockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "mossy_fronos_cobblestone"), FronosRockDust.getItem());
		
		// Eden
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_zoldirt"), ZollusDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_zolrockbricks"), ZolrockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_solarblock"), ZolrockDust.getItem(2));
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_zolcobblerock"), ZolrockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_zolstone"), ZolrockDust.getItem());
		
		// Sirius B
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "space_mossy_cobblestone", 5), SiriusBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "sirius_block"), SiriusBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "sirius_block", 1), SiriusBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "sirius_block", 2), SiriusBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "sirius_block", 3), SiriusBRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "sirius_block", 7), SiriusBRockDust.getItem(4));
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "sirius_block", 9), SiriusBRockDust.getItem(2));
		
		// Oasis
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_oasisgrass"), OasisDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_oasisdirt"), OasisDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_oasiscobblerock"), OasisRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_oasisrock"), OasisRockDust.getItem());
		
		// Xathius
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_xathgrass"), XathianDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_xathdirt"), XathianDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_xathstone"), XathianRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_xathrock"), XathianRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_xathcobblerock"), XathianRockDust.getItem());
		
		// Purgot
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_purgdirt"), PurgotDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_purgcobblerock"), PurgotRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_purgstone"), PurgotRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_purgrock"), PurgotRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("galaxymod", "galaxymod_purgrockbricks"), PurgotRockDust.getItem());
		
		// Neper
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.baseBlockRock", 10), NeperDust.getItem());
		
		// Maahes
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.wood1"), MaahesDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.wood1", 1), MaahesDust.getItem());
	
		// Anubis
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.baseBlockRock", 1), BasaltRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.baseBlockGround", 1), BasaltDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.baseFalling", 2), BasaltDust.getItem());
		
		// Horus
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.baseFalling"), ObsidianSandDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.baseFalling", 1), ObsidianSandDust.getItem());
		
		// Seth
		addMaceratorRecipe(RecipeUtilGS.getItem("GalacticraftAmunRa", "tile.baseBlockCrystal"), CoralDust.getItem(2));
		
		// Dark Asteroids
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "dark_asteroid_block"), DarkAsteroidRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "dark_asteroid_block", 1), DarkAsteroidRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "dark_asteroid_block", 2), DarkAsteroidRockDust.getItem());
		addMaceratorRecipe(RecipeUtilGS.getItem("MorePlanet", "dark_asteroid_quicksand"), DarkAsteroidDust.getItem());
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

}
