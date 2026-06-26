package com.peppamy.ascentexp.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class CompassionPlantBlock extends PlantBlock {
    public static final MapCodec<net.minecraft.block.DeadBushBlock> CODEC = createCodec(net.minecraft.block.DeadBushBlock::new);
    protected static final float field_31080 = 6.0F;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    @Override
    public MapCodec<net.minecraft.block.DeadBushBlock> getCodec() {
        return CODEC;
    }

    public CompassionPlantBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DEAD_BUSH_MAY_PLACE_ON);
    }
}
