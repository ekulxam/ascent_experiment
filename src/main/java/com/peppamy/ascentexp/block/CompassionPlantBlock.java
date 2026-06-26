package com.peppamy.ascentexp.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CompassionPlantBlock extends PlantBlock {
    public static final MapCodec<CompassionPlantBlock> CODEC = createCodec(CompassionPlantBlock::new);
    protected static final float field_31080 = 6.0F;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 12.0, 13.0);

    @Override
    public MapCodec<CompassionPlantBlock> getCodec() {
        return CODEC;
    }

    public CompassionPlantBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
