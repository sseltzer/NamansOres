package com.namans.namansores.items.ingots;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.namansores.blocks.base.ModBlocks;
import com.namans.namansores.core.crafting.Craftable;
import com.namans.namansores.items.base.ModItem;
import com.namans.namansores.items.base.ModItems;

public class ItemIngot extends Item implements ModItem, Craftable {
	
	private ModItems thisItem;
	private ModBlocks metalBlock;

	public ItemIngot(String string) {
		super();
        this.setUnlocalizedName(string);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	@Override
	public void setSelf(ModItems thisItem) {
		this.thisItem = thisItem;
	}
	
	@Override
	public void initCrafting() {
		switch (thisItem) {
			case INGOT_COPPER:    metalBlock = ModBlocks.METAL_COPPER;   break;
			case INGOT_LEAD:      metalBlock = ModBlocks.METAL_LEAD;     break;
			case INGOT_MITHRIL:   metalBlock = ModBlocks.METAL_MITHRIL;  break;
			case INGOT_NICKEL:    metalBlock = ModBlocks.METAL_NICKEL;   break;
			case INGOT_PLATINUM:  metalBlock = ModBlocks.METAL_PLATINUM; break;
			case INGOT_SILVER:    metalBlock = ModBlocks.METAL_SILVER;   break;
			case INGOT_TIN:       metalBlock = ModBlocks.METAL_TIN;      break;
			default:                                                     break;
		}
	}
	@Override
	public void registerShapedRecipies() {
		GameRegistry.addRecipe(metalBlock.getNewItemStack(), "###", "###", "###", '#', thisItem.get());
	}
	@Override
	public void registerShapelessRecipies() {}
	@Override
	public void registerSmeltingRecipies() {}
}