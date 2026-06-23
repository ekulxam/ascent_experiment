package com.peppamy.ascentexp.datagen;

import com.peppamy.ascentexp.AscentExperiment;
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
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperiment.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperiment.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(AscentExperiment.SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerTorch(AscentExperiment.CHARTIUM_TORCH, AscentExperiment.CHARTIUM_WALL_TORCH);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(AscentExperiment.COMPASSION_FRUIT, Models.GENERATED);
        itemModelGenerator.register(AscentExperiment.HEART_BADGE, Models.GENERATED);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_HELMET, Models.GENERATED);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_AXE, Models.HANDHELD);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(AscentExperiment.SAPPHIRE_HOE, Models.HANDHELD);
    }
}
