package com.voidd.shards.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public final class ModToolMaterials {
	private ModToolMaterials() {
	}

	/**
	 * Between diamond and netherite when it comes to durability, but faster and
	 * with a higher enchantability. Void tools can mine everything netherite can.
	 */
	public static final ToolMaterial VOID = new ToolMaterial(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
			2500,
			10.0F,
			5.0F,
			20,
			ModTags.VOID_REPAIR_MATERIALS
	);
}
