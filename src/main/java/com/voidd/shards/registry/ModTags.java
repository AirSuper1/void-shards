package com.voidd.shards.registry;

import com.voidd.shards.VoidShards;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModTags {
	private ModTags() {
	}

	public static final TagKey<Item> VOID_REPAIR_MATERIALS = TagKey.create(Registries.ITEM, VoidShards.id("void_repair_materials"));
}
