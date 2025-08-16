package com.NindyBun.watercanteens.registries;

import com.NindyBun.watercanteens.WaterCanteens;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RegComponents {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, WaterCanteens.MODID);

    public static final Supplier<DataComponentType<Integer>> WATER_AMOUNT = COMPONENTS.registerComponentType("water-amount", builder ->
            builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT)
    );
}
