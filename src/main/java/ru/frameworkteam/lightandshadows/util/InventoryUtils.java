package ru.frameworkteam.lightandshadows.util;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryUtils {

    public static int getFirstInventoryIndex(PlayerInventory inventory, Item item) {
        for(int i = 0; i < inventory.size(); i++) {
            ItemStack currentStack = inventory.getStack(i);
            if (!currentStack.isEmpty() && currentStack.isOf(item)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean hasPlayerStackInInventory(PlayerInventory inventory, Item item) {
        for(int i = 0; i < inventory.size(); i++) {
            ItemStack currentStack = inventory.getStack(i);
            if (!currentStack.isEmpty() && currentStack.isOf(item)) {
                return true;
            }
        }

        return false;
    }

    public static int countStackInInventory(PlayerInventory inventory, Item item) {
        int stackCount = 0;
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack currentStack = inventory.getStack(i);
            if (!currentStack.isEmpty() && currentStack.isOf(item)) {
                int countInStack = currentStack.getCount();
                stackCount += countInStack;
            }
        }
        return stackCount;
    }

}
