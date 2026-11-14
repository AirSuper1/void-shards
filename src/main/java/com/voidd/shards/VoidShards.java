package com.voidd.shards;

import com.voidd.shards.registry.ModBlocks;
import com.voidd.shards.registry.ModCreativeTabs;
import com.voidd.shards.registry.ModItems;
import com.voidd.shards.worldgen.ModWorldGen;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoidShards implements ModInitializer {
	public static final String MOD_ID = "void-shards";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Blocks must be registered before block items.
		ModBlocks.init();
		ModItems.init();
		ModCreativeTabs.init();
		ModWorldGen.init();

		LOGGER.info("Void Shards loaded - the void is calling.");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
