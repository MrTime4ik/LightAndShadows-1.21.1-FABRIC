//package ru.frameworkteam.lightandshadows.network.packet;
//
//import net.fabricmc.fabric.api.networking.v1.PacketSender;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//import net.minecraft.item.ItemStack;
//import net.minecraft.network.PacketByteBuf;
//import net.minecraft.network.codec.PacketCodec;
//import net.minecraft.network.packet.CustomPayload;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.server.network.ServerPlayNetworkHandler;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.server.world.ServerWorld;
//import ru.frameworkteam.lightandshadows.ModComponents;
//import ru.frameworkteam.lightandshadows.ModEvents;
//import ru.frameworkteam.lightandshadows.components.PositionComponent;
//import ru.frameworkteam.lightandshadows.item.ModItems;
//import ru.frameworkteam.lightandshadows.network.ModMessages;
//import ru.frameworkteam.lightandshadows.util.InventoryUtils;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//public class TeleportC2SPacket {
//
//    static Map<UUID, ServerWorld> worldList = new HashMap<>();
//    static String text;
//
//
//    public static final ServerPlayNetworking.PlayPayloadHandler TELEPORT_PACKET = new ServerPlayNetworking.PlayPayloadHandler() {
//        @Override
//        public void receive(CustomPayload payload, ServerPlayNetworking.Context context) {
//            ServerPlayerEntity player = context.player();
//
//            int index = InventoryUtils.getFirstInventoryIndex(player.getInventory(), ModItems.MINOAN_SPHERE);
//            PositionComponent position = player.getInventory().getStack(index).get(ModComponents.POSITION_COMPONENT);
////                ServerWorld world = worldList.get(player.getUuid());
//            ServerWorld world = player.getServerWorld();
//
//            player.teleport(world,
//                    position.getX(),
//                    position.getY(),
//                    position.getZ(),
//                    player.getYaw(),
//                    player.getPitch());
//        }
//    };
//
////    public static final PacketCodec<PacketByteBuf, CustomPayload> CODEC = PacketCodec.of(CustomPayload::, CustomPayload::new);
//
//    private TeleportC2SPacket(PacketByteBuf buf) {
//        this.text = buf.readString();
//    }
//
//    private void write(PacketByteBuf buf) {
//        buf.writeString(this.text);
//    }
//
//}
