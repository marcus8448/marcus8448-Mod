package com.marcus8448.mods.marcus8448mod.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.fml.common.network.IGuiHandler;

import com.marcus8448.mods.marcus8448mod.blocks.ContainerPedestal;
import com.marcus8448.mods.marcus8448mod.blocks.GuiPedestal;
import com.marcus8448.mods.marcus8448mod.blocks.TileEntityPedestal;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_Alpha
 *
 */
public class GuiHandler implements IGuiHandler {
    public static final int PEDESTAL = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
        case PEDESTAL:
            return new ContainerPedestal(player.inventory,
                    (TileEntityPedestal) world.getTileEntity(new BlockPos(x, y, z)));
        default:
            return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
        case PEDESTAL:
            return new GuiPedestal(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
        default:
            return null;
        }
    }
}
