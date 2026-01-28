package net.rtferry.mcforgecourse.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCForgeCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Block state for normal cube blocks
        blockWithItem(ModBlocks.AZURITE_BLOCK);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.AZURITE_ORE);
        blockWithItem(ModBlocks.AZURITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.AZURITE_NETHER_ORE);
        blockWithItem(ModBlocks.AZURITE_END_ORE);

        // Block state for stairs:
        stairsBlock(((StairBlock) ModBlocks.AZURITE_STAIRS.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        // Block state for slabs:   We do blockTexture twice for the singular and double slabs
        slabBlock(((SlabBlock) ModBlocks.AZURITE_SLAB.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        // Items for stairs and slabs:
        blockItem(ModBlocks.AZURITE_STAIRS);
        blockItem(ModBlocks.AZURITE_SLAB);
        blockItem(ModBlocks.AZURITE_PRESSURE_PLATE);
        blockItem((ModBlocks.AZURITE_FENCE_GATE));
        blockItem(ModBlocks.AZURITE_TRAPDOOR,"_bottom");

        // Fence and Wall:
        fenceBlock(((FenceBlock) ModBlocks.AZURITE_FENCE.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.AZURITE_FENCE_GATE.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.AZURITE_WALL.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        // Button:
        buttonBlock(((ButtonBlock) ModBlocks.AZURITE_BUTTON.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        // Pressure Plate:
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.AZURITE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        // Door:
        doorBlockWithRenderType(((DoorBlock) ModBlocks.AZURITE_DOOR.get()), modLoc("block/azurite_door_bottom"), modLoc("block/azurite_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.AZURITE_TRAPDOOR.get()), modLoc("block/azurite_trapdoor"), true, "cutout");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mcforgecourse:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mcforgecourse:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
