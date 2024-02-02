package com.slide_am;

import com.slide_am.event.PorkConsumeEvent;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HaramCraft implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("haramcraft");

	@Override
	public void onInitialize() {

		PorkConsumeEvent.init();

		LOGGER.info("Hello Fabric world!");
	}
}