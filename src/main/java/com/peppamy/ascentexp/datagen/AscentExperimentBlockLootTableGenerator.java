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
        addDrop(AscentExperimentBlocks.BLOOD_RUTILE_BLOCK);
        addDrop(AscentExperimentBlocks.CHARTIUM_BLOCK);
        addDrop(AscentExperimentBlocks.ASTER_STONE);
        addDrop(AscentExperimentBlocks.CHARTIUM_BRICKS);
        addDrop(AscentExperimentBlocks.RAW_CHARTIUM_BLOCK);
        this.addDrop(AscentExperimentBlocks.SAPPHIRE_ORE, block -> this.oreDrops(block, AscentExperimentItems.SAPPHIRE));
        this.addDrop(AscentExperimentBlocks.DEEPSLATE_SAPPHIRE_ORE, block -> this.oreDrops(block, AscentExperimentItems.SAPPHIRE));
        this.addDrop(AscentExperimentBlocks.BLACKSTONE_RUTILE_ORE, block -> this.oreDrops(block, AscentExperimentItems.BLOOD_RUTILE));
        this.addDrop(AscentExperimentBlocks.BASALT_RUTILE_ORE, block -> this.oreDrops(block, AscentExperimentItems.BLOOD_RUTILE));
        this.addDrop(AscentExperimentBlocks.CHARTIUM_ORE, block -> this.oreDrops(block, AscentExperimentItems.RAW_CHARTIUM));
    }
}
