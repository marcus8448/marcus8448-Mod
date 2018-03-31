package com.marcus8448.mod.items;
import java.util.ArrayList;
import java.util.List;

import com.marcus8448.mod.Marcus8448Mod;
import com.marcus8448.mod.items.ItemBlueSlimeball;

import net.minecraft.item.Item;

public class Items {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item BLUE_BOOK = new ItemBlueBook("blue_book");
	public static final Item BLUE_SLIMEBALL = new ItemBlueSlimeball("blue_slimeball");
	public static final Item KEY = new ItemKey("key");
	public static final Item LOCK_PICK = new ItemLockPick("lock_pick");
	public static final Item GLASS_SWORD = new ItemGlassSword("glass_sword", Marcus8448Mod.GLASS);
}
