package net.rtferry.mcforgecourse.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.item.ModItems;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCForgeCourseMod.MOD_ID);

    // Regular Blocks:
    public static final RegistryObject<Block> AZURITE_BLOCK = registerBlock("azurite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> COSMII_BLOCK = registerBlock("cosmii_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));

    // Experience blocks:
    public static final RegistryObject<Block> AZURITE_ORE = registerBlock("azurite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5),
                    (BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops())));
    public static final RegistryObject<Block> AZURITE_DEEPSLATE_ORE = registerBlock("azurite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,7),
                    (BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops())));
    public static final RegistryObject<Block> AZURITE_NETHER_ORE = registerBlock("azurite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,8),
                    (BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops())));
    public static final RegistryObject<Block> AZURITE_END_ORE = registerBlock("azurite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,10),
                    (BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops())));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
