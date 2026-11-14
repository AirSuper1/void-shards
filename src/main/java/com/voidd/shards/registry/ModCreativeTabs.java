package com.voidd.shards.registry;

import com.voidd.shards.VoidShards;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModCreativeTabs {
	private ModCreativeTabs() {
	}

	public static final ResourceKey<CreativeModeTab> VOID_SHARDS =
			ResourceKey.create(Registries.CREATIVE_MODE_TAB, VoidShards.id("void_shards"));

	public static void init() {
		CreativeModeTab tab = FabricCreativeModeTab.builder()
				.title(Component.translatable("itemGroup.void-shards"))
				.icon(() -> new ItemStack(ModItems.VOID_SHARD))
				.displayItems((parameters, output) -> {
					output.accept(ModItems.VOID_ORE);
					output.accept(ModItems.DEEPSLATE_VOID_ORE);
					output.accept(ModItems.VOID_SHARD);
					output.accept(ModItems.VOID_INGOT);
					output.accept(ModItems.VOID_BLOCK);
					output.accept(ModItems.VOID_SWORD);
					output.accept(ModItems.VOID_PICKAXE);
					output.accept(ModItems.VOID_AXE);
					output.accept(ModItems.VOID_SHOVEL);
					output.accept(ModItems.VOID_HOE);
					output.accept(ModItems.VOID_HELMET);
					output.accept(ModItems.VOID_CHESTPLATE);
					output.accept(ModItems.VOID_LEGGINGS);
					output.accept(ModItems.VOID_BOOTS);
				})
				.build();

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, VOID_SHARDS, tab);
	}
}
