package com.peppamy.ascentexp.datagen;

import com.peppamy.ascentexp.AscentExperiment;
import com.peppamy.ascentexp.init.AscentExperimentBlocks;
import com.peppamy.ascentexp.init.AscentExperimentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

import net.minecraft.data.client.Models;

public class AscentExperimentModelGenerator extends FabricModelProvider {

    public AscentExperimentModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.BLACKSTONE_RUTILE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.BASALT_RUTILE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.BLOOD_RUTILE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.ASTER_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.CHARTIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.RAW_CHARTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.CHARTIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.CHARTIUM_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.COMPASSION_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperimentBlocks.FRUITING_COMPASSION_LEAVES);

        blockStateModelGenerator.registerTorch(AscentExperimentBlocks.CHARTIUM_TORCH, AscentExperimentBlocks.CHARTIUM_WALL_TORCH);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(AscentExperimentItems.COMPASSION_FRUIT, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.HEART_BADGE, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.MYSTICK, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_HELMET, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.SAPPHIRE_HOE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_HELMET, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_AXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.BLOOD_RUTILE_HOE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.RAW_CHARTIUM, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_HELMET, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_BOOTS, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(AscentExperimentItems.CHARTIUM_HOE, Models.HANDHELD);
    }
}
