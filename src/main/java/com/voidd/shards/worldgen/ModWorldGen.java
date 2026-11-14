package com.voidd.shards.worldgen;

import com.voidd.shards.VoidShards;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public final class ModWorldGen {
	private ModWorldGen() {
	}

	public static final ResourceKey<PlacedFeature> VOID_ORE =
			ResourceKey.create(Registries.PLACED_FEATURE, VoidShards.id("void_ore"));

	public static void init() {
		BiomeModifications.addFeature(
				BiomeSelectors.foundInOverworld(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				VOID_ORE
		);
	}
}
