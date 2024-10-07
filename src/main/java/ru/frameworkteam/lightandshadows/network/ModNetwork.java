//package ru.frameworkteam.lightandshadows.network;
//
//import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
//import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.server.world.ServerWorld;
//import ru.frameworkteam.lightandshadows.LightAndShadows;
//import ru.frameworkteam.lightandshadows.network.client.ClientPacket;
//import ru.frameworkteam.lightandshadows.network.server.ServerPacket;
//
//public class ModNetwork {
//
//    protected static ClientPacket registerPacket(String id, ServerPlayNetworking.PlayChannelHandler handler) {
//        ClientPacket packet = new ClientPacket(id, handler);
//        ServerPlayNetworking.registerGlobalReceiver(packet.ID, handler);
//
//        return packet;
//    }
//
//    protected static ServerPacket registerPacket(String id, ClientPlayNetworking.PlayChannelHandler handler) {
//        ServerPacket packet = new ServerPacket(id, handler);
//        ClientPlayNetworking.registerGlobalReceiver(packet.ID, handler);
//
//        return packet;
//    }
//
//    public static void send(ClientPacket packet) {
//        ClientPlayNetworking.send(packet.ID, PacketByteBufs.create());
//    }
//
//    public static void send(ClientPacket packet, ServerWorld world) {
//        ClientPlayNetworking.send(packet.ID, PacketByteBufs.create());
//    }
//
//    public static void send(ServerPacket packet, ServerPlayerEntity player) {
//        ServerPlayNetworking.send(player, packet.ID, PacketByteBufs.create());
//    }
//
//
//    public static void register() {
//        LightAndShadows.LOGGER.info("Register network from " + LightAndShadows.MOD_ID);
//    }
//
//}
