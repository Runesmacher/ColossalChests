package org.cyclops.colossalchests.modcompat;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.cyclops.colossalchests.ColossalChests;
import org.cyclops.colossalchests.Reference;
import org.cyclops.colossalchests.block.PropertyMaterial;
import org.cyclops.colossalchests.client.render.tileentity.RenderTileEntityColossalChest;
import org.cyclops.cyclopscore.helper.MinecraftHelpers;
import org.cyclops.cyclopscore.modcompat.IModCompat;

/**
 * Mod compat for the Iron Chest mod.
 * @author rubensworks
 *
 */
public class IronChestModCompat implements IModCompat {

	@Override
	public void onInit(Step initStep) {
		if(MinecraftHelpers.isClientSide() && initStep == Step.POSTINIT &&
				ColossalChests._instance.getModCompatLoader().shouldLoadModCompat(this)) {
			overrideTextures();
		}
	}

	@SideOnly(Side.CLIENT)
	private void overrideTextures() {
		String prefix = "textures/model/";
		RenderTileEntityColossalChest.TEXTURES_CHEST.put(PropertyMaterial.Type.COPPER,
				new ResourceLocation("ironchest", prefix + "copperchest.png"));
		RenderTileEntityColossalChest.TEXTURES_CHEST.put(PropertyMaterial.Type.IRON,
				new ResourceLocation("ironchest", prefix + "ironchest.png"));
		RenderTileEntityColossalChest.TEXTURES_CHEST.put(PropertyMaterial.Type.SILVER,
				new ResourceLocation("ironchest", prefix + "silverchest.png"));
		RenderTileEntityColossalChest.TEXTURES_CHEST.put(PropertyMaterial.Type.GOLD,
				new ResourceLocation("ironchest", prefix + "goldchest.png"));
		RenderTileEntityColossalChest.TEXTURES_CHEST.put(PropertyMaterial.Type.DIAMOND,
				new ResourceLocation("ironchest", prefix + "diamondchest.png"));
	}

	@Override
	public String getModID() {
		return Reference.MOD_IRONCHEST;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getComment() {
		return "If the non-wood variants should use the textures of the Iron Chest mod.";
	}

}
