package net.rtferry.mcforgecourse.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 200), 0.25f).build();
    public static final FoodProperties VENISON = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,800,1),1f)
            .effect(new MobEffectInstance(MobEffects.JUMP,800,1),1f).build();
    public static final FoodProperties COSMII_GOOBER = new FoodProperties.Builder().nutrition(3).saturationModifier(0.1f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION,300),1f)
            .effect(new MobEffectInstance(MobEffects.HUNGER,300),1f).build();
}
