package net.rtferry.mcforgecourse.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.block.ModBlocks;
import net.rtferry.mcforgecourse.item.custom.*;
import net.rtferry.mcforgecourse.sound.ModSounds;

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
            () -> new ModEffectSwordItem(ModToolTiers.Azurite,new  Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.Azurite,3,-2.4f)), MobEffects.LEVITATION));
    public static final RegistryObject<Item> AZURITE_AXE = ITEMS.register("azurite_axe",
            () -> new AxeItem(ModToolTiers.Azurite,new  Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.Azurite,6f,-3.2f))));
    public static final RegistryObject<Item> AZURITE_PICKAXE = ITEMS.register("azurite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.Azurite,new  Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.Azurite,1.0f,-2.8f))));
    public static final RegistryObject<Item> AZURITE_SHOVEL = ITEMS.register("azurite_shovel",
            () -> new ShovelItem(ModToolTiers.Azurite,new  Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.Azurite,1.5f,-3.0f))));
    public static final RegistryObject<Item> AZURITE_HOE = ITEMS.register("azurite_hoe",
            () -> new HoeItem(ModToolTiers.Azurite,new  Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.Azurite,-1.0f,-2.0f))));

    public static final RegistryObject<Item> AZURITE_PAXEL = ITEMS.register("azurite_paxel",
            () -> new PaxelItem(ModToolTiers.Azurite,new  Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.Azurite,2.0f,-2.5f))));

    public static final RegistryObject<Item> AZURITE_HAMMER = ITEMS.register("azurite_hammer",
            () -> new HammerItem(ModToolTiers.Azurite,new  Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.Azurite,5.0f,-3f))));

    // Armor:
    public static final RegistryObject<Item> AZURITE_HELMET = ITEMS.register("azurite_helmet",
            () -> new ArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(25))));
    public static final RegistryObject<Item> AZURITE_CHESTPLATE = ITEMS.register("azurite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(25))));
    public static final RegistryObject<Item> AZURITE_LEGGINGS = ITEMS.register("azurite_leggings",
            () -> new ArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(25))));
    public static final RegistryObject<Item> AZURITE_BOOTS = ITEMS.register("azurite_boots",
            () -> new ArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(25))));

    // Horse Armor:
    public static final RegistryObject<Item> AZURITE_HORSE_ARMOR = ITEMS.register("azurite_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    // Armor trim pattern:
    public static final RegistryObject<Item> RTFERRY_SMITHING_TEMPLATE = ITEMS.register("rtferry_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(MCForgeCourseMod.MOD_ID,"rtferry")));

    public static final RegistryObject<Item> AZURITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("azurite_upgrade_smithing_template",
            () -> SmithingTemplateItem.createNetheriteUpgradeTemplate());

    // Metal Detector and Data tablet:
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));

    // Custom Bow:
    public static final RegistryObject<Item> AZURITE_BOW = ITEMS.register("azurite_bow",
            () -> new BowItem(new Item.Properties().durability(300)));

    // Onion Seeds:
    public static final RegistryObject<Item> ONION_SEEDS = ITEMS.register("onion_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties()));

    // Music disc:
    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.BAR_BRAWL_KEY)));
    public static final RegistryObject<Item> HORNET_MUSIC_DISC = ITEMS.register("hornet_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.HORNET_KEY)));

    public static final RegistryObject<Item> SPECTRE_STAFF = ITEMS.register("spectre_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus) {
           ITEMS.register(eventBus);
    }
}
