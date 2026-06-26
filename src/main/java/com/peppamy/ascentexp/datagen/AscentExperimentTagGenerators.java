package com.peppamy.ascentexp.datagen;

import com.peppamy.ascentexp.AscentExperiment;
import com.peppamy.ascentexp.init.AscentExperimentBlocks;
import com.peppamy.ascentexp.init.AscentExperimentItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AscentExperimentTagGenerators {
    public static class AscentExperimentBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

        public AscentExperimentBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup lookup) {
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                    .add(AscentExperimentBlocks.SAPPHIRE_BLOCK)
                    .add(AscentExperimentBlocks.SAPPHIRE_ORE)
                    .add(AscentExperimentBlocks.DEEPSLATE_SAPPHIRE_ORE)
                    .add(AscentExperimentBlocks.BLACKSTONE_RUTILE_ORE)
                    .add(AscentExperimentBlocks.BASALT_RUTILE_ORE)
                    .add(AscentExperimentBlocks.BLOOD_RUTILE_BLOCK)
                    .add(AscentExperimentBlocks.ASTER_STONE)
                    .add(AscentExperimentBlocks.CHARTIUM_ORE)
                    .add(AscentExperimentBlocks.RAW_CHARTIUM_BLOCK)
                    .add(AscentExperimentBlocks.CHARTIUM_BLOCK)
                    .add(AscentExperimentBlocks.CHARTIUM_BRICKS);

            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(AscentExperimentBlocks.SAPPHIRE_BLOCK)
                    .add(AscentExperimentBlocks.SAPPHIRE_ORE)
                    .add(AscentExperimentBlocks.DEEPSLATE_SAPPHIRE_ORE)
                    .add(AscentExperimentBlocks.BLACKSTONE_RUTILE_ORE)
                    .add(AscentExperimentBlocks.BASALT_RUTILE_ORE)
                    .add(AscentExperimentBlocks.BLOOD_RUTILE_BLOCK)
                    .add(AscentExperimentBlocks.ASTER_STONE)
                    .add(AscentExperimentBlocks.CHARTIUM_ORE)
                    .add(AscentExperimentBlocks.RAW_CHARTIUM_BLOCK)
                    .add(AscentExperimentBlocks.CHARTIUM_BLOCK)
                    .add(AscentExperimentBlocks.CHARTIUM_BRICKS);

            getOrCreateTagBuilder(AscentExperiment.CHARTIUM_TORCHES)
                .add(AscentExperimentBlocks.CHARTIUM_TORCH, AscentExperimentBlocks.CHARTIUM_WALL_TORCH);
        }
    }

    public static class AscentExperimentItemTagGenerator extends FabricTagProvider.ItemTagProvider {

        public AscentExperimentItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
            super(output, completableFuture, blockTagProvider);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup lookup) {
            getOrCreateTagBuilder(AscentExperiment.REPAIRS_SAPPHIRE_ARMOR)
                .add(AscentExperimentItems.SAPPHIRE)
                .add(AscentExperimentItems.BLOOD_RUTILE)
                .add(AscentExperimentItems.CHARTIUM_INGOT);

            getOrCreateTagBuilder(ItemTags.AXES)
                .add(AscentExperimentItems.SAPPHIRE_AXE)
                .add(AscentExperimentItems.BLOOD_RUTILE_AXE)
                .add(AscentExperimentItems.CHARTIUM_AXE);
            getOrCreateTagBuilder(ItemTags.HOES)
                .add(AscentExperimentItems.SAPPHIRE_HOE)
                .add(AscentExperimentItems.BLOOD_RUTILE_HOE)
                .add(AscentExperimentItems.CHARTIUM_HOE);
            getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(AscentExperimentItems.SAPPHIRE_PICKAXE)
                .add(AscentExperimentItems.BLOOD_RUTILE_PICKAXE)
                .add(AscentExperimentItems.CHARTIUM_PICKAXE);
            getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(AscentExperimentItems.SAPPHIRE_SHOVEL)
                .add(AscentExperimentItems.BLOOD_RUTILE_SHOVEL)
                .add(AscentExperimentItems.CHARTIUM_SHOVEL);
            getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(AscentExperimentItems.SAPPHIRE_SWORD)
                .add(AscentExperimentItems.BLOOD_RUTILE_SWORD)
                .add(AscentExperimentItems.CHARTIUM_SWORD);

            getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(AscentExperimentItems.SAPPHIRE_HELMET)
                .add(AscentExperimentItems.BLOOD_RUTILE_HELMET)
                .add(AscentExperimentItems.CHARTIUM_HELMET);
            getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(AscentExperimentItems.SAPPHIRE_CHESTPLATE)
                .add(AscentExperimentItems.BLOOD_RUTILE_CHESTPLATE)
                .add(AscentExperimentItems.CHARTIUM_CHESTPLATE);
            getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(AscentExperimentItems.SAPPHIRE_LEGGINGS)
                .add(AscentExperimentItems.BLOOD_RUTILE_LEGGINGS)
                .add(AscentExperimentItems.CHARTIUM_LEGGINGS);
            getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(AscentExperimentItems.SAPPHIRE_BOOTS)
                .add(AscentExperimentItems.BLOOD_RUTILE_BOOTS)
                .add(AscentExperimentItems.CHARTIUM_BOOTS);
        }
    }
}
