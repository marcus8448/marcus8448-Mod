package com.marcus8448.mods.marcus8448mod.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemSword;

import com.marcus8448.mods.marcus8448mod.Marcus8448Mod;

/**
 * 
 * @author marcus8448
 * @since 1.12.2-1.0.0_preAlpha1
 *
 */
public class MMItems {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item BLUE_BOOK = new ItemBlueBook("blue_book");
    public static final Item BLUE_SLIMEBALL = new ItemBlueSlimeball("blue_slimeball");
    public static final Item KEY = new ItemKey("key");
    public static final Item LOCK_PICK = new ItemLockPick("lock_pick");
    public static final ItemSword GLASS_SWORD = new ItemGlassSword("glass_sword", Marcus8448Mod.GLASS);
    public static final ItemFood EXP_FOOD = new ItemEXPFood("xp_food", 2, 1.0F, false);
    public static final ItemSword LIGHTNING_SWORD = new ItemLightningSword("lightning_sword", Marcus8448Mod.LIGHTNING);
    public static final ItemSword COMPRESSED_OBSIDIAN_SWORD = new ItemLightningSword("compressed_obsidian_sword",
            Marcus8448Mod.COMPRESSED_OBSIDIAN);
    public static final Item LIGHTNING_SHARD = new ItemLightningShard("lightning_shard");
    public static final Item GLASS_SHARD = new ItemBasic("glass_shard");
    public static final Item SHARP_GLASS = new ItemBasic("sharp_glass");
    public static final ItemFood CORN = new ItemCorn("corn", 4, 1.5F, false);
    public static final ItemSeeds CORN_SEED = new ItemCornSeed("corn_seed");
    public static final Item COLD_STEEL = new ItemColdSteel("cold_steel");
    public static final Item THROWABLE_TNT = new ItemThrowableTNT("throwable_tnt");
}
