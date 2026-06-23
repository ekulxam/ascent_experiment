package com.peppamy.ascentexp;

import com.peppamy.ascentexp.block.AeremoneBlock;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.minecraft.registry.tag.BlockTags.INCORRECT_FOR_DIAMOND_TOOL;

public class AscentExperiment implements ModInitializer {
	public static final String MOD_ID = "ascent-experiment";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Item register(String name, FoodComponent food){
		return register(name, new Item(new Item.Settings().food(food)));
	}

	public static final FoodComponent COMPASSION_FOOD = (new FoodComponent.Builder()).nutrition(3).saturationModifier(1.2F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F).build();

	public static final FoodComponent AERO_FOOD = (new FoodComponent.Builder()).nutrition(3).saturationModifier(1.2F).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 100, 0), 1.0F).build();

	public static final Item HEART_BADGE = register("heart_badge", new Item(new Item.Settings().maxCount(5)));
	public static final Item SAPPHIRE = register("sapphire", new Item(new Item.Settings()));
	public static final Item SAPPHIRE_SWORD = register("sapphire_sword", new SwordItem(SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(SapphireMaterial.INSTANCE, 3, -2.4F))));
	public static final Item SAPPHIRE_PICKAXE = register("sapphire_pickaxe", new PickaxeItem(SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(SapphireMaterial.INSTANCE, 1.0F, -2.8F))));
	public static final Item SAPPHIRE_AXE = register("sapphire_axe", new AxeItem(SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(SapphireMaterial.INSTANCE, 5.0F, -3.0F))));
	public static final Item SAPPHIRE_SHOVEL = register("sapphire_shovel", new ShovelItem(SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(SapphireMaterial.INSTANCE, 1.5F, -3.0F))));
	public static final Item SAPPHIRE_HOE = register("sapphire_hoe", new HoeItem(SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(SapphireMaterial.INSTANCE, -3.0F, 0.0F))));
	public static final Item SAPPHIRE_HELMET = register("sapphire_helmet", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(297) ));
	public static final Item SAPPHIRE_CHESTPLATE = register("sapphire_chestplate", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(432) ));
	public static final Item SAPPHIRE_LEGGINGS = register("sapphire_leggings", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(405) ));
	public static final Item SAPPHIRE_BOOTS = register("sapphire_boots", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(351) ));

	public static final Block COMPASSION_PLANT = register("compassion_plant", new AeremoneBlock(
		AbstractBlock.Settings.create()
			.mapColor(MapColor.DARK_GREEN)
			.noCollision()
			.ticksRandomly()
			.breakInstantly()
			.sounds(BlockSoundGroup.CROP)
			.pistonBehavior(PistonBehavior.DESTROY)
	), false);

	public static final Block AEREMONE = register("aeremone", new AeremoneBlock(
		AbstractBlock.Settings.create()
			.mapColor(MapColor.WATER_BLUE)
			.noCollision()
			.ticksRandomly()
			.breakInstantly()
			.sounds(BlockSoundGroup.WET_GRASS)
			.pistonBehavior(PistonBehavior.DESTROY)
	), false);

	public static final Item COMPASSION_FRUIT=register("compassion_fruit", COMPASSION_FOOD);

	public static final Item AEREMONE_BULB = register("aeremone_bulb", new AliasedBlockItem(AEREMONE, new Item.Settings()));

	public static final Block SAPPHIRE_ORE = register("sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(5, 10), AbstractBlock.Settings.create()
		.mapColor(MapColor.LAPIS_BLUE)
		.sounds(BlockSoundGroup.STONE)
		.requiresTool()
		.strength(3.0F, 3.0F)
	), true);
	public static final Block DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(5, 13), AbstractBlock.Settings.create()
		.mapColor(MapColor.LAPIS_BLUE)
		.sounds(BlockSoundGroup.DEEPSLATE)
		.requiresTool()
		.strength(4.5F, 3.0F)
	), true);
	public static final Block SAPPHIRE_BLOCK = register("sapphire_block", new Block(AbstractBlock.Settings.create()
		.mapColor(MapColor.LAPIS_BLUE)
		.requiresTool()
		.strength(5.0F, 6.0F)
		.sounds(BlockSoundGroup.METAL)
	), true);

	public static final Block CHARTIUM_TORCH = register("chartium_torch", new TorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)), false);

	public static final Block CHARTIUM_WALL_TORCH = register("chartium_wall_torch", new WallTorchBlock(ParticleTypes.FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)), false);

	public static final Item CHARTIUM_TORCH_ITEM = register("chartium_torch", new VerticallyAttachableBlockItem(AscentExperiment.CHARTIUM_TORCH, AscentExperiment.CHARTIUM_WALL_TORCH, new Item.Settings(), Direction.DOWN));

	public static final TagKey<Item> REPAIRS_SAPPHIRE_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(MOD_ID, "repairs_sapphire_armor"));

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

	public static final RegistryKey<PlacedFeature> ORE_SAPPHIRE_PLACED_FEATURE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, "ore_sapphire"));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Feature.UNDERGROUND_ORES, ORE_SAPPHIRE_PLACED_FEATURE);
		Armor.initialize();
	}

	public static Identifier id(String path)
	{
		return Identifier.of(MOD_ID, path);
	}

	public static <T extends Item> T register(String name, T item)
	{
		return Registry.register(Registries.ITEM, id(name), item);
	}

	public static <T extends Block> T register(String name, T block, boolean hasDefaultItem) {
		Registry.register(Registries.BLOCK, id(name), block);
		if (hasDefaultItem) {
			register(name, new BlockItem(block, new Item.Settings()));
		}
		return block;
	}
}