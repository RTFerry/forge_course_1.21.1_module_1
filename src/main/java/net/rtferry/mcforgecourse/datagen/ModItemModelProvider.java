package net.rtferry.mcforgecourse.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.block.ModBlocks;
import net.rtferry.mcforgecourse.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCForgeCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.AZURITE.get());
        basicItem(ModItems.RAW_AZURITE.get());
        basicItem(ModItems.ONION.get());
        basicItem(ModItems.AURORA_ASHES.get());
        basicItem(ModItems.CHAINSAW.get());

        buttonItem(ModBlocks.AZURITE_BUTTON, ModBlocks.AZURITE_BLOCK);
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MCForgeCourseMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

}
