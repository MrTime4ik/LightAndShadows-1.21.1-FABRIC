package ru.frameworkteam.lightandshadows.components;

import com.mojang.datafixers.kinds.App;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public record PositionComponent(double getX, double getY, double getZ, String getDimension) {

    public static final Codec<PositionComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.DOUBLE.fieldOf("x").forGetter(PositionComponent::getX),
                Codec.DOUBLE.fieldOf("y").forGetter(PositionComponent::getY),
                Codec.DOUBLE.fieldOf("z").forGetter(PositionComponent::getZ),
                Codec.STRING.fieldOf("dimension").forGetter(PositionComponent::getDimension)
        ).apply(builder, PositionComponent::new);
    });

}
