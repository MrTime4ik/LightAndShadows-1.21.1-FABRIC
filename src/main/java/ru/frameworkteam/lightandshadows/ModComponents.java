package ru.frameworkteam.lightandshadows;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ru.frameworkteam.lightandshadows.components.PositionComponent;

public class ModComponents {

    public static final ComponentType<Boolean> CHARGE_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(LightAndShadows.MOD_ID, "charge"),
            ComponentType.<Boolean>builder().codec(Codec.BOOL).build()
    );
    public static final ComponentType<PositionComponent> POSITION_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(LightAndShadows.MOD_ID, "position"),
            ComponentType.<PositionComponent>builder().codec(PositionComponent.CODEC).build()
    );



    protected static void register() {
        LightAndShadows.LOGGER.info("Registering {} components", LightAndShadows.MOD_ID);
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized



    }
}