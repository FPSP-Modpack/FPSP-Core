package glowredman.fpsp.item;

import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import glowredman.fpsp.FPSP;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemMeta extends Item {

	protected HashMap<Integer, IIcon> icons = new HashMap<Integer, IIcon>();
	public static HashMap<Integer, ItemDefinitions> meta2item = new HashMap<Integer, ItemDefinitions>();

	public ItemMeta() {
		this.setHasSubtypes(true);
		this.setUnlocalizedName("item");

		for (ItemDefinitions item : ItemDefinitions.values()) {
			meta2item.put(item.getMeta(), item);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		for (ItemDefinitions item : ItemDefinitions.values()) {
			icons.put(item.getMeta(), iconRegister.registerIcon(FPSP.MODID + ":" + item.getName()));
		}
	}

	@SideOnly(Side.CLIENT)
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
	@SuppressWarnings("unchecked")
	public void getSubItems(Item item, CreativeTabs tab, List variants) {
		if (tab == CreativeTabs.tabAllSearch) {
			for (ItemDefinitions itemDef : ItemDefinitions.values()) {
				variants.add(itemDef.getItem());
			}
		}
	}

}
