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
        blockStateModelGenerator.registerTorch(AscentExperimentBlocks.CHARTIUM_TORCH, AscentExperimentBlocks.CHARTIUM_WALL_TORCH);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(AscentExperimentItems.COMPASSION_FRUIT, Models.GENERATED);
        itemModelGenerator.register(AscentExperimentItems.HEART_BADGE, Models.GENERATED);
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
    }
}
