package glowredman.fpsp.item;

import glowredman.fpsp.FPSP;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class ItemIcon extends Item {

	private IIcon[] textures;
	private static String[] types = new String[] { "orbs", "puredaisy" };

	public ItemIcon() {
		this.setHasSubtypes(true);
	}

	@Override
	public void registerIcons(IIconRegister register) {
		textures = new IIcon[types.length];
		for (int i = 0; i < types.length; i++) {
			textures[i] = register.registerIcon(FPSP.MODID + ":icon/" + types[i]);
		}
	}

	@Override
	public IIcon getIconFromDamage(int meta) {
		return textures[meta < textures.length ? meta : 0];
	}

}
