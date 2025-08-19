package com.NindyBun.watercanteens.data.recipies.CookingRecipe;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

import java.util.Objects;

public class CanteenCookingSerializer<T extends CanteenCookingRecipe> implements RecipeSerializer<T> {
    private final CanteenCookingRecipe.Factory<T> FACTORY;
    private final MapCodec<T> CODEC;
    private final StreamCodec<RegistryFriendlyByteBuf, T> STREAM_CODEC;

    public CanteenCookingSerializer(CanteenCookingRecipe.Factory<T> factory, int cookingTime) {
        this.FACTORY = factory;
        this.CODEC = RecordCodecBuilder.mapCodec(
                p_340782_ -> p_340782_.group(
                        Codec.STRING.optionalFieldOf("group", "").forGetter(p -> p.group),
                        CookingBookCategory.CODEC.fieldOf("category").orElse(CookingBookCategory.MISC).forGetter(p -> p.category),
                        ItemStack.SINGLE_ITEM_CODEC.fieldOf("input").forGetter(p -> p.input),
                        ItemStack.SINGLE_ITEM_CODEC.fieldOf("result").forGetter(p -> p.result),
                        Codec.FLOAT.fieldOf("exp").forGetter(p -> p.exp),
                        Codec.INT.fieldOf("time").forGetter(p -> p.time)
                ).apply(p_340782_, factory::create)
        );
        this.STREAM_CODEC = StreamCodec.of(this::toNetwork, this::fromNetwork);
    }

    @Override
    public MapCodec<T> codec() {
        return this.CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
        return this.STREAM_CODEC;
    }

    private T fromNetwork(RegistryFriendlyByteBuf buffer) {
        String s = buffer.readUtf();
        CookingBookCategory cookingbookcategory = (CookingBookCategory)buffer.readEnum(CookingBookCategory.class);
        ItemStack ingredient = (ItemStack)ItemStack.STREAM_CODEC.decode(buffer);
        ItemStack itemstack = (ItemStack)ItemStack.STREAM_CODEC.decode(buffer);
        float f = buffer.readFloat();
        int i = buffer.readVarInt();
        return (T) this.FACTORY.create(s, cookingbookcategory, ingredient, itemstack, f, i);
    }

    private void toNetwork(RegistryFriendlyByteBuf buffer, T recipe) {
        buffer.writeUtf(recipe.group);
        buffer.writeEnum(recipe.category());
        ItemStack.STREAM_CODEC.encode(buffer, recipe.input);
        ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        buffer.writeFloat(recipe.exp);
        buffer.writeVarInt(recipe.time);
    }

    public CanteenCookingRecipe create(String group, CookingBookCategory category, ItemStack ingredient, ItemStack result, float experience, int cookingTime) {
        return this.FACTORY.create(group, category, ingredient, result, experience, cookingTime);
    }
}
