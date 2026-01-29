package net.rtferry.mcforgecourse.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MCForgeCourseMod.MOD_ID);

    public static final RegistryObject<Item> AZURITE = ITEMS.register("azurite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AZURITE = ITEMS.register("raw_azurite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHAINSAW = ITEMS.register("chainsaw",
            () -> new ChainsawItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ONION)));
    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(),1000));

    // Tools:
    public static final RegistryObject<Item> AZURITE_SWORD = ITEMS.register("azurite_sword",
            () -> new ModEffectSwordItem(ModToolTiers.Azurite,new  Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.Azurite,3,-2.4f)), MobEffects.LEVITATION));
    public static final RegistryObject<Item> AZURITE_AXE = ITEMS.register("azurite_axe",
            () -> new AxeItem(ModToolTiers.Azurite,new  Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.Azurite,6f,-3.2f))));
    public static final RegistryObject<Item> AZURITE_PICKAXE = ITEMS.register("azurite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.Azurite,new  Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.Azurite,1.0f,-2.8f))));
    public static final RegistryObject<Item> AZURITE_SHOVEL = ITEMS.register("azurite_shovel",
            () -> new ShovelItem(ModToolTiers.Azurite,new  Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.Azurite,1.5f,-3.0f))));
    public static final RegistryObject<Item> AZURITE_HOE = ITEMS.register("azurite_hoe",
            () -> new HoeItem(ModToolTiers.Azurite,new  Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.Azurite,-1.0f,-2.0f))));

    public static final RegistryObject<Item> AZURITE_PAXEL = ITEMS.register("azurite_paxel",
            () -> new PaxelItem(ModToolTiers.Azurite,new  Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.Azurite,2.0f,-2.5f))));

    public static final RegistryObject<Item> AZURITE_HAMMER = ITEMS.register("azurite_hammer",
            () -> new HammerItem(ModToolTiers.Azurite,new  Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.Azurite,5.0f,-3f))));


    public static void register(IEventBus eventBus) {
           ITEMS.register(eventBus);
    }
}
