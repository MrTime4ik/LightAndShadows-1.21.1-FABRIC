package ru.frameworkteam.lightandshadows.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import ru.frameworkteam.lightandshadows.LightAndShadows;
import ru.frameworkteam.lightandshadows.LightAndShadowsClient;
import ru.frameworkteam.lightandshadows.ModComponents;

public class ModItems {

//    public static final Item ASTRAL_INGOT = new Item(new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
//    public static final Item FLAME_NETHERITE_INGOT = new Item(new FabricItemSettings().fireproof());
//
//
    public static final Item LUX = registerItem("lux", new Lux(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)));
//    public static final LightningStick LIGHTNING_STICK = new LightningStick(new FabricItemSettings().maxDamage(LightningStick.MAX_DURABILITY).rarity(Rarity.RARE));
//    public static final HoneyApple HONEY_APPLE = new HoneyApple(new FabricItemSettings().rarity(Rarity.EPIC).food(ModFood.HONEY));
//
    public static final Item MINOAN_SPHERE = registerItem("minoan_sphere", new MinoanSphereTEST(
            new Item.Settings()
                    .maxCount(1)
                    .rarity(Rarity.EPIC)
                    .fireproof()
                    .component(ModComponents.CHARGE_COMPONENT, true)));
//    public static final ToolItem RUNIC_SWORD = new RunicSword(RunicSword.RunicToolMaterial.INSTANCE, -1, -2.4F, new FabricItemSettings().fireproof().rarity(Rarity.EPIC));
//
//    public static final ToolItem FLAME_NETHERITE_SHOVEL = new ShovelItem(FlameNetheriteToolMaterial.INSTANCE, 0, -3F, new FabricItemSettings().fireproof());
//    public static final ToolItem FLAME_NETHERITE_PICKAXE = new FlameNetheritePickaxe(FlameNetheriteToolMaterial.INSTANCE, 0, -2.8F, new FabricItemSettings().fireproof());
//    public static final ToolItem FLAME_NETHERITE_AXE = new FlameNetheriteAxe(FlameNetheriteToolMaterial.INSTANCE, 6, -3F, new FabricItemSettings().fireproof());
//    public static final ToolItem FLAME_NETHERITE_SWORD = new FlameNetheriteSword(FlameNetheriteToolMaterial.INSTANCE, 3, -2.4F, new FabricItemSettings().fireproof());
//    public static final ToolItem FLAME_NETHERITE_HOE = new FlameNetheriteHoe(FlameNetheriteToolMaterial.INSTANCE, -5, -3F, new FabricItemSettings().fireproof());
//
//    public static final Item GRAVITATION_ORE = new BlockItem(ModBlocks.GRAVITATION_ORE, new FabricItemSettings());
//

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LightAndShadows.MOD_ID, name), item);
    }

    public static void register() {

        LightAndShadows.LOGGER.debug("Register items from: " + LightAndShadows.MOD_ID);

        //Ingredients
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.DIAMOND, LUX);
        });
        //Combat
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(MINOAN_SPHERE);
        });
    }

}
