package com.peppamy.ascentexp;

import com.peppamy.ascentexp.init.AscentExperimentBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class AscentExperimentClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        BlockRenderLayerMap.INSTANCE.putBlock(AscentExperimentBlocks.COMPASSION_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), AscentExperimentBlocks.CHARTIUM_TORCH, AscentExperimentBlocks.CHARTIUM_WALL_TORCH);
    }
}