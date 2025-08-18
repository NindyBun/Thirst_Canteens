package com.NindyBun.watercanteens.helpers;

import com.NindyBun.watercanteens.WaterCanteens;
import com.NindyBun.watercanteens.items.EmptyCanteen;
import dev.ghen.thirst.content.purity.WaterPurity;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

public class Utilities {

    public static String addModID(String key, String name) {
        return key + "." + WaterCanteens.MODID + "." + name;
    }

    public static int[] fillCanteen(ItemStack canteen, int needed, Level level, BlockPos blockPos, BlockEntity blockEntity, BlockState blockState) {
        int[] fill = {WaterPurity.getPurity(canteen), canteen.getDamageValue(), 0};
        if (level.getFluidState(blockPos).is(FluidTags.WATER)) {
            if (canteen.getItem() instanceof EmptyCanteen) {
                fill[0] = WaterPurity.getBlockPurity(level, blockPos);
            } else {
                int canteenPurity = WaterPurity.getPurity(canteen);
                int waterPurity = WaterPurity.getBlockPurity(level, blockPos);
                int averagePurity = (canteenPurity+waterPurity)/2;
                if (needed <= 0) {
                    return fill;
                }
                fill[0] = averagePurity;
            }
            fill[1] = 0;
            fill[2] = 1;
            return fill;
        } else if (blockEntity != null) {
            IFluidHandler fluidHandler = Capabilities.FluidHandler.BLOCK.getCapability(level, blockPos, blockState, blockEntity, null);
            if (fluidHandler != null) {
                int totalAmount = 0;
                int purity = 0;
                for (int i = 0; i < fluidHandler.getTanks(); i++) {
                    if (fluidHandler.getFluidInTank(i).getFluid() != Fluids.WATER) {
                        break;
                    } else {
                        totalAmount += fluidHandler.getFluidInTank(i).getAmount();
                        purity = (purity + WaterPurity.getPurity(fluidHandler.getFluidInTank(i)))/2;
                    }
                }
                totalAmount /= 250;
                int actual = Math.min(needed, totalAmount);
                if (actual <= 0) {
                    return fill;
                }
                fluidHandler.drain(actual*250, IFluidHandler.FluidAction.EXECUTE);
                fill[0] = purity;
                fill[1] = Math.max(0, needed - actual);
                fill[2] = 1;
                return fill;
            }
        } else if (blockState.getBlock() instanceof LayeredCauldronBlock) {
            int waterLevel = blockState.getValue(LayeredCauldronBlock.LEVEL);
            int actual = Math.min(needed, waterLevel);
            int purity = 0;
            if (actual <= 0) {
                return fill;
            }
            purity = (purity + WaterPurity.getBlockPurity(blockState))/2;
            if (waterLevel - actual > 0) {
                blockState.setValue(LayeredCauldronBlock.LEVEL, waterLevel - actual);
            } else {
                blockState = Blocks.CAULDRON.defaultBlockState();
            }
            level.setBlockAndUpdate(blockPos, blockState);
            fill[0] = purity;
            fill[1] = Math.max(0, needed - actual);
            fill[2] = 1;
            return fill;
        }
        return fill;
    }
}
