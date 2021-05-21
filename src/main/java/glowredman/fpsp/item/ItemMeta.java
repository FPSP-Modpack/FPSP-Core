package glowredman.fpsp.item;

import java.util.HashMap;
import java.util.List;

import glowredman.fpsp.FPSP;
import glowredman.fpsp.Utils;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemMeta extends ItemFood {

	private HashMap<Integer, IIcon> icons = new HashMap<Integer, IIcon>();
	public static HashMap<Integer, ItemDefinitions> meta2item = new HashMap<Integer, ItemDefinitions>();

	public ItemMeta() {
		super(20, 20, false);
		this.setCreativeTab(CreativeTabs.tabAllSearch);
		this.setHasSubtypes(true);
		this.setUnlocalizedName("item");

		for (ItemDefinitions item : ItemDefinitions.values()) {
			meta2item.put(item.getMeta(), item);
		}
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		for (ItemDefinitions item : ItemDefinitions.values()) {
			icons.put(item.getMeta(), iconRegister.registerIcon(FPSP.MODID + ":" + item.getName()));
		}
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		return icons.containsKey(meta) ? icons.get(meta) : super.getIconFromDamage(meta);
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		int meta = stack.getItemDamage();
		return icons.containsKey(meta) ? "item." + meta2item.get(meta).getName() : "unnamed";
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List variants) {
		for (ItemDefinitions itemDef : ItemDefinitions.values()) {
			variants.add(itemDef.getItem());
		}
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		
		if (stack.getItemDamage() != ItemDefinitions.Scanner.getMeta())
			return false;

		if (player instanceof EntityPlayerMP) {
			List<String> list = Utils.getCoordinateScan(player, world, x, y, z, side, hitX, hitY, hitZ);
			list.forEach(line -> player.addChatComponentMessage(new ChatComponentText(line)));
			return true;
		}
		return false;
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		return isFood(stack.getItemDamage()) ? super.onEaten(stack, world, player) : stack;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote)
			return;
		int meta = stack.getItemDamage();
		if (meta == ItemDefinitions.CosmicBerry.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 6000, 1));
		else if (meta == ItemDefinitions.CosmicFish.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.field_76434_w.getId(), 6000, 1)); // health boost
		else if (meta == ItemDefinitions.CosmicFruit.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.field_76444_x.getId(), 6000, 1)); // absorption
		else if (meta == ItemDefinitions.CosmicGrain.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 6000, 1));
		else if (meta == ItemDefinitions.CosmicMushroom.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 1, 1));
		else if (meta == ItemDefinitions.CosmicNut.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 6000, 1));
		else if (meta == ItemDefinitions.CosmicSpice.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.jump.getId(), 6000, 1));
		else if (meta == ItemDefinitions.CosmicVeggie.getMeta())
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 6000, 1));
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return isFood(stack.getItemDamage()) ? EnumAction.eat : EnumAction.none;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		return isFood(stack.getItemDamage()) ? super.onItemRightClick(stack, world, player) : stack;
	}

	@Override
	public int func_150905_g(ItemStack stack) {
		return isFood(stack.getItemDamage()) ? 20 : 0;
	}

	@Override
	public float func_150906_h(ItemStack stack) {
		return isFood(stack.getItemDamage()) ? 20.0f : 0.0f;
	}

	private static boolean isFood(int meta) {
		return meta == ItemDefinitions.CosmicBerry.getMeta() || meta == ItemDefinitions.CosmicFish.getMeta()
				|| meta == ItemDefinitions.CosmicFruit.getMeta() || meta == ItemDefinitions.CosmicGrain.getMeta()
				|| meta == ItemDefinitions.CosmicMushroom.getMeta() || meta == ItemDefinitions.CosmicNut.getMeta()
				|| meta == ItemDefinitions.CosmicSpice.getMeta() || meta == ItemDefinitions.CosmicVeggie.getMeta();
	}

}
