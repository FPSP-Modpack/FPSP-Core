package glowredman.fpsp.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import glowredman.fpsp.FPSP;

public class ItemIcon extends Item {

    private IIcon[] textures;
    private static final String[] TYPES = new String[] { "orbs" };

    public ItemIcon() {
        this.setHasSubtypes(true);
    }

    @Override
    public void registerIcons(IIconRegister register) {
        textures = new IIcon[TYPES.length];
        for (int i = 0; i < TYPES.length; i++) {
            textures[i] = register.registerIcon(FPSP.MODID + ":icon/" + TYPES[i]);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return textures[meta < textures.length ? meta : 0];
    }

}
