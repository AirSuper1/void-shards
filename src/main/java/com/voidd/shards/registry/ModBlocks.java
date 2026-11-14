package com.voidd.shards.registry;

import com.voidd.shards.VoidShards;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public final class ModBlocks {
	private ModBlocks() {
	}

	public static final ResourceKey<Block> VOID_ORE_KEY = key("void_ore");
	public static final ResourceKey<Block> DEEPSLATE_VOID_ORE_KEY = key("deepslate_void_ore");
	public static final ResourceKey<Block> VOID_BLOCK_KEY = key("void_block");

	public static final Block VOID_ORE = register(
			VOID_ORE_KEY,
			properties -> new DropExperienceBlock(UniformInt.of(3, 7), properties),
			oreProperties(MapColor.STONE, SoundType.STONE)
	);

	public static final Block DEEPSLATE_VOID_ORE = register(
			DEEPSLATE_VOID_ORE_KEY,
			properties -> new DropExperienceBlock(UniformInt.of(3, 7), properties),
			oreProperties(MapColor.DEEPSLATE, SoundType.DEEPSLATE)
	);

	public static final Block VOID_BLOCK = register(
			VOID_BLOCK_KEY,
			Block::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_PURPLE)
					.strength(5.0F, 6.0F)
					.sound(SoundType.METAL)
					.requiresCorrectToolForDrops()
	);

	/**
	 * Forces this class to be loaded so that all static registrations run.
	 */
	public static void init() {
	}

	private static BlockBehaviour.Properties oreProperties(MapColor mapColor, SoundType soundType) {
		return BlockBehaviour.Properties.of()
				.mapColor(mapColor)
				.strength(4.5F, 3.0F)
				.sound(soundType)
				.requiresCorrectToolForDrops();
	}

	private static Block register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
		Block block = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.BLOCK, key, block);
	}

	private static ResourceKey<Block> key(String name) {
		return ResourceKey.create(Registries.BLOCK, VoidShards.id(name));
	}
}
