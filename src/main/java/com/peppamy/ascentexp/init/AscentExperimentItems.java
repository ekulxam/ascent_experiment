package com.peppamy.ascentexp.init;

import com.peppamy.ascentexp.item.ArmorMaterials;
import com.peppamy.ascentexp.AscentExperiment;
import com.peppamy.ascentexp.item.ArmorSettingsWithAttribute;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
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
    public static final Item SAPPHIRE_HELMET = register("sapphire_helmet", new ArmorItem(ArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(297) ));
    public static final Item SAPPHIRE_CHESTPLATE = register("sapphire_chestplate", new ArmorItem(ArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(432) ));
    public static final Item SAPPHIRE_LEGGINGS = register("sapphire_leggings", new ArmorItem(ArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(405) ));
    public static final Item SAPPHIRE_BOOTS = register("sapphire_boots", new ArmorItem(ArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(351) ));

    public static final Item MYSTICK = register("mystick", new Item(new Item.Settings()));

    public static final Item BLOOD_RUTILE = register("blood_rutile", new Item(new Item.Settings()));
    public static final Item BLOOD_RUTILE_SWORD = register("blood_rutile_sword", new SwordItem(AscentExperiment.BloodRutileMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(AscentExperiment.BloodRutileMaterial.INSTANCE, 3, -2.4F))));
    public static final Item BLOOD_RUTILE_PICKAXE = register("blood_rutile_pickaxe", new PickaxeItem(AscentExperiment.BloodRutileMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(AscentExperiment.BloodRutileMaterial.INSTANCE, 1.0F, -2.8F))));
    public static final Item BLOOD_RUTILE_AXE = register("blood_rutile_axe", new AxeItem(AscentExperiment.BloodRutileMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(AscentExperiment.BloodRutileMaterial.INSTANCE, 5.0F, -3.0F))));
    public static final Item BLOOD_RUTILE_SHOVEL = register("blood_rutile_shovel", new ShovelItem(AscentExperiment.BloodRutileMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(AscentExperiment.BloodRutileMaterial.INSTANCE, 1.5F, -3.0F))));
    public static final Item BLOOD_RUTILE_HOE = register("blood_rutile_hoe", new HoeItem(AscentExperiment.BloodRutileMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(AscentExperiment.BloodRutileMaterial.INSTANCE, -3.0F, 0.0F))));
    public static final Item BLOOD_RUTILE_HELMET = register(
        "blood_rutile_helmet",
        new ArmorItem(
            ArmorMaterials.BLOOD_RUTILE,
            ArmorItem.Type.HELMET,
            new ArmorSettingsWithAttribute(addMaxHealthModifier(1, EquipmentSlot.HEAD))
                .maxDamage(198)
        ));
    public static final Item BLOOD_RUTILE_CHESTPLATE = register(
        "blood_rutile_chestplate",
        new ArmorItem(
            ArmorMaterials.BLOOD_RUTILE,
            ArmorItem.Type.CHESTPLATE,
            new ArmorSettingsWithAttribute(addMaxHealthModifier(2, EquipmentSlot.CHEST))
                .maxDamage(288)
        ));
    public static final Item BLOOD_RUTILE_LEGGINGS = register(
        "blood_rutile_leggings",
        new ArmorItem(
            ArmorMaterials.BLOOD_RUTILE,
            ArmorItem.Type.LEGGINGS,
            new ArmorSettingsWithAttribute(addMaxHealthModifier(2, EquipmentSlot.LEGS))
                .maxDamage(270)
        ));
    public static final Item BLOOD_RUTILE_BOOTS = register(
        "blood_rutile_boots",
        new ArmorItem(
            ArmorMaterials.BLOOD_RUTILE,
            ArmorItem.Type.BOOTS,
            new ArmorSettingsWithAttribute(addMaxHealthModifier(1, EquipmentSlot.FEET))
                .maxDamage(234)
        ));

    public static final Item RAW_CHARTIUM = register("raw_chartium", new Item(new Item.Settings()));
    public static final Item CHARTIUM_INGOT = register("chartium_ingot", new Item(new Item.Settings()));
    public static final Item CHARTIUM_NUGGET = register("chartium_nugget", new Item(new Item.Settings()));
    public static final Item CHARTIUM_SWORD = register("chartium_sword", new SwordItem(AscentExperiment.ChartiumMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(AscentExperiment.ChartiumMaterial.INSTANCE, 3, -2.4F))));
    public static final Item CHARTIUM_PICKAXE = register("chartium_pickaxe", new PickaxeItem(AscentExperiment.ChartiumMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(AscentExperiment.ChartiumMaterial.INSTANCE, 1.0F, -2.8F))));
    public static final Item CHARTIUM_AXE = register("chartium_axe", new AxeItem(AscentExperiment.ChartiumMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(AscentExperiment.ChartiumMaterial.INSTANCE, 5.0F, -3.0F))));
    public static final Item CHARTIUM_SHOVEL = register("chartium_shovel", new ShovelItem(AscentExperiment.ChartiumMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(AscentExperiment.ChartiumMaterial.INSTANCE, 1.5F, -3.0F))));
    public static final Item CHARTIUM_HOE = register("chartium_hoe", new HoeItem(AscentExperiment.ChartiumMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(AscentExperiment.ChartiumMaterial.INSTANCE, -3.0F, 0.0F))));
    public static final Item CHARTIUM_HELMET = register("chartium_helmet", new ArmorItem(ArmorMaterials.CHARTIUM, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(253)));
    public static final Item CHARTIUM_CHESTPLATE = register("chartium_chestplate", new ArmorItem(ArmorMaterials.CHARTIUM, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(368)));
    public static final Item CHARTIUM_LEGGINGS = register("chartium_leggings", new ArmorItem(ArmorMaterials.CHARTIUM, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(345)));
    public static final Item CHARTIUM_BOOTS = register("chartium_boots", new ArmorItem(ArmorMaterials.CHARTIUM, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(299)));

    public static final Item COMPASSION_FRUIT = register("compassion_fruit", COMPASSION_FOOD);

    public static final Item COMPASSION_BOTTLE = register("compassion_bottle", new Item(new Item.Settings()));

    @SuppressWarnings("unused")
    public static final Item AEREMONE_BULB = register("aeremone_bulb", new AliasedBlockItem(AscentExperimentBlocks.AEREMONE, new Item.Settings().food(AscentExperimentItems.AERO_FOOD)));

    public static final Item CHARTIUM_TORCH_ITEM = register("chartium_torch", new VerticallyAttachableBlockItem(AscentExperimentBlocks.CHARTIUM_TORCH, AscentExperimentBlocks.CHARTIUM_WALL_TORCH, new Item.Settings(), Direction.DOWN));

    public static final ItemGroup ASCENT_EXPERIMENT_GROUP = FabricItemGroup.builder()
            .icon(CHARTIUM_TORCH_ITEM::getDefaultStack)
            .displayName(Text.translatable("itemGroup.ascent-experiment"))
            .entries((displayContext, entries) -> {
                entries.addAll(
                        Registries.ITEM.streamEntries()
                                .filter(reference -> reference.registryKey().getValue().getNamespace().equals(AscentExperiment.MOD_ID))
                                .map(reference -> reference.value().getDefaultStack())
                                .toList()
                );
            })
            .build();

    public static <T extends Item> T register(String name, T item)
    {
        return Registry.register(Registries.ITEM, AscentExperiment.id(name), item);
    }

    public static Item register(String name, FoodComponent food){
        return register(name, new Item(new Item.Settings().food(food)));
    }

    private static AttributeModifiersComponent addMaxHealthModifier(double hpIncrease, EquipmentSlot slot) {
        return AttributeModifiersComponent.builder()
                                          .add(
                                               EntityAttributes.GENERIC_MAX_HEALTH,
                                               new EntityAttributeModifier(
                                                   AscentExperiment.id("armor.hpincrease." + slot.getName()),
                                                   hpIncrease, EntityAttributeModifier.Operation.ADD_VALUE),
                                               AttributeModifierSlot.forEquipmentSlot(slot)
                                          )
                                          .build();
    }

    public static void init()
    {
        Registry.register(Registries.ITEM_GROUP, AscentExperiment.id("ascent_experiment_group"), ASCENT_EXPERIMENT_GROUP);
    }
}
