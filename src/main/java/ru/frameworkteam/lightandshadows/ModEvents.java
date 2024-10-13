package ru.frameworkteam.lightandshadows;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.world.ServerWorld;
import ru.frameworkteam.lightandshadows.components.PositionComponent;
import ru.frameworkteam.lightandshadows.item.ModItems;
import ru.frameworkteam.lightandshadows.util.InventoryUtils;

public class ModEvents {

    public static void AllowDeath() {
        ServerLivingEntityEvents.ALLOW_DEATH.register(((entity, damageSource, damageAmount) -> {

            if (entity.isPlayer()) {
                PlayerEntity player = (PlayerEntity) entity;

                int sphereIndex = InventoryUtils.getFirstInventoryIndex(player.getInventory(), ModItems.MINOAN_SPHERE);
                if (sphereIndex != -1) {

                    ItemStack sphere = player.getInventory().getStack(sphereIndex);
                    if (sphere.get(ModComponents.CHARGE_COMPONENT) && sphere.contains(ModComponents.POSITION_COMPONENT)) {

                        PositionComponent position = sphere.get(ModComponents.POSITION_COMPONENT);

                        player.setHealth(20);
                        player.setFireTicks(0);
                        player.setFrozenTicks(0);
                        player.clearStatusEffects();
                        player.teleport(position.getX(), position.getY(), position.getZ(), false);
//                        ClientPlayNetworking.send(() -> ModMessages.TELEPORT_ID);

                        sphere.set(ModComponents.CHARGE_COMPONENT, false);
                        sphere.remove(ModComponents.POSITION_COMPONENT);

                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
            return false;
        }));}

//    public static void ClientTickStart() {
//        ClientTickEvents.START_CLIENT_TICK.register((client -> {
//
//            if (client.player != null) {
//
//                PlayerInventory inventory = client.player.getInventory();
//                int itemCount = InventoryUtils.countStackInInventory(inventory, ModItems.MINOAN_SPHERE);
//
//                if (itemCount > 1) {
//                    for (int i = 0; i < itemCount; i++) {
//                        inventory.removeOne(ModItems.MINOAN_SPHERE.getDefaultStack());
//                    }
//                }
//            }
//        }));
//    }
}
