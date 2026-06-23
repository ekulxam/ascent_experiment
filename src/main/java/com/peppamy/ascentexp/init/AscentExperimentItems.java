package com.peppamy.ascentexp.init;

import com.peppamy.ascentexp.Armor;
import com.peppamy.ascentexp.AscentExperiment;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.Direction;

public class AscentExperimentItems {

    public static final FoodComponent COMPASSION_FOOD = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F)
            .build();

    public static final FoodComponent AERO_FOOD = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(1.2F)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 100, 0), 1.0F)
            .build();

    public static final Item HEART_BADGE = register("heart_badge", new Item(new Item.Settings().maxCount(5)));
    public static final Item SAPPHIRE = register("sapphire", new Item(new Item.Settings()));
    public static final Item SAPPHIRE_SWORD = register("sapphire_sword", new SwordItem(AscentExperiment.SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(AscentExperiment.SapphireMaterial.INSTANCE, 3, -2.4F))));
    public static final Item SAPPHIRE_PICKAXE = register("sapphire_pickaxe", new PickaxeItem(AscentExperiment.SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(AscentExperiment.SapphireMaterial.INSTANCE, 1.0F, -2.8F))));
    public static final Item SAPPHIRE_AXE = register("sapphire_axe", new AxeItem(AscentExperiment.SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(AscentExperiment.SapphireMaterial.INSTANCE, 5.0F, -3.0F))));
    public static final Item SAPPHIRE_SHOVEL = register("sapphire_shovel", new ShovelItem(AscentExperiment.SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(AscentExperiment.SapphireMaterial.INSTANCE, 1.5F, -3.0F))));
    public static final Item SAPPHIRE_HOE = register("sapphire_hoe", new HoeItem(AscentExperiment.SapphireMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(AscentExperiment.SapphireMaterial.INSTANCE, -3.0F, 0.0F))));
    public static final Item SAPPHIRE_HELMET = register("sapphire_helmet", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(297) ));
    public static final Item SAPPHIRE_CHESTPLATE = register("sapphire_chestplate", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(432) ));
    public static final Item SAPPHIRE_LEGGINGS = register("sapphire_leggings", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(405) ));
    public static final Item SAPPHIRE_BOOTS = register("sapphire_boots", new ArmorItem(Armor.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(351) ));

    public static final Item COMPASSION_FRUIT = register("compassion_fruit", COMPASSION_FOOD);

    public static final Item AEREMONE_BULB = register("aeremone_bulb", new AliasedBlockItem(AscentExperimentBlocks.AEREMONE, new Item.Settings()));

    public static final Item CHARTIUM_TORCH_ITEM = register("chartium_torch", new VerticallyAttachableBlockItem(AscentExperimentBlocks.CHARTIUM_TORCH, AscentExperimentBlocks.CHARTIUM_WALL_TORCH, new Item.Settings(), Direction.DOWN));


    public static <T extends Item> T register(String name, T item)
    {
        return Registry.register(Registries.ITEM, AscentExperiment.id(name), item);
    }

    public static Item register(String name, FoodComponent food){
        return register(name, new Item(new Item.Settings().food(food)));
    }

    public static void init()
    {
        // NO-OP
    }
}
