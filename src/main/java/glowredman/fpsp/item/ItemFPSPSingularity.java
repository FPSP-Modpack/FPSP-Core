package glowredman.fpsp.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;

import fox.spiteful.avaritia.items.ItemSingularity;

public class ItemFPSPSingularity extends ItemSingularity {

    public static final SingularityDefinitions[] TYPES = SingularityDefinitions.values();

    public ItemFPSPSingularity() {
        super();
        this.setUnlocalizedName("singularity");
    }

    @Override
    public int getColorFromItemStack(ItemStack itemstack, int renderpass) {
        return renderpass == 0 ? TYPES[itemstack.getItemDamage() % TYPES.length].getColor1()
            : TYPES[itemstack.getItemDamage() % TYPES.length].getColor2();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName() + "."
            + TYPES[MathHelper.clamp_int(stack.getItemDamage(), 0, TYPES.length)].toString();
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int i = 0; i < TYPES.length; i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.uncommon;
    }

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List<String> tooltip, boolean debugInfo) {
        if (TYPES[MathHelper.clamp_int(item.getItemDamage(), 0, TYPES.length)].getAmount() <= 0) {
            tooltip.add(EnumChatFormatting.RED + "Disabled");
        }
    }

    @Override
    public int getHaloSize(ItemStack stack) {
        return 4;
    }

}
