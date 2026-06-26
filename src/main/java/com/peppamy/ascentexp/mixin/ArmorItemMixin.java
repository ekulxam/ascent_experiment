package com.peppamy.ascentexp.mixin;

import com.google.common.base.Suppliers;
import com.peppamy.ascentexp.item.ArmorSettingsWithAttribute;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(ArmorItem.class)
public class ArmorItemMixin {
    @Mutable
    @Shadow
    @Final
    private Supplier<AttributeModifiersComponent> attributeModifiers;

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void addCustomModifiers(RegistryEntry<ArmorMaterial> material, ArmorItem.Type type, Item.Settings s, CallbackInfo ci) {
        if (s instanceof ArmorSettingsWithAttribute settings) {
            AttributeModifiersComponent component = this.attributeModifiers.get();
            for (AttributeModifiersComponent.Entry modifier : settings.getCustomComponents().modifiers()) {
                component = component.with(modifier.attribute(), modifier.modifier(), modifier.slot());
            }
            final AttributeModifiersComponent realComponent = component;
            this.attributeModifiers = Suppliers.memoize(() -> realComponent);
        }
    }
}
