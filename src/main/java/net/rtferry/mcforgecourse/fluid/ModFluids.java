package net.rtferry.mcforgecourse.fluid;


import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.block.ModBlocks;
import net.rtferry.mcforgecourse.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, MCForgeCourseMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_AZURITE_WATER = FLUIDS.register("source_azurite_water",
            () -> new ForgeFlowingFluid.Source(ModFluids.AZURITE_WATER_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_AZURITE_WATER = FLUIDS.register("flowing_azurite_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.AZURITE_WATER_PROPERTIES));

    public static final RegistryObject<LiquidBlock> AZURITE_WATER_BLOCK = ModBlocks.BLOCKS.register("azurite_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_AZURITE_WATER, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<Item> AZURITE_WATER_BUCKET = ModItems.ITEMS.register("azurite_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_AZURITE_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));


    public static final ForgeFlowingFluid.Properties AZURITE_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.AZURITE_WATER_FLUID_TYPE, SOURCE_AZURITE_WATER, FLOWING_AZURITE_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluids.AZURITE_WATER_BLOCK).bucket(ModFluids.AZURITE_WATER_BUCKET);


    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
