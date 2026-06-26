package com.peppamy.ascentexp.init;

import com.peppamy.ascentexp.AscentExperiment;
import com.peppamy.ascentexp.entity.ChartiumTorchSensor;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

/**
 * @author SkyNotTheLimit
 */
public interface AscentExperimentOther {
    SimpleParticleType CHARTIUM_FLAME = registerParticle("chartium_flame", FabricParticleTypes.simple(false));

    SensorType<ChartiumTorchSensor<? extends LivingEntity>> CHARTIUM_TORCH_SENSOR_TYPE =
        Registry.register(Registries.SENSOR_TYPE,
                          AscentExperiment.id("chartium_torch_sensor"),
                          new SensorType<>(ChartiumTorchSensor::new));

    static <T extends ParticleType<T> & ParticleEffect> T registerParticle(String name, T particleType)
    {
        return Registry.register(Registries.PARTICLE_TYPE, AscentExperiment.id(name), particleType);
    }

    static void init()
    {
        // NO-OP
    }
}
