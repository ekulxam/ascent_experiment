package com.peppamy.ascentexp;

import com.peppamy.ascentexp.init.AscentExperimentBlocks;
import com.peppamy.ascentexp.init.AscentExperimentItems;
import com.peppamy.ascentexp.init.AscentExperimentParticleTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
import static net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_IRON_TOOL;

public class AscentExperiment implements ModInitializer {
	public static final String MOD_ID = "ascent-experiment";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TagKey<Item> REPAIRS_SAPPHIRE_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(MOD_ID, "repairs_sapphire_armor"));
	public static final TagKey<Item> REPAIRS_RUTILE_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(MOD_ID, "repairs_rutile_armor"));
	public static final TagKey<Item> REPAIRS_CHARTIUM_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(MOD_ID, "repairs_chartium_armor"));

	public static class SapphireMaterial implements ToolMaterial {

		public static final SapphireMaterial INSTANCE = new SapphireMaterial();

		@Override
		public int getDurability() {
			return 1274;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 7.0F;
		}

		@Override
		public float getAttackDamage() {
			return 2.5F;
		}

		@Override
		public TagKey<Block> getInverseTag() {
			return INCORRECT_FOR_DIAMOND_TOOL;
		}

		@Override
		public int getEnchantability() {
			return 16;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.fromTag(REPAIRS_SAPPHIRE_ARMOR);
		}
	}
	public static class BloodRutileMaterial implements ToolMaterial {

		public static final BloodRutileMaterial INSTANCE = new BloodRutileMaterial();

		@Override
		public int getDurability() {
			return 415;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 6.5F;
		}

		@Override
		public float getAttackDamage() {
			return 2.0F;
		}

		@Override
		public TagKey<Block> getInverseTag() {
			return INCORRECT_FOR_IRON_TOOL;
		}

		@Override
		public int getEnchantability() {
			return 18;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.fromTag(REPAIRS_RUTILE_ARMOR);
		}
	}
	public static class ChartiumMaterial implements ToolMaterial {

		public static final ChartiumMaterial INSTANCE = new ChartiumMaterial();

		@Override
		public int getDurability() {
			return 521;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 7.5F;
		}

		@Override
		public float getAttackDamage() {
			return 2.0F;
		}

		@Override
		public TagKey<Block> getInverseTag() {
			return INCORRECT_FOR_DIAMOND_TOOL;
		}

		@Override
		public int getEnchantability() {
			return 10;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.fromTag(REPAIRS_CHARTIUM_ARMOR);
		}
	}


	public static final RegistryKey<PlacedFeature> ORE_SAPPHIRE_PLACED_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "ore_sapphire"));
	public static final RegistryKey<PlacedFeature> ORE_BLACKSTONE_RUTILE_PLACED_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "ore_blackstone_rutile"));
	public static final RegistryKey<PlacedFeature> ORE_BASALT_RUTILE_PLACED_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "ore_basalt_rutile"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
        AscentExperimentParticleTypes.init();
        AscentExperimentBlocks.init();
        AscentExperimentItems.init();
		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Feature.UNDERGROUND_ORES, ORE_SAPPHIRE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER), GenerationStep.Feature.UNDERGROUND_DECORATION, ORE_BLACKSTONE_RUTILE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_NETHER), GenerationStep.Feature.UNDERGROUND_DECORATION, ORE_BASALT_RUTILE_PLACED_FEATURE);
		Armor.initialize();
	}

	public static Identifier id(String path)
	{
		return Identifier.of(MOD_ID, path);
	}
}