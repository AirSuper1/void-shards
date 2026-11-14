package com.voidd.shards.registry;

import com.voidd.shards.VoidShards;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public final class ModArmorMaterials {
	private ModArmorMaterials() {
	}

	public static final ResourceKey<EquipmentAsset> VOID_ASSET =
			ResourceKey.create(EquipmentAssets.ROOT_ID, VoidShards.id("void"));

	public static final ArmorMaterial VOID = new ArmorMaterial(
			40,
			Map.of(
					ArmorType.HELMET, 4,
					ArmorType.CHESTPLATE, 9,
					ArmorType.LEGGINGS, 7,
					ArmorType.BOOTS, 4,
					ArmorType.BODY, 13
			),
			20,
			SoundEvents.ARMOR_EQUIP_DIAMOND,
			3.5F,
			0.15F,
			ModTags.VOID_REPAIR_MATERIALS,
			VOID_ASSET
	);
}
