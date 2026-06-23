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
                    .add(AscentExperimentBlocks.DEEPSLATE_SAPPHIRE_ORE);

            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(AscentExperimentBlocks.SAPPHIRE_BLOCK)
                    .add(AscentExperimentBlocks.SAPPHIRE_ORE)
                    .add(AscentExperimentBlocks.DEEPSLATE_SAPPHIRE_ORE);
        }
    }

    public static class AscentExperimentItemTagGenerator extends FabricTagProvider.ItemTagProvider {

        public AscentExperimentItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
            super(output, completableFuture, blockTagProvider);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup lookup) {
            getOrCreateTagBuilder(AscentExperiment.REPAIRS_SAPPHIRE_ARMOR).add(AscentExperimentItems.SAPPHIRE);

            getOrCreateTagBuilder(ItemTags.AXES).add(AscentExperimentItems.SAPPHIRE_AXE);
            getOrCreateTagBuilder(ItemTags.HOES).add(AscentExperimentItems.SAPPHIRE_HOE);
            getOrCreateTagBuilder(ItemTags.PICKAXES).add(AscentExperimentItems.SAPPHIRE_PICKAXE);
            getOrCreateTagBuilder(ItemTags.SHOVELS).add(AscentExperimentItems.SAPPHIRE_SHOVEL);
            getOrCreateTagBuilder(ItemTags.SWORDS).add(AscentExperimentItems.SAPPHIRE_SWORD);

            getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(AscentExperimentItems.SAPPHIRE_HELMET);
            getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(AscentExperimentItems.SAPPHIRE_CHESTPLATE);
            getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(AscentExperimentItems.SAPPHIRE_LEGGINGS);
            getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(AscentExperimentItems.SAPPHIRE_BOOTS);
        }
    }
}
