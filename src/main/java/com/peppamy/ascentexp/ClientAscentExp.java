package com.peppamy.ascentexp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class ClientAscentExp implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        BlockRenderLayerMap.INSTANCE.putBlock(AscentExperiment.COMPASSION_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AscentExperiment.CHARTIUM_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AscentExperiment.CHARTIUM_WALL_TORCH, RenderLayer.getCutout());
    }
}