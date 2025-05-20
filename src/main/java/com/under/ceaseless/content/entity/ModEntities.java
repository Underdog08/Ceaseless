package com.under.ceaseless.content.entity;

import com.under.ceaseless.Ceaseless;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class ModEntities {

    public static final Identifier SANDMITE_ID = Identifier.of(Ceaseless.MOD_ID, "sandmite");

    public static final RegistryKey<EntityType<?>> SANDMITE_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, SANDMITE_ID);

    @SuppressWarnings("unchecked")
    public static final EntityType<SandmiteEntity> SANDMITE =
            (EntityType<SandmiteEntity>) FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SandmiteEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.3f))
                    .trackRangeBlocks(8)
                    .trackedUpdateRate(2)
                    .build(SANDMITE_KEY);

    public static void register() {
        Registry.register(Registries.ENTITY_TYPE, SANDMITE_ID, SANDMITE);

        FabricDefaultAttributeRegistry.register(SANDMITE, SandmiteEntity.createSandmiteAttributes());

        SpawnRestriction.register(
                ModEntities.SANDMITE,
                SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                SandmiteEntity::canSandmiteSpawn
        );
    }
}