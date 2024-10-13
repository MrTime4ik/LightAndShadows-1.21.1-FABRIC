package ru.frameworkteam.lightandshadows.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.intellij.lang.annotations.Identifier;
import ru.frameworkteam.lightandshadows.LightAndShadows;
import ru.frameworkteam.lightandshadows.ModComponents;
import ru.frameworkteam.lightandshadows.components.PositionComponent;

import java.text.DecimalFormat;
import java.util.List;

public class MinoanSphere extends Item {
    public MinoanSphere(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack stack = player.getStackInHand(hand);
        boolean charge = stack.getOrDefault(ModComponents.CHARGE_COMPONENT, false);

        if (charge) {

            //Shift + RMB to save player position
            if (player.isSneaking() && !stack.contains(ModComponents.POSITION_COMPONENT)) {

                PositionComponent position = new PositionComponent(
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        world.getRegistryKey().getValue().toString()
                );
                stack.set(ModComponents.POSITION_COMPONENT, position);
            }
        }
        return super.use(world, player, hand);
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        boolean charge = stack.getOrDefault(ModComponents.CHARGE_COMPONENT, false);

        //Standard sphere tooltip
        tooltip.add(Text.translatable("tooltip.lightandshadows.minoan_sphere").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("tooltip.lightandshadows.void"));

        //Charge Status
        if (charge) {
            tooltip.add(Text.translatable("tooltip.lightandshadows.status.charged").formatted(Formatting.GOLD));
        } else {
            tooltip.add(Text.translatable("tooltip.lightandshadows.status.uncharged").formatted(Formatting.GOLD));
        }

        if (stack.contains(ModComponents.POSITION_COMPONENT)) {

            tooltip.add(Text.translatable("tooltip.lightandshadows.void"));

            if (Screen.hasShiftDown()) {

                tooltip.add(Text.translatable("tooltip.lightandshadows.minoan_sphere_with_coordinates").formatted(Formatting.GRAY));

                DecimalFormat decimalFormat = new DecimalFormat("#");
                PositionComponent position = stack.get(ModComponents.POSITION_COMPONENT);

                String positionX = decimalFormat.format(position.getX());
                tooltip.add(Text.of("§7X: §6" + positionX));
                String positionY = decimalFormat.format(position.getY());
                tooltip.add(Text.of("§7Y: §6" + positionY));
                String positionZ = decimalFormat.format(position.getZ());
                tooltip.add(Text.of("§7Z: §6" + positionZ));

                String dimensionID = position.getDimension();


                if (dimensionID.equals("minecraft:overworld")) {
                    tooltip.add(Text.translatable("tooltip.lightandshadows.dimension.overworld"));
                } else if (dimensionID.equals("minecraft:the_nether")) {
                    tooltip.add(Text.translatable("tooltip.lightandshadows.dimension.nether"));
                } else if (dimensionID.equals("minecraft:the_end")) {
                    tooltip.add(Text.translatable("tooltip.lightandshadows.dimension.end"));
                } else {
                    tooltip.add(Text.translatable("tooltip.lightandshadows.dimension", dimensionID));
                }
            } else {
                tooltip.add(Text.translatable("tooltip.lightandshadows.hold_shift").formatted(Formatting.GRAY));
            }
        }
    }
}
