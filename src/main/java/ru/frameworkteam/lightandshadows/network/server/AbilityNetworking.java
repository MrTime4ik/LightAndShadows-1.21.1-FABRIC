package ru.frameworkteam.lightandshadows.network.server;//package ru.frameworkteam.lightandshadows.network.server;
//
//import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//import net.minecraft.network.PacketByteBuf;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.TypedActionResult;
//
//public class AbilityNetworking {
//
//    public static final Identifier TELEPORT_PACKET_ID = new Identifier("lightandshadows", "teleport_player");
//
//    public static void send(ServerPlayerEntity player, Identifier channelName, PacketByteBuf buf) {
//
//        ServerPlayNetworking.send((ServerPlayerEntity) player, AbilityNetworking.TELEPORT_PACKET_ID, PacketByteBufs.empty());
//        return TypedActionResult.success(player.getStackInHand(player.getActiveHand()));
//
//    }
//
//}
