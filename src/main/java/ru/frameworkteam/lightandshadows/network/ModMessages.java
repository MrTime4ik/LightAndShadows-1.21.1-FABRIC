//package ru.frameworkteam.lightandshadows.network;
//
//import com.mojang.serialization.Codec;
//import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//import net.minecraft.network.codec.PacketCodec;
//import net.minecraft.network.packet.CustomPayload;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.PathUtil;
//import ru.frameworkteam.lightandshadows.LightAndShadows;
//import ru.frameworkteam.lightandshadows.ModComponents;
//import ru.frameworkteam.lightandshadows.components.PositionComponent;
//import ru.frameworkteam.lightandshadows.item.ModItems;
//import ru.frameworkteam.lightandshadows.network.packet.TeleportC2SPacket;
//import ru.frameworkteam.lightandshadows.util.InventoryUtils;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//public class ModMessages {
//
//    static Map<UUID, ServerWorld> worldList = new HashMap<>();
//
//    public static final CustomPayload.Id TELEPORT_ID = new CustomPayload.Id(Identifier.of(LightAndShadows.MOD_ID, "teleport"));
//    public static final CustomPayload.Id GET_WORLD_ID = new CustomPayload.Id(Identifier.of(LightAndShadows.MOD_ID, "get_world"));
//
////    public static final CustomPayload SOME = new CustomPayload() {
////        @Override
////        public Id<? extends CustomPayload> getId() {
////            return TELEPORT_ID;
////        }
////    };
//
//    public static void registerC2SPackets() {
////        ServerPlayNetworking.registerGlobalReceiver(GET_WORLD_ID, new ServerPlayNetworking.PlayPayloadHandler<CustomPayload>() {
////            @Override
////            public void receive(CustomPayload payload, ServerPlayNetworking.Context context) {
////                ServerPlayerEntity player = context.player();
////
////                worldList.put(player.getUuid(), player.getServerWorld());
////            }
////        });
////        PayloadTypeRegistry.configurationC2S().register(TELEPORT_ID, TeleportC2SPacket.CODEC);
//        ServerPlayNetworking.registerGlobalReceiver(TELEPORT_ID, TeleportC2SPacket.TELEPORT_PACKET);
//
//    }
//
//    public static void registerS2CPackets() {
//        PayloadTypeRegistry.configurationS2C();
//    }
//
//}
