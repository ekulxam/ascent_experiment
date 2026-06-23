package com.peppamy.ascentexp.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class AscentExperimentDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(AscentExperimentModelGenerator::new);
        pack.addProvider(AscentExperimentBlockLootTableGenerator::new);
        FabricTagProvider.BlockTagProvider blockTagProvider = pack.addProvider(AscentExperimentTagGenerators.AscentExperimentBlockTagGenerator::new);
        pack.addProvider((fabricDataOutput, completableFuture) -> new AscentExperimentTagGenerators.AscentExperimentItemTagGenerator(fabricDataOutput, completableFuture, blockTagProvider));
    }
}
