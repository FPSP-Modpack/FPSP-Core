package glowredman.fpsp.crop;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import glowredman.fpsp.FPSP;
import glowredman.fpsp.Utils;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.oredict.OreDictionary;
import speiger.src.crops.api.ICropCardInfo;

public class BaseCrop extends CropCard implements ICropCardInfo {

	private List<String> cropInfo;
	private ItemStack displayItem;
	private String name;
	private int tier;
	private int[] stats = new int[5];
	private String[] attributes;
	private int maxSize;
	private int harvestSize;
	private List<String> requiredBlocks;
	private String discoverer;
	private ItemStack normalDrop;
	private ItemStack[] specialDrops;
	private byte sizeAfterHarvest;
	private int growthSpeed;

	/**
	 * 
	 * @param name             Name of the Crop
	 * @param discoverer       The one who discovered the Crop
	 * @param tier             Tier of the Crop. Forced to be >= 1
	 * @param maxSize          Maximum Size of the Crop. Forced to be >= 3
	 * @param growthSpeed      * tier = growthDuration. Forced to be >= 200
	 * @param afterHarvestSize Size of the crop after harvesting it. Forced to be
	 *                         between 1 and maxSize - 1
	 * @param harvestSize      Minimum Size required to harvest the crop. Forced to
	 *                         be between 2 and maxSize
	 * @param statChemical     Chemistry (Industrial uses based on chemical plant
	 *                         components)
	 * @param statFood         Consumable (Food, potion ingredients, stuff meant to
	 *                         be eaten or similarly used)
	 * @param statDefensive    Defensive (Plants with defense capabilities
	 *                         (damaging, explosive, chemical) or special abilities
	 *                         in general)
	 * @param statColor        Colorful (How colorful/aesthetically/beautiful is the
	 *                         plant, like dye-plants or plants without actual
	 *                         effects)
	 * @param statWeed         Weed (Is this plant weed-like and rather
	 *                         unwanted/quick-spreading? Rare super-breed plants
	 *                         should have low values here)
	 * @param attributes       Crops sharing stats and attributes tend to
	 *                         cross-breed more often
	 * @param drop             The Item which is dropped by the Crop. Must be
	 *                         nonnull.
	 * @param displayItem      Item to display in the Breeding Calculator
	 * @param cropInfo         Info such as required Blocks
	 */
	public BaseCrop(String name, String discoverer, int tier, int maxSize, int growthSpeed, int afterHarvestSize,
			int harvestSize, int statChemical, int statFood, int statDefensive, int statColor, int statWeed,
			String[] attributes, ItemStack drop, ItemStack displayItem, List<String> cropInfo) {
		this(name, discoverer, tier, maxSize, growthSpeed, afterHarvestSize, harvestSize, statChemical, statFood,
				statDefensive, statColor, statWeed, attributes, null, drop, null, displayItem, cropInfo);
	}

	/**
	 * 
	 * @param name             Name of the Crop
	 * @param discoverer       The one who discovered the Crop
	 * @param tier             Tier of the Crop. Forced to be >= 1
	 * @param maxSize          Maximum Size of the Crop. Forced to be >= 3
	 * @param growthSpeed      * tier = growthDuration. Forced to be >= 200
	 * @param afterHarvestSize Size of the crop after harvesting it. Forced to be
	 *                         between 1 and maxSize - 1
	 * @param harvestSize      Minimum Size required to harvest the crop. Forced to
	 *                         be between 2 and maxSize
	 * @param statChemical     Chemistry (Industrial uses based on chemical plant
	 *                         components)
	 * @param statFood         Consumable (Food, potion ingredients, stuff meant to
	 *                         be eaten or similarly used)
	 * @param statDefensive    Defensive (Plants with defense capabilities
	 *                         (damaging, explosive, chemical) or special abilities
	 *                         in general)
	 * @param statColor        Colorful (How colorful/aesthetically/beautiful is the
	 *                         plant, like dye-plants or plants without actual
	 *                         effects)
	 * @param statWeed         Weed (Is this plant weed-like and rather
	 *                         unwanted/quick-spreading? Rare super-breed plants
	 *                         should have low values here)
	 * @param attributes       Crops sharing stats and attributes tend to
	 *                         cross-breed more often
	 * @param drop             The Item which is dropped by the Crop. Must be
	 *                         nonnull.
	 * @param specialDrops     Special Items to drop. null = no special Drops
	 * @param displayItem      Item to display in the Breeding Calculator
	 * @param cropInfo         Info such as required Blocks
	 */
	public BaseCrop(String name, String discoverer, int tier, int maxSize, int growthSpeed, int afterHarvestSize,
			int harvestSize, int statChemical, int statFood, int statDefensive, int statColor, int statWeed,
			String[] attributes, ItemStack drop, ItemStack[] specialDrops, ItemStack displayItem,
			List<String> cropInfo) {
		this(name, discoverer, tier, maxSize, growthSpeed, afterHarvestSize, harvestSize, statChemical, statFood,
				statDefensive, statColor, statWeed, attributes, null, drop, specialDrops, displayItem, cropInfo);
	}

