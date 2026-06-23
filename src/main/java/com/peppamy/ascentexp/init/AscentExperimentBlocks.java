package com.peppamy.ascentexp.init;

import com.peppamy.ascentexp.AscentExperiment;
import com.peppamy.ascentexp.block.AeremoneBlock;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class AscentExperimentBlocks {
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

    public static final Block CHARTIUM_TORCH = register("chartium_torch", new TorchBlock(AscentExperimentParticleTypes.CHARTIUM_FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)), false);

    public static final Block CHARTIUM_WALL_TORCH = register("chartium_wall_torch", new WallTorchBlock(AscentExperimentParticleTypes.CHARTIUM_FLAME, AbstractBlock.Settings.create().noCollision().breakInstantly().luminance((state) -> 14).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)), false);

    public static <T extends Block> T register(String name, T block, boolean hasDefaultItem) {
        Identifier id = AscentExperiment.id(name);
        Registry.register(Registries.BLOCK, id, block);
        if (hasDefaultItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return block;
    }

    public static void init()
    {
        // NO-OP
    }
}
