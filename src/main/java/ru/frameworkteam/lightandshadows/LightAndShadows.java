package ru.frameworkteam.lightandshadows;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.frameworkteam.lightandshadows.item.ModItems;

public class LightAndShadows implements ModInitializer {
	public static final String MOD_ID = "lightandshadows";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModComponents.register();
		ModItems.register();
		ModEvents.AllowDeath();
//		ModMessages.registerC2SPackets();
//		ModEvents.ClientTickStart();
		LOGGER.info("Hello Fabric world!");
	}
}