package net.rtferry.mcforgecourse.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.rtferry.mcforgecourse.util.ModTags;

public class ModToolTiers {
    public static final Tier Azurite = new ForgeTier(1400,5,3f,18,
            ModTags.Blocks.NEEDS_AZURITE_TOOL, () -> Ingredient.of(ModItems.AZURITE.get()),ModTags.Blocks.INCORRECT_FOR_AZURITE_TOOL);
}
