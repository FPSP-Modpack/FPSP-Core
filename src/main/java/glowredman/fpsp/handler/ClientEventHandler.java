package glowredman.fpsp.handler;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import glowredman.fpsp.FPSP;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class ClientEventHandler {

	private static final ResourceLocation hearts = new ResourceLocation(FPSP.MODID, "textures/gui/newhearts.png");

	Minecraft mc = Minecraft.getMinecraft();
	Random rand = new Random();
	int updateCounter = 0;

	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent.Pre event) {
		if (event.type != ElementType.HEALTH)
			return;

		updateCounter++;

		ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		int scaledWidth = scaledresolution.getScaledWidth();
		int scaledHeight = scaledresolution.getScaledHeight();
		int xBasePos = scaledWidth / 2 - 91;
		int yBasePos = scaledHeight - 39;

		boolean highlight = mc.thePlayer.hurtResistantTime / 3 % 2 == 1;

		if (mc.thePlayer.hurtResistantTime < 10)
			highlight = false;

		int health = MathHelper.ceiling_float_int(mc.thePlayer.getHealth());
		int healthLast = MathHelper.ceiling_float_int(mc.thePlayer.prevHealth);
		float healthMax = (float) mc.thePlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
		if (healthMax > 20)
			healthMax = 20;
		float absorb = mc.thePlayer.getAbsorptionAmount();

		int healthRows = MathHelper.ceiling_float_int((healthMax + absorb) / 20.0F);
		int rowHeight = Math.max(12 - healthRows, 3);

		rand.setSeed(updateCounter * 312871);

		int left = scaledWidth / 2 - 91;
		int top = scaledHeight - GuiIngameForge.left_height;

		if (!GuiIngameForge.renderExperiance) {
			top += 7;
			yBasePos += 7;
		}

		int regen = -1;
		if (mc.thePlayer.isPotionActive(Potion.regeneration)) {
			regen = updateCounter % 25;
		}

		final int TOP = 9 * (mc.theWorld.getWorldInfo().isHardcoreModeEnabled() ? 5 : 0);
		final int BACKGROUND = (highlight ? 25 : 16);
		int MARGIN = 16;
		if (mc.thePlayer.isPotionActive(Potion.poison))
			MARGIN += 36;
		else if (mc.thePlayer.isPotionActive(Potion.wither))
			MARGIN += 72;
		float absorbRemaining = absorb;

		for (int i = MathHelper.ceiling_float_int((healthMax + absorb) / 2.0F) - 1; i >= 0; --i) {
			int row = MathHelper.ceiling_float_int((i + 1) / 10.0F) - 1;
			int x = left + i % 10 * 8;
			int y = top - row * rowHeight;

			if (health <= 4)
				y += rand.nextInt(2);
			if (i == regen)
				y -= 2;

			drawTexturedModalRect(x, y, BACKGROUND, TOP, 9, 9);

			if (highlight) {
				if (i * 2 + 1 < healthLast)
					drawTexturedModalRect(x, y, MARGIN + 54, TOP, 9, 9); // 6
				else if (i * 2 + 1 == healthLast)
					drawTexturedModalRect(x, y, MARGIN + 63, TOP, 9, 9); // 7
			}

			if (absorbRemaining > 0.0F) {
				if (absorbRemaining == absorb && absorb % 2.0F == 1.0F)
					drawTexturedModalRect(x, y, MARGIN + 153, TOP, 9, 9); // 17
				else
					drawTexturedModalRect(x, y, MARGIN + 144, TOP, 9, 9); // 16
				absorbRemaining -= 2.0F;
			} else {
				if (i * 2 + 1 < health)
					drawTexturedModalRect(x, y, MARGIN + 36, TOP, 9, 9); // 4
				else if (i * 2 + 1 == health)
					drawTexturedModalRect(x, y, MARGIN + 45, TOP, 9, 9); // 5
			}
		}

		int potionOffset = 0;
		PotionEffect potion = mc.thePlayer.getActivePotionEffect(Potion.wither);
		if (potion != null)
			potionOffset = 18;
		potion = mc.thePlayer.getActivePotionEffect(Potion.poison);
		if (potion != null)
			potionOffset = 9;
		if (mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
			potionOffset += 27;

		// Extra hearts
		mc.getTextureManager().bindTexture(hearts);

		int hp = MathHelper.ceiling_float_int(mc.thePlayer.getHealth());
		for (int iter = 0; iter < hp / 20; iter++) {
			int renderHearts = (hp - 20 * (iter + 1)) / 2;
			if (renderHearts > 10)
				renderHearts = 10;
			for (int i = 0; i < renderHearts; i++) {
				int y = 0;
				if (i == regen)
					y -= 2;
				drawTexturedModalRect(xBasePos + 8 * i, yBasePos + y, 0 + 18 * iter, potionOffset, 9, 9);
			}
			if (hp % 2 == 1 && renderHearts < 10) {
				drawTexturedModalRect(xBasePos + 8 * renderHearts, yBasePos, 9 + 18 * iter, potionOffset, 9, 9);
			}
		}

		GuiIngameForge.left_height += 10;
		if (absorb > 0)
			GuiIngameForge.left_height += 10;

		event.setCanceled(true);
	}

	public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
		float f = 0.00390625F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x,         y + height, 0,  textureX          * f, (textureY + height) * f);
		tessellator.addVertexWithUV(x + width, y + height, 0, (textureX + width) * f, (textureY + height) * f);
		tessellator.addVertexWithUV(x + width, y,          0, (textureX + width) * f,  textureY           * f);
		tessellator.addVertexWithUV(x,         y,          0,  textureX          * f,  textureY           * f);
		tessellator.draw();
	}

}
