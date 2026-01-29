package net.rtferry.mcforgecourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.item.ModItems;
import net.rtferry.mcforgecourse.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, MCForgeCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.AZURITE.get());

        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.AZURITE_SWORD.get());

        tag(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.AZURITE_PICKAXE.get())
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_SHOVEL.get())
                .add(ModItems.AZURITE_HOE.get())
                .add(ModItems.AZURITE_PAXEL.get());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_SWORD.get())
                .add(ModItems.AZURITE_PAXEL.get());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.AZURITE_PICKAXE.get())
                .add(ModItems.AZURITE_SHOVEL.get())
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_HOE.get())
                .add(ModItems.AZURITE_PAXEL.get());

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ModItems.AZURITE_SWORD.get())
                .add(ModItems.AZURITE_PAXEL.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.AZURITE_PICKAXE.get())
                .add(ModItems.AZURITE_SHOVEL.get())
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_HOE.get())
                .add(ModItems.AZURITE_SWORD.get())
                .add(ModItems.AZURITE_PAXEL.get());
    }
}
