package net.rtferry.mcforgecourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.rtferry.mcforgecourse.MCForgeCourseMod;
import net.rtferry.mcforgecourse.block.ModBlocks;
import net.rtferry.mcforgecourse.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> AZURITE_SMELTABLES = List.of(ModItems.RAW_AZURITE.get(),
                ModBlocks.AZURITE_ORE.get(),ModBlocks.AZURITE_DEEPSLATE_ORE.get(),ModBlocks.AZURITE_NETHER_ORE.get(), ModBlocks.AZURITE_END_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_PAXEL.get())
                .pattern("ABC")
                .pattern(" D ")
                .pattern(" D ")
                .define('A', ModItems.AZURITE_PICKAXE.get())
                .define('B', ModItems.AZURITE_AXE.get())
                .define('C', ModItems.AZURITE_SHOVEL.get())
                .define('D', Items.STICK)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_LAMP.get())
                        .pattern("ABA")
                        .pattern("BAB")
                        .pattern("ABA")
                        .define('A', ModItems.AZURITE.get())
                        .define('B', Items.GLOWSTONE_DUST)
                        .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK.get())
                .unlockedBy("has_azurite_block", has(ModBlocks.AZURITE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK.get())
                .unlockedBy("has_azurite_block", has(ModBlocks.AZURITE_BLOCK.get())).save(pRecipeOutput,"mcforgecourse:azurite_2");

        oreSmelting(pRecipeOutput, AZURITE_SMELTABLES, RecipeCategory.MISC, ModItems.AZURITE.get(), 0.25f,200,"azurite");
        oreBlasting(pRecipeOutput, AZURITE_SMELTABLES, RecipeCategory.MISC, ModItems.AZURITE.get(), 0.25f,125,"azurite");

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_SLAB.get(), ModBlocks.AZURITE_BLOCK.get());
        stairBuilder(ModBlocks.AZURITE_STAIRS.get(), Ingredient.of(ModBlocks.AZURITE_BLOCK.get())).group("azurite")
                .unlockedBy("has_azurite_block", has(ModBlocks.AZURITE_BLOCK.get())).save(pRecipeOutput);

        buttonBuilder(ModBlocks.AZURITE_BUTTON.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.AZURITE_PRESSURE_PLATE.get(), ModItems.AZURITE.get());

        fenceBuilder(ModBlocks.AZURITE_FENCE.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.AZURITE_FENCE_GATE.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_WALL.get(), ModItems.AZURITE.get());

        doorBuilder(ModBlocks.AZURITE_DOOR.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.AZURITE_TRAPDOOR.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(pRecipeOutput);

        trimSmithing(pRecipeOutput, ModItems.RTFERRY_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(MCForgeCourseMod.MOD_ID, "rtferry"));

        // Custom tool smithing upgrades:
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(Items.DIAMOND_SWORD),
                Ingredient.of(ModItems.AZURITE.get()),
                RecipeCategory.COMBAT,
                ModItems.AZURITE_SWORD.get()
        )
                .unlocks("has_diamond_sword", has(Items.DIAMOND_SWORD))
                .save(pRecipeOutput, "azurite_sword_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_PICKAXE),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.TOOLS,
                        ModItems.AZURITE_PICKAXE.get()
                )
                .unlocks("has_diamond_pickaxe", has(Items.DIAMOND_PICKAXE))
                .save(pRecipeOutput, "azurite_pickaxe_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_SHOVEL),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.TOOLS,
                        ModItems.AZURITE_SHOVEL.get()
                )
                .unlocks("has_diamond_shovel", has(Items.DIAMOND_SHOVEL))
                .save(pRecipeOutput, "azurite_shovel_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_AXE),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.TOOLS,
                        ModItems.AZURITE_AXE.get()
                )
                .unlocks("has_diamond_axe", has(Items.DIAMOND_AXE))
                .save(pRecipeOutput, "azurite_axe_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_HOE),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.TOOLS,
                        ModItems.AZURITE_HOE.get()
                )
                .unlocks("has_diamond_hoe", has(Items.DIAMOND_HOE))
                .save(pRecipeOutput, "azurite_hoe_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_HELMET),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.COMBAT,
                        ModItems.AZURITE_HELMET.get()
                )
                .unlocks("has_diamond_helmet", has(Items.DIAMOND_HELMET))
                .save(pRecipeOutput, "azurite_helmet_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_CHESTPLATE),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.COMBAT,
                        ModItems.AZURITE_CHESTPLATE.get()
                )
                .unlocks("has_diamond_chestplate", has(Items.DIAMOND_CHESTPLATE))
                .save(pRecipeOutput, "azurite_chestplate_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_LEGGINGS),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.COMBAT,
                        ModItems.AZURITE_LEGGINGS.get()
                )
                .unlocks("has_diamond_leggings", has(Items.DIAMOND_LEGGINGS))
                .save(pRecipeOutput, "azurite_leggings_smithing");

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.AZURITE_UPGRADE_SMITHING_TEMPLATE.get()),
                        Ingredient.of(Items.DIAMOND_BOOTS),
                        Ingredient.of(ModItems.AZURITE.get()),
                        RecipeCategory.COMBAT,
                        ModItems.AZURITE_BOOTS.get()
                )
                .unlocks("has_diamond_boots", has(Items.DIAMOND_BOOTS))
                .save(pRecipeOutput, "azurite_boots_smithing");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MCForgeCourseMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
