package ru.frameworkteam.lightandshadows.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record PositionComponent(double x, double y, double z, String dimension) {

    public static final Codec<PositionComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.DOUBLE.fieldOf("x").forGetter(PositionComponent::x),
                Codec.DOUBLE.fieldOf("y").forGetter(PositionComponent::y),
                Codec.DOUBLE.fieldOf("z").forGetter(PositionComponent::z),
                Codec.STRING.fieldOf("dimension").forGetter(PositionComponent::dimension)
        ).apply(builder, PositionComponent::new);
    });

}
