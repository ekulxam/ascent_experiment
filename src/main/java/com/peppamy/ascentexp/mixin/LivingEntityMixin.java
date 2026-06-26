package com.peppamy.ascentexp.mixin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.peppamy.ascentexp.entity.ChartiumTorchSensor;
import com.peppamy.ascentexp.init.AscentExperimentOther;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.Activity;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.ai.brain.task.GoToRememberedPositionTask;
import net.minecraft.entity.ai.brain.task.PacifyTask;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Collection;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @ModifyArg(method = "createBrainProfile", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/brain/Brain;createProfile(Ljava/util/Collection;Ljava/util/Collection;)Lnet/minecraft/entity/ai/brain/Brain$Profile;"), index = 0)
    public Collection<? extends MemoryModuleType<?>> addBrainModuleTypes(Collection<? extends MemoryModuleType<?>> memoryModules) {
        if (!ChartiumTorchSensor.isScaredOfChartiumTorches(this) ||
            memoryModules.contains(MemoryModuleType.NEAREST_REPELLENT))
            return memoryModules; // do nothing if this mob is not scared or it is already scared
        else if (memoryModules.isEmpty())
            return ChartiumTorchSensor.MEMORY_MODULES;
        else
            return ImmutableList.<MemoryModuleType<?>>builderWithExpectedSize(memoryModules.size() + 1)
                                .add(MemoryModuleType.NEAREST_REPELLENT)
                                .build();
    }

    @ModifyArg(method = "createBrainProfile", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/brain/Brain;createProfile(Ljava/util/Collection;Ljava/util/Collection;)Lnet/minecraft/entity/ai/brain/Brain$Profile;"), index = 1)
    public Collection<? extends SensorType<?>> addBrainSensors(Collection<? extends SensorType<?>> sensorTypes) {
        if (!ChartiumTorchSensor.isScaredOfChartiumTorches(this) ||
            sensorTypes.contains(AscentExperimentOther.CHARTIUM_TORCH_SENSOR_TYPE))
            return sensorTypes; // do nothing if this mob is not scared or it is already scared
        else if (sensorTypes.isEmpty())
            return ChartiumTorchSensor.CHARTIUM_TORCH_SENSOR_TYPES;
        else
            return ImmutableList.<SensorType<?>>builderWithExpectedSize(sensorTypes.size() + 1)
                                .add(AscentExperimentOther.CHARTIUM_TORCH_SENSOR_TYPE)
                                .build();
    }

    @SuppressWarnings("unchecked")
    @ModifyReturnValue(method = "deserializeBrain", at = @At("RETURN"))
    public Brain<?> addBrainTasks(Brain<?> brain) {
        if (ChartiumTorchSensor.isScaredOfChartiumTorches(this)) {
            ((Brain<? extends PathAwareEntity>)brain).setTaskList(
                Activity.IDLE,
                10,
                ImmutableList.of(
                    PacifyTask.create(MemoryModuleType.NEAREST_REPELLENT, 200),
                    GoToRememberedPositionTask.createPosBased(MemoryModuleType.NEAREST_REPELLENT, 1F, 8, true)
                )
            );
            brain.setTaskList(
                Activity.FIGHT,
                10,
                ImmutableList.of(
                    PacifyTask.create(MemoryModuleType.NEAREST_REPELLENT, 200)
                ),
                MemoryModuleType.ATTACK_TARGET
            );
            brain.setCoreActivities(ImmutableSet.of(Activity.CORE));
            brain.setDefaultActivity(Activity.IDLE);
            brain.resetPossibleActivities();
        }
        return brain;
    }
}
