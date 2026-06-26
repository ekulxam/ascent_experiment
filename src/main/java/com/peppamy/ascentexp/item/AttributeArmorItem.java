package com.peppamy.ascentexp.item;

import com.google.common.base.Suppliers;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class AttributeArmorItem extends ArmorItem {
    protected final Supplier<AttributeModifiersComponent> ourAttributeModifiers;

    public AttributeArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
        this.ourAttributeModifiers = Suppliers.memoize(
            () -> {
                int protection = material.value().getProtection(type);
                float toughness = material.value().toughness();
                AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
                AttributeModifierSlot slot = AttributeModifierSlot.forEquipmentSlot(type.getEquipmentSlot());
                Identifier modifierId = Identifier.ofVanilla("armor." + type.getName());
                builder.add(
                    EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(modifierId, protection,
                                                EntityAttributeModifier.Operation.ADD_VALUE),
                    slot);
                builder.add(
                    EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                    new EntityAttributeModifier(modifierId, toughness,
                                                EntityAttributeModifier.Operation.ADD_VALUE),
                    slot);
                float knockbackResistance = material.value().knockbackResistance();
                if (knockbackResistance > 0F) {
                    builder.add(
                        EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                        new EntityAttributeModifier(modifierId, knockbackResistance,
                                                    EntityAttributeModifier.Operation.ADD_VALUE),
                        slot);
                }

                for (AttributeModifiersComponent.Entry modifier :
                    this.getComponents()
                        .getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT)
                        .modifiers()) {
                    builder.add(modifier.attribute(), modifier.modifier(), modifier.slot());
                }

                return builder.build();
            }
        );
    }
}
