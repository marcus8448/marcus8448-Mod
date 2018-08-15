package com.marcus8448.mod.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.material.Material;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha1
 *
 */
public class MMBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLUE_SLIME_BLOCK = new BlockBlueSlime("blue_slime_block", Material.CLAY);
    public static final Block WHITE_OAK_PLANKS = new BlockColouredPlanks("white_oak_planks", Material.WOOD);
    public static final Block ORANGE_OAK_PLANKS = new BlockColouredPlanks("orange_oak_planks", Material.WOOD);
    public static final Block MAGENTA_OAK_PLANKS = new BlockColouredPlanks("magenta_oak_planks", Material.WOOD);
    public static final Block LIGHT_BLUE_OAK_PLANKS = new BlockColouredPlanks("light_blue_oak_planks", Material.WOOD);
    public static final Block YELLOW_OAK_PLANKS = new BlockColouredPlanks("yellow_oak_planks", Material.WOOD);
    public static final Block LIME_OAK_PLANKS = new BlockColouredPlanks("lime_oak_planks", Material.WOOD);
    public static final Block PINK_OAK_PLANKS = new BlockColouredPlanks("pink_oak_planks", Material.WOOD);
    public static final Block GRAY_OAK_PLANKS = new BlockColouredPlanks("gray_oak_planks", Material.WOOD);
    public static final Block LIGHT_GRAY_OAK_PLANKS = new BlockColouredPlanks("light_gray_oak_planks", Material.WOOD);
    public static final Block CYAN_OAK_PLANKS = new BlockColouredPlanks("cyan_oak_planks", Material.WOOD);
    public static final Block PURPLE_OAK_PLANKS = new BlockColouredPlanks("purple_oak_planks", Material.WOOD);
    public static final Block BLUE_OAK_PLANKS = new BlockColouredPlanks("blue_oak_planks", Material.WOOD);
    public static final Block BROWN_OAK_PLANKS = new BlockColouredPlanks("brown_oak_planks", Material.WOOD);
    public static final Block GREEN_OAK_PLANKS = new BlockColouredPlanks("green_oak_planks", Material.WOOD);
    public static final Block RED_OAK_PLANKS = new BlockColouredPlanks("red_oak_planks", Material.WOOD);
    public static final Block BLACK_OAK_PLANKS = new BlockColouredPlanks("black_oak_planks", Material.WOOD);
    public static final Block TRICK_WOOL = new BlockTrickWool("trick_wool", Material.ROCK);
    public static final Block SECRET_DOOR = new BlockSecretDoor("secret_door", Material.IRON);
    public static final BlockCrops CORN_CROP = new BlockCropCorn("corn_crop");
    public static final Block PEDESTAL = new BlockPedestal("pedestal", Material.IRON);
}
