package com.peppamy.ascentexp.entity;

import com.peppamy.ascentexp.AscentExperiment;
import com.peppamy.ascentexp.init.AscentExperimentOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Set;

public class ChartiumTorchSensor<E extends LivingEntity> extends Sensor<E> {
    public static final List<? extends SensorType<?>> CHARTIUM_TORCH_SENSOR_TYPES = List.of(
        AscentExperimentOther.CHARTIUM_TORCH_SENSOR_TYPE);
    public static final Set<MemoryModuleType<?>> MEMORY_MODULES = Set.of(MemoryModuleType.NEAREST_REPELLENT);

    @Override
    protected void sense(ServerWorld world, E entity) {
        entity.getBrain().remember(
            MemoryModuleType.NEAREST_REPELLENT,
            BlockPos.findClosest(entity.getBlockPos(), 8, 4,
                                 pos -> world.getBlockState(pos).isIn(AscentExperiment.CHARTIUM_TORCHES)));
    }

    @Override
    public Set<MemoryModuleType<?>> getOutputMemoryModules() {
        return MEMORY_MODULES;
    }

    public static boolean isScaredOfChartiumTorches(Entity entity) {
        return entity instanceof ZombieEntity || entity instanceof AbstractSkeletonEntity || entity instanceof SpiderEntity || entity instanceof CreeperEntity;
    }
}
