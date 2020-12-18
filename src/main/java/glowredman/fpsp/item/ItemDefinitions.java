package glowredman.fpsp.item;

import glowredman.fpsp.FPSP;
import net.minecraft.item.ItemStack;

public enum ItemDefinitions {

	// Stuff
	MassZivicioDust(0),

	// Moon
	MoonRockDust(1),

	// Mars
	MarsRockDust(2),

	// Phobos
	PhobosRockDust(3),

	// Deimos
	DeimosRockDust(4),

	// All sorts of asteroids
	AsteroidRockDust(5),

	// Callisto
	CallistoRockDust(6),

	// Ganymede
	GanymedeRockDust(7),

	// Ceres
	CeresRockDust(8),

	// Europa
	EuropaDust(9), EuropaRockDust(42),

	// Io
	IoRockDust(10),

	// Mercury
	MercuryRockDust(11),

	// Venus
	VenusRockDust(12),

	// Enceladus
	EnceladusRockDust(13),

	// Titan
	TitanRockDust(14),

	// Miranda
	MirandaRockDust(15),

	// Oberon
	OberonRockDust(16),

	// Proteus
	ProteusRockDust(17),

	// Triton
	TritonRockDust(18),

	// Vega B
	VegaBRockDust(19),

	// Pluto
	PlutoRockDust(20),

	// Kuiper Belt
	DenseIceDust(21),

	// Haumea
	HaumeaRockDust(22),

	// Makemake
	MakemakeRockDust(23),

	// Koentus
	KoentusRockDust(24),

	// Diona
	DionaRockDust(25),

	// aCentauri Bb
	aCentauriBbRockDust(26),

	// Plongius
	PolongiusRockDust(27),

	// Barnarda Planets
	BarnardaCDust(28), BarnardaERockDust(29), BarnardaFRockDust(30),

	// Nibiru
	NibiruRockDust(31),

	// T Ceti E
	TCetiERockDust(32),

	// Eden
	EdenRockDust(33), EdenDust(43),

	// Kapteyn
	KapteynBRockDust(34),

	// Fronos
	FronosRockDust(35), FronosDust(44),

	// Kriffon
	KriffonRockDust(36), KriffonDust(45),

	// Zollus
	ZolrockDust(37), ZollusDust(46),

	// Sirius B
	SiriusBRockDust(38),

	// Oasis
	OasisRockDust(39), OasisDust(47),

	// Xathius
	XathianRockDust(40), XathianDust(48),

	// Purgot
	PurgotRockDust(41), PurgotDust(49),

	// Horus
	ObsidianSandDust(50),

	// Anubis Neper
	BasaltDust(51), NeperDust(52),

	// Maahes
	MaahesDust(53),

	// Seth
	CoralDust(54),

	// Dark Asteroids
	DarkAsteroidRockDust(55),

	;

	private int meta;

	private ItemDefinitions(int meta) {
		this.meta = meta;
	}

	public String getName() {
		return this.toString();
	}

	public int getMeta() {
		return this.meta;
	}

	public ItemStack getItem() {
		return this.getItem(1);
	}

	public ItemStack getItem(int amount) {
		return new ItemStack(FPSP.ITEM, amount, this.getMeta());
	}

}
