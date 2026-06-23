package com.peppamy.ascentexp.init;

import com.peppamy.ascentexp.AscentExperiment;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * @author SkyNotTheLimit
 */
public class AscentExperimentParticleTypes {

    public static final SimpleParticleType CHARTIUM_FLAME = register("chartium_flame", FabricParticleTypes.simple(false));

    public static <T extends ParticleType<T> & ParticleEffect> T register(String name, T particleType)
    {
        return Registry.register(Registries.PARTICLE_TYPE, AscentExperiment.id(name), particleType);
    }

    public static void init()
    {
        // NO-OP
    }
}
