package com.NindyBun.watercanteens.helpers;

import com.NindyBun.watercanteens.WaterCanteens;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class Utilities {

    public static String addModID(String key, String name) {
        return key + "." + WaterCanteens.MODID + "." + name;
    }

    public static BlockHitResult getLookingAt(Level world, Player player, Vec3 start, Vec3 look, ClipContext.Fluid rayTraceFluid, double range) {
        Vec3 end = new Vec3(start.x + look.x * range, start.y + look.y * range, start.z + look.z * range);
        ClipContext context = new ClipContext(start, end, ClipContext.Block.COLLIDER, rayTraceFluid, player);
        return world.clip(context);
    }
}
