//package ru.frameworkteam.lightandshadows.item;
//
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NbtCompound;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.text.Text;
//import net.minecraft.util.Formatting;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.world.World;
//import org.jetbrains.annotations.Nullable;
//import ru.frameworkteam.lightandshadows.LightAndShadows;
//import ru.frameworkteam.lightandshadows.network.MinoanSphereHandler;
//import ru.frameworkteam.lightandshadows.network.ModNetwork;
//
//import java.text.DecimalFormat;
//import java.util.List;
//
//public class MinoanSphere extends Item {
//    public MinoanSphere(Settings settings) {
//        super(settings);
//    }
//
//    //Add NBT data
//    public static NbtCompound nbtData = new NbtCompound();
//    private NbtCompound positionData = new NbtCompound();
//
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
//        if (!player.getWorld().isClient()) {
//
//            ItemStack stack = player.getStackInHand(hand);
//
//            //Shift + RMB
//            if (player.isSneaking() && !stack.hasNbt()) {
//
//                LightAndShadows.LOGGER.info(player.getName().toString());
//                MinoanSphereHandler.playerList.put(player.getUuid(), (ServerPlayerEntity) player);
//
//                nbtData.putBoolean("isCharged", true);
//                stack.setNbt(nbtData);
//
//                nbtData.putUuid("id", player.getUuid());
//                stack.setNbt(nbtData);
//
//                //Get player pose and add it to NBT
//                ModNetwork.send(MinoanSphereHandler.GET_INFO_PACKET_ID);
//
//                positionData.putString("dimension", world.getRegistryKey().getValue().toString());
//                positionData.putDouble("x", player.getPos().getX());
//                positionData.putDouble("y", player.getPos().getY());
//                positionData.putDouble("z", player.getPos().getZ());
//                positionData.putFloat("yaw", player.getYaw());
//                positionData.putFloat("pitch", player.getPitch());
//                stack.setSubNbt("position", positionData);
//
//                //RMB click
//            } else if (!player.isSneaking()
//                    && stack.hasNbt()
//                    && stack.getNbt().getBoolean("isCharged")
//            ) {
//
//                //Sphere discharge and deletion coordinates
//                nbtData.putBoolean("isCharged", false);
//                stack.setNbt(nbtData);
//
//                //Teleport
//                ModNetwork.send(MinoanSphereHandler.TELEPORT_PACKET_ID);
//            }
//        }
//        return TypedActionResult.success(player.getStackInHand(hand));
//    }
//    @Override
//    public void appendTooltip(
//            ItemStack stack,
//            @Nullable World world,
//            List<Text> tooltip,
//            TooltipContext context
//    ) {
//
//        //Standard sphere tooltip
//        tooltip.add(Text.translatable("item.lightandshadows.minoan_sphere.tooltip").formatted(Formatting.GRAY));
//
//        //Tooltip with player position
//        if (stack.hasNbt()) {
//
//            if (!stack.getNbt().getBoolean("isCharged")) {
//
//                tooltip.add(Text.translatable("tooltip.lightandshadows.void"));
//                tooltip.add(Text.translatable("tooltip.lightandshadows.status.uncharged"));
//
//            } else {
//
//                tooltip.add(Text.translatable("tooltip.lightandshadows.void"));
//                tooltip.add(Text.translatable("tooltip.lightandshadows.status.charged"));
//                tooltip.add(Text.translatable("tooltip.lightandshadows.void"));
//
//                if (Screen.hasShiftDown()) {
//                    tooltip.add(Text.translatable("item.lightandshadows.minoan_sphere_with_coordinates.tooltip").formatted(Formatting.GRAY));
//                    DecimalFormat decimalFormat = new DecimalFormat("#");
//                    String positionX = decimalFormat.format(stack.getSubNbt("position").getDouble("x"));
//                    tooltip.add(Text.of("§7X: §6" + positionX));
//                    String positionY = decimalFormat.format(stack.getSubNbt("position").getDouble("y"));
//                    tooltip.add(Text.of("§7Y: §6" + positionY));
//                    String positionZ = decimalFormat.format(stack.getSubNbt("position").getDouble("z"));
//                    tooltip.add(Text.of("§7Z: §6" + positionZ));
//
//                    String dimensionID = stack.getSubNbt("position").getString("dimension");
//
//                    if (dimensionID.equals("minecraft:overworld")) {
//                        tooltip.add(Text.translatable("tooltip.lightandshadows.dimension.overworld"));
//                    } else if (dimensionID.equals("minecraft:the_nether")) {
//                        tooltip.add(Text.translatable("tooltip.lightandshadows.dimension.nether"));
//                    } else if (dimensionID.equals("minecraft:the_end")) {
//                        tooltip.add(Text.translatable("tooltip.lightandshadows.dimension.end"));
//                    } else {
//                        tooltip.add(Text.translatable("tooltip.lightandshadows.dimension", dimensionID));
//                    }
//                } else {
//                    tooltip.add(Text.translatable("lightandshadows.hold_shift.tooltip").formatted(Formatting.GRAY));
//                }
//            }
//        } else {
//
//            tooltip.add(Text.translatable("tooltip.lightandshadows.void"));
//            tooltip.add(Text.translatable("tooltip.lightandshadows.status.charged"));
//
//        }
//
//        tooltip.add(Text.translatable("tooltip.lightandshadows.void"));
//        tooltip.add(Text.translatable("tooltip.lightandshadows.none_server_work"));
//
//    }
//}