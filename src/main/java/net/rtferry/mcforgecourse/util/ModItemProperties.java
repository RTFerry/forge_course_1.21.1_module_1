package net.rtferry.mcforgecourse.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.component.ModDataComponentTypes;
import net.rtferry.mcforgecourse.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(MCForgeCourseMod.MOD_ID,"on"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.FOUND_BLOCK.get()) != null ? 1f : 0f);

        makeBow(ModItems.AZURITE_BOW.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(Items.BOW, ResourceLocation.withDefaultNamespace("pull"), (itemStack, clientLevel, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(Items.BOW, ResourceLocation.withDefaultNamespace("pulling"),
                (itemStack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F
        );
    }
}
