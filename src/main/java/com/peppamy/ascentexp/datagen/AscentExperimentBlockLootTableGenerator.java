package com.peppamy.ascentexp.datagen;

import com.peppamy.ascentexp.init.AscentExperimentBlocks;
import com.peppamy.ascentexp.init.AscentExperimentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class AscentExperimentBlockLootTableGenerator extends FabricBlockLootTableProvider {

    protected AscentExperimentBlockLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(AscentExperimentBlocks.SAPPHIRE_BLOCK);
        this.addDrop(AscentExperimentBlocks.SAPPHIRE_ORE, block -> this.oreDrops(block, AscentExperimentItems.SAPPHIRE));
        this.addDrop(AscentExperimentBlocks.DEEPSLATE_SAPPHIRE_ORE, block -> this.oreDrops(block, AscentExperimentItems.SAPPHIRE));
    }
}
