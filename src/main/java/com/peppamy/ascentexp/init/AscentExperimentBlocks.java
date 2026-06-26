package com.peppamy.ascentexp.init;

import com.peppamy.ascentexp.AscentExperiment;
import com.peppamy.ascentexp.block.AeremoneBlock;
import com.peppamy.ascentexp.block.CompassionPlantBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import static net.minecraft.block.Blocks.createLeavesBlock;



public class AscentExperimentBlocks {
    public static final Block COMPASSION_PLANT = register("compassion_plant", new CompassionPlantBlock(
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
    ), false);

        public static final Block COMPASSION_SPROUT = register("compassion_sprout", new SaplingBlock(SaplingGenerator.AZALEA,
            AbstractBlock.Settings.create()
                .mapColor(MapColor.DARK_GREEN)
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
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
    public static final Block DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(5, 10), AbstractBlock.Settings.create()
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

    public static final Block BLACKSTONE_RUTILE_ORE = register("blackstone_rutile_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 8), AbstractBlock.Settings.create()
        .mapColor(MapColor.BLACK)
        .sounds(BlockSoundGroup.STONE)
        .requiresTool()
        .strength(3.5F, 6.5F)
        .instrument(NoteBlockInstrument.BASEDRUM)
    ), true);
    public static final Block BASALT_RUTILE_ORE = register("basalt_rutile_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 8), AbstractBlock.Settings.create()
        .mapColor(MapColor.BLACK)
        .instrument(NoteBlockInstrument.BASEDRUM)
        .requiresTool()
        .strength(3.5F, 4.5F)
        .sounds(BlockSoundGroup.BASALT)
    ), true);
    public static final Block BLOOD_RUTILE_BLOCK = register("blood_rutile_block", new Block(AbstractBlock.Settings.create()
        .mapColor(MapColor.DARK_RED)
        .requiresTool()
        .strength(5.0F, 6.0F)
        .sounds(BlockSoundGroup.METAL)
    ), true);
    public static final Block ASTER_STONE = register("aster_stone", new Block(AbstractBlock.Settings.create()
        .mapColor(MapColor.TERRACOTTA_BLACK)
        .sounds(BlockSoundGroup.STONE)
        .requiresTool()
        .strength(5.0F, 5.0F)
    ), true);
    public static final Block CHARTIUM_ORE = register("chartium_ore", new ExperienceDroppingBlock(UniformIntProvider.create(4, 8), AbstractBlock.Settings.create()
        .mapColor(MapColor.TERRACOTTA_BLACK)
        .sounds(BlockSoundGroup.STONE)
        .requiresTool()
        .strength(6.0F, 5.0F)
    ), true);
    public static final Block CHARTIUM_BLOCK = register("chartium_block", new Block(AbstractBlock.Settings.create()
        .mapColor(MapColor.LIME)
        .requiresTool()
        .strength(5.0F, 6.0F)
        .sounds(BlockSoundGroup.METAL)
    ), true);
    public static final Block CHARTIUM_BRICKS = register("chartium_bricks", new Block(AbstractBlock.Settings.create()
        .mapColor(MapColor.LIME)
        .requiresTool()
        .strength(5.0F, 6.0F)
        .sounds(BlockSoundGroup.METAL)
    ), true);
    public static final Block RAW_CHARTIUM_BLOCK = register("raw_chartium_block", new Block(AbstractBlock.Settings.create()
        .mapColor(MapColor.LIME)
        .requiresTool()
        .strength(5.0F, 6.0F)
        .instrument(NoteBlockInstrument.BASEDRUM)
    ), true);

    public static final Block COMPASSION_LEAVES = register("compassion_leaves", createLeavesBlock(BlockSoundGroup.AZALEA_LEAVES), true);
    public static final Block FRUITING_COMPASSION_LEAVES = register("fruiting_compassion_leaves", createLeavesBlock(BlockSoundGroup.AZALEA_LEAVES), true);

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
