package net.rtferry.mcforgecourse.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
