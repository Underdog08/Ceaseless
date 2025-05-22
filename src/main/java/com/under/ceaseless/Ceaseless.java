package com.under.ceaseless;

import com.under.ceaseless.content.block.ModBlocks;
import com.under.ceaseless.content.component.ModComponentTypes;
import com.under.ceaseless.content.effect.ModEffects;
import com.under.ceaseless.content.entity.ModEntities;
import com.under.ceaseless.content.item.ModItemGroups;
import com.under.ceaseless.content.item.ModItems;
import com.under.ceaseless.world.feature.ModFeatures;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ceaseless implements ModInitializer {
	public static final String MOD_ID = "ceaseless";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModFeatures.register();
		ModEntities.register();
		ModItemGroups.initialize();
		ModItems.initialize();
		ModEffects.initialize();
		ModComponentTypes.initialize();
	}
}