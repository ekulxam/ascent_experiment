package com.peppamy.ascentexp;

import com.peppamy.ascentexp.init.AscentExperimentItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Armor {
    public static void initialize() {}
    public static final RegistryEntry<ArmorMaterial> SAPPHIRE = registerMaterial("sapphire",
        // Defense (protection) point values for each armor piece.
        Map.of(
            ArmorItem.Type.HELMET, 3,
            ArmorItem.Type.CHESTPLATE, 7,
            ArmorItem.Type.LEGGINGS, 5,
            ArmorItem.Type.BOOTS, 2
        ),
        // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
        13,
        // The sound played when the armor is equipped.
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        // The ingredient(s) used to repair the armor.
        () -> Ingredient.ofItems(AscentExperimentItems.SAPPHIRE),
        1.5F,
        0.0F,
        // Guidite is NOT dyeable, so we will pass false.
        false
    );
    public static final RegistryEntry<ArmorMaterial> BLOOD_RUTILE = registerMaterial("blood_rutile",
        // Defense (protection) point values for each armor piece.
        Map.of(
            ArmorItem.Type.HELMET, 3,
            ArmorItem.Type.CHESTPLATE, 6,
            ArmorItem.Type.LEGGINGS, 5,
            ArmorItem.Type.BOOTS, 2
        ),
        // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
        16,
        // The sound played when the armor is equipped.
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        // The ingredient(s) used to repair the armor.
        () -> Ingredient.ofItems(AscentExperimentItems.BLOOD_RUTILE),
        2.0F,
        0.05F,
        // Guidite is NOT dyeable, so we will pass false.
        false
    );
    public static final RegistryEntry<ArmorMaterial> CHARTIUM = registerMaterial("chartium",
        // Defense (protection) point values for each armor piece.
        Map.of(
            ArmorItem.Type.HELMET, 2,
            ArmorItem.Type.CHESTPLATE, 6,
            ArmorItem.Type.LEGGINGS, 5,
            ArmorItem.Type.BOOTS, 2
        ),
        // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
        5,
        // The sound played when the armor is equipped.
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        // The ingredient(s) used to repair the armor.
        () -> Ingredient.ofItems(AscentExperimentItems.CHARTIUM_INGOT),
        1.0F,
        0.15F,
        // Guidite is NOT dyeable, so we will pass false.
        false
    );


    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(
            // The ID of the texture layer, the suffix, and whether the layer is dyeable.
            // We can just pass the armor material ID as the texture layer ID.
            // We have no need for a suffix, so we'll pass an empty string.
            // We'll pass the dyeable boolean we received as the dyeable parameter.
            new ArmorMaterial.Layer(AscentExperiment.id(id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(Registries.ARMOR_MATERIAL, AscentExperiment.id(id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return RegistryEntry.of(material);
    }
}