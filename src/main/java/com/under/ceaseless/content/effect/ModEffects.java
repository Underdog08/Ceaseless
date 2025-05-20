package com.under.ceaseless.content.effect;

import com.under.ceaseless.Ceaseless;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> PURPLEXED =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Ceaseless.MOD_ID, "purplexed"), new PurplexedEffect());

    public static void initialize() {
    }
}