	/**
	 * 
	 * @param name             Name of the Crop
	 * @param discoverer       The one who discovered the Crop
	 * @param tier             Tier of the Crop. Forced to be >= 1
	 * @param maxSize          Maximum Size of the Crop. Forced to be >= 3
	 * @param growthSpeed      * tier = growthDuration. Forced to be >= 200
	 * @param afterHarvestSize Size of the crop after harvesting it. Forced to be
	 *                         between 1 and maxSize - 1
	 * @param harvestSize      Minimum Size required to harvest the crop. Forced to
	 *                         be between 2 and maxSize
	 * @param statChemical     Chemistry (Industrial uses based on chemical plant
	 *                         components)
	 * @param statFood         Consumable (Food, potion ingredients, stuff meant to
	 *                         be eaten or similarly used)
	 * @param statDefensive    Defensive (Plants with defense capabilities
	 *                         (damaging, explosive, chemical) or special abilities
	 *                         in general)
	 * @param statColor        Colorful (How colorful/aesthetically/beautiful is the
	 *                         plant, like dye-plants or plants without actual
	 *                         effects)
	 * @param statWeed         Weed (Is this plant weed-like and rather
	 *                         unwanted/quick-spreading? Rare super-breed plants
	 *                         should have low values here)
	 * @param attributes       Crops sharing stats and attributes tend to
	 *                         cross-breed more often
	 * @param requiredBlocks   If nonnull, one of these Blocks must be under the
	 *                         Crop for it to grow
	 * @param drop             The Item which is dropped by the Crop. Must be
	 *                         nonnull.
	 * @param specialDrops     Special Items to drop. null = no special Drops
	 * @param displayItem      Item to display in the Breeding Calculator
	 * @param cropInfo         Info such as required Blocks
	 */
	public BaseCrop(String name, String discoverer, int tier, int maxSize, int growthSpeed, int afterHarvestSize,
			int harvestSize, int statChemical, int statFood, int statDefensive, int statColor, int statWeed,
			String[] attributes, List<String> requiredBlocks, ItemStack drop, ItemStack[] specialDrops,
			ItemStack displayItem, List<String> cropInfo) {
		this.name = name;
		this.discoverer = discoverer;
		this.normalDrop = drop;
		this.specialDrops = specialDrops;
		this.tier = Math.max(1, tier);
		this.maxSize = Math.max(3, maxSize);
		this.growthSpeed = Math.max(200, growthSpeed);
		this.harvestSize = MathHelper.clamp_int(harvestSize, 2, maxSize);
		this.sizeAfterHarvest = (byte) MathHelper.clamp_int(afterHarvestSize, 1, maxSize - 1);
		this.stats[0] = statChemical;
		this.stats[1] = statFood;
		this.stats[2] = statDefensive;
		this.stats[3] = statColor;
		this.stats[4] = statWeed;
		this.attributes = attributes;
		this.requiredBlocks = requiredBlocks;
		this.displayItem = displayItem;
		this.cropInfo = cropInfo;
		Crops.instance.registerCrop(this);
	}

	@Override
	public List<String> getCropInformation() {
		return cropInfo;
	}

	@Override
	public ItemStack getDisplayItem() {
		return displayItem;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public int tier() {
		return tier;
	}

	@Override
	public int stat(int n) {
		return stats[n];
	}

	@Override
	public String[] attributes() {
		return attributes;
	}

	@Override
	public int maxSize() {
		return maxSize;
	}

	@Override
	public String discoveredBy() {
		return discoverer;
	}

	@Override
	public byte getSizeAfterHarvest(ICropTile crop) {
		return sizeAfterHarvest;
	}

	@Override
	public int getrootslength(ICropTile crop) {
		return 5;
	}

	@Override
	public String owner() {
		return FPSP.MODID;
	}

	@Override
	public int getOptimalHavestSize(ICropTile crop) {
		return maxSize();
	}

	@Override
	public boolean canCross(ICropTile crop) {
		return crop.getSize() + 2 > maxSize();
	}

	@Override
	public int growthDuration(ICropTile crop) {
		return tier() * growthSpeed;
	}

	@Override
	public boolean canGrow(ICropTile crop) {
		if (crop == null)
			return false;
		if (requiredBlocks != null && !requiredBlocks.isEmpty() && crop.getSize() == maxSize() - 1)
			for (int depth = 0; depth < getrootslength(crop); depth++) {
				Block block = crop.getWorld().getBlock(crop.getLocation().posX, crop.getLocation().posY - depth,
						crop.getLocation().posZ);
				if (block.isAir(crop.getWorld(), crop.getLocation().posX, crop.getLocation().posY - depth,
						crop.getLocation().posZ))
					return false;
				int meta = crop.getWorld().getBlockMetadata(crop.getLocation().posX, crop.getLocation().posY - depth,
						crop.getLocation().posZ);

			}
		return crop.getSize() >= maxSize();
	}

	@Override
	public boolean canBeHarvested(ICropTile crop) {
		return crop.getSize() >= harvestSize;
	}

	@Override
	public ItemStack getGain(ICropTile crop) {
		int drop = 0;
		if (specialDrops != null
				&& (drop = ThreadLocalRandom.current().nextInt(0, specialDrops.length * 2 + 2)) < specialDrops.length
				&& specialDrops[drop] != null)
			return specialDrops[drop].copy();
		return normalDrop.copy();
	}

	private boolean isRequiredBlock(Block block, int meta) {
		for (String ore : requiredBlocks)
			for (ItemStack stack : OreDictionary.getOres(ore)) {
				Block b = Utils.getBlock(stack);
				if (b != null && b == block && stack.getItemDamage() == meta)
					return true;
			}
		return false;
	}

}
