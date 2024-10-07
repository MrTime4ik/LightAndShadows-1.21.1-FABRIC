//package ru.frameworkteam.lightandshadows.network;
//
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.server.world.ServerWorld;
//import ru.frameworkteam.lightandshadows.LightAndShadows;
//import ru.frameworkteam.lightandshadows.network.client.ClientPacket;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//public class MinoanSphereHandler extends ModNetwork {
//
//    static Map<UUID, ServerWorld> worldList = new HashMap<>();
//    public static Map<UUID, ServerPlayerEntity> playerList = new HashMap<>();
//
//    //Teleport to player pose
//    public static final ClientPacket TELEPORT_PACKET_ID = registerPacket(
//            "teleport_packet_id",
//            ((server, player, handler, buf, responseSender) -> {
//
//        double playerX = player.getStackInHand(
//                player.getActiveHand()).getSubNbt("position").getDouble("x");
//        double playerY = player.getStackInHand(
//                player.getActiveHand()).getSubNbt("position").getDouble("y");
//        double playerZ = player.getStackInHand(
//                player.getActiveHand()).getSubNbt("position").getDouble("z");
//        float playerYaw = player.getStackInHand(
//                player.getActiveHand()).getSubNbt("position").getFloat("yaw");
//        float playerPitch = player.getStackInHand(
//                player.getActiveHand()).getSubNbt("position").getFloat("pitch");
//
//        ServerPlayerEntity truePlayer = playerList.get(player.getUuid());
//
//        LightAndShadows.LOGGER.info("------------------");
//        LightAndShadows.LOGGER.info(truePlayer.getName().toString());
//        LightAndShadows.LOGGER.info(player.getName().toString());
//
//        truePlayer.teleport(worldList.get(player.getUuid()),
//                playerX, playerY, playerZ,
//                playerYaw, playerPitch);
//    }));
//
//    public static final ClientPacket GET_INFO_PACKET_ID = registerPacket("get_info_packet_id", ((server, player, handler, buf, responseSender) -> {
//
//        worldList.put(player.getUuid(), player.getServerWorld());
////        playerList.put(player.getUuid(), player);
//
//        LightAndShadows.LOGGER.info(player.getName().toString());
//
//    }));
//
//}
