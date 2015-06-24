package com.namans.namansores.blocks.ores;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.namans.namansores.blocks.base.ModBlock;
import com.namans.namansores.blocks.base.ModBlocks;
import com.namans.namansores.core.crafting.Craftable;
import com.namans.namansores.items.base.ModItems;

public class BlockMetal extends Block implements ModBlock, Craftable {
	
	private ModBlocks thisBlock;
	private ModItems ingotItem;
	
    public BlockMetal(String string) {
    	super(Material.iron);
        this.setUnlocalizedName(string);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2.0f);
        this.setResistance(10.0f);
	}
	
    @Override
	public void setSelf(ModBlocks thisBlock) {
		this.thisBlock = thisBlock;
	}
	
	@Override
	public void initCrafting() {
		switch (thisBlock) {
			case METAL_COPPER:    ingotItem = ModItems.INGOT_COPPER;   break;
			case METAL_LEAD:      ingotItem = ModItems.INGOT_LEAD;     break;
			case METAL_MITHRIL:   ingotItem = ModItems.INGOT_MITHRIL;  break;
			case METAL_NICKEL:    ingotItem = ModItems.INGOT_NICKEL;   break;
			case METAL_PLATINUM:  ingotItem = ModItems.INGOT_PLATINUM; break;
			case METAL_SILVER:    ingotItem = ModItems.INGOT_SILVER;   break;
			case METAL_TIN:       ingotItem = ModItems.INGOT_TIN;      break;
			default:                                                   break;
		}
	}
	@Override
	public void registerShapedRecipies() {}
	@Override
	public void registerShapelessRecipies() {
		GameRegistry.addShapelessRecipe(ingotItem.getNewItemStack(9, 0), thisBlock.get());
	}
	@Override
	public void registerSmeltingRecipies() {}
}