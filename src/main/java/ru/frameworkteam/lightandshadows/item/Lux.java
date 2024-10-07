package ru.frameworkteam.lightandshadows.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Lux extends Item {
    public Lux(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(
            ItemStack itemStack,
            TooltipContext context,
            List<Text> tooltip,
            TooltipType type) {
        tooltip.add(Text.translatable("item.lightandshadows.lux.tooltip")
                .formatted(Formatting.GOLD)
                .formatted(Formatting.ITALIC));
    }
}
