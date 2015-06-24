package com.namans.namansores.items.base;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.namansores.blocks.base.ModBlock;
import com.namans.namansores.blocks.base.ModBlocks;
import com.namans.namansores.core.crafting.Craftable;
import com.namans.namansores.core.main.ModConfig;
import com.namans.namansores.items.ingots.ItemIngot;

public enum ModItems {
	
	INGOT_COPPER    (new ItemIngot("item_ingot_copper")),
	INGOT_LEAD      (new ItemIngot("item_ingot_lead")),
	INGOT_MITHRIL   (new ItemIngot("item_ingot_mithril")),
	INGOT_NICKEL    (new ItemIngot("item_ingot_nickel")),
	INGOT_PLATINUM  (new ItemIngot("item_ingot_platinum")),
	INGOT_SILVER    (new ItemIngot("item_ingot_silver")),
	INGOT_TIN       (new ItemIngot("item_ingot_tin"));
	
	private String name;
	private Item item;
	
	private ModItems(Item item) {
		this.item = item;
		this.name = get().getUnlocalizedName().substring(5);
		if (item instanceof ModItem) {
			((ModItem)item).setSelf(this);
		}
	}
	public Item get() {
		return item;
	}
	public ItemStack getNewItemStack() {
		return new ItemStack(get());
	}
	public ItemStack getNewItemStack(int amount, int metaData) {
		return new ItemStack(get(), amount, metaData);
	}
	public String getName() {
		return name;
	}
	public ModelResourceLocation getResource() {
		return new ModelResourceLocation(ModConfig.MOD_ID + ":" + name, "inventory");
	}
	public static void registerAll() {
		for (ModItems item : ModItems.values()) {
			GameRegistry.registerItem(item.get(), item.getName());
		}
	}
	public static void registerAllRenderers() {
	    for (ModItems item : ModItems.values()) {
	    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item.get(), 0, item.getResource());
		}
	}
	public static void registerAllCrafting() {
		for (ModItems item : ModItems.values()) {
	    	if (!(item.get() instanceof Craftable)) continue;
	    	Craftable craftable = (Craftable) item.get();
	    	craftable.initCrafting();
	    	craftable.registerShapedRecipies();
	    	craftable.registerShapelessRecipies();
	    	craftable.registerSmeltingRecipies();
    	}
	}
}