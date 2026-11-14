package com.voidd.shards.registry;

import com.voidd.shards.VoidShards;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public final class ModItems {
	private ModItems() {
	}

	// Materials
	public static final Item VOID_SHARD = register("void_shard", Item::new, new Item.Properties());
	public static final Item VOID_INGOT = register("void_ingot", Item::new, new Item.Properties());

	// Block items
	public static final Item VOID_ORE = registerBlockItem("void_ore", ModBlocks.VOID_ORE, ModBlocks.VOID_ORE_KEY);
	public static final Item DEEPSLATE_VOID_ORE = registerBlockItem("deepslate_void_ore", ModBlocks.DEEPSLATE_VOID_ORE, ModBlocks.DEEPSLATE_VOID_ORE_KEY);
	public static final Item VOID_BLOCK = registerBlockItem("void_block", ModBlocks.VOID_BLOCK, ModBlocks.VOID_BLOCK_KEY);

	// Tools
	public static final Item VOID_SWORD = register("void_sword", Item::new,
			new Item.Properties().sword(ModToolMaterials.VOID, 4.0F, -2.4F));
	public static final Item VOID_PICKAXE = register("void_pickaxe", Item::new,
			new Item.Properties().pickaxe(ModToolMaterials.VOID, 2.0F, -2.8F));
	public static final Item VOID_AXE = register("void_axe", Item::new,
			new Item.Properties().axe(ModToolMaterials.VOID, 6.0F, -3.0F));
	public static final Item VOID_SHOVEL = register("void_shovel", Item::new,
			new Item.Properties().shovel(ModToolMaterials.VOID, 2.0F, -3.0F));
	public static final Item VOID_HOE = register("void_hoe", Item::new,
			new Item.Properties().hoe(ModToolMaterials.VOID, -2.0F, 0.0F));

	// Armor
	public static final Item VOID_HELMET = register("void_helmet", Item::new,
			new Item.Properties().humanoidArmor(ModArmorMaterials.VOID, ArmorType.HELMET));
	public static final Item VOID_CHESTPLATE = register("void_chestplate", Item::new,
			new Item.Properties().humanoidArmor(ModArmorMaterials.VOID, ArmorType.CHESTPLATE));
	public static final Item VOID_LEGGINGS = register("void_leggings", Item::new,
			new Item.Properties().humanoidArmor(ModArmorMaterials.VOID, ArmorType.LEGGINGS));
	public static final Item VOID_BOOTS = register("void_boots", Item::new,
			new Item.Properties().humanoidArmor(ModArmorMaterials.VOID, ArmorType.BOOTS));

	/**
	 * Forces this class to be loaded so that all static registrations run.
	 */
	public static void init() {
	}

	private static Item registerBlockItem(String name, net.minecraft.world.level.block.Block block, ResourceKey<net.minecraft.world.level.block.Block> blockKey) {
		return register(name, properties -> new BlockItem(block, properties
				.useBlockDescriptionPrefix()
				.requiredFeatures(block.requiredFeatures())), new Item.Properties());
	}

	private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, VoidShards.id(name));
		Item item = factory.apply(properties.setId(key));

		// Keep the vanilla item <-> block lookup in sync, just like Items#registerItem does.
		if (item instanceof BlockItem blockItem) {
			blockItem.registerBlocks(Item.BY_BLOCK, item);
		}

		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}
}
