package glowredman.fpsp.item;

import java.util.List;

import fox.spiteful.avaritia.items.ItemSingularity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemFPSPSingularity extends ItemSingularity {

	public static final SingularityDefinitions[] types = SingularityDefinitions.values();

	public ItemFPSPSingularity() {
		super();
		this.setUnlocalizedName("singularity");
	}

	@Override
	public int getColorFromItemStack(ItemStack itemstack, int renderpass) {
		return renderpass == 0 ? types[itemstack.getItemDamage() % types.length].getColor1()
				: types[itemstack.getItemDamage() % types.length].getColor2();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "."
				+ types[MathHelper.clamp_int(stack.getItemDamage(), 0, types.length)].toString();
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < types.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.uncommon;
	}

	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List tooltip, boolean wut) {
		// NO-OP
	}

	@Override
	public int getHaloSize(ItemStack stack) {
		return 4;
	}

}
