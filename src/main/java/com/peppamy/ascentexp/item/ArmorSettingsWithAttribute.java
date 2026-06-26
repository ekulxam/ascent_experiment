package com.peppamy.ascentexp.item;

import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.Item;

public class ArmorSettingsWithAttribute extends Item.Settings {
    private final AttributeModifiersComponent customComponents;

    public ArmorSettingsWithAttribute(AttributeModifiersComponent customComponents) {
        this.customComponents = customComponents;
    }

    public AttributeModifiersComponent getCustomComponents() {
        return customComponents;
    }
}