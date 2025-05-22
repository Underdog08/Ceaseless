package com.under.ceaseless.content.item;

import com.under.ceaseless.Ceaseless;
import com.under.ceaseless.content.effect.ModEffects;
import com.under.ceaseless.content.entity.ModEntities;
import com.under.ceaseless.content.item.custom.TunedChorusFruitItem;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final ConsumableComponent MITE_GEL_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance(ModEffects.PURPLEXED, 20 * 30), // 30 seconds
                    1.0f
            ))
            .build();

    public static final FoodComponent MITE_GEL_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .build();

    public static final Item SANDMITE_SPAWN_EGG = register(
            "sandmite_spawn_egg",
            settings -> new SpawnEggItem(
                    ModEntities.SANDMITE,
                    settings
            ),
            new Item.Settings()
    );

    public static final Item MITE_GEL = register(
            "mite_gel",
            Item::new,
            new Item.Settings().food(new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(0.2f)
                    .alwaysEdible()
                    .build(), ConsumableComponents.food()
                    .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.PURPLEXED, 10 * 20), 0.25f)).build()
            )
    );

    public static final Item BISMUTH = register(
            "bismuth",
            Item::new,
            new Item.Settings()
                    .fireproof()
    );

    public static final Item TUNED_CHORUS_FRUIT = register(
            "tuned_chorus_fruit",
            TunedChorusFruitItem::new,
            new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .nutrition(3)
                            .alwaysEdible()
                            .saturationModifier(2f)
                            .build()
                    )
    );

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Ceaseless.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
    }
}
