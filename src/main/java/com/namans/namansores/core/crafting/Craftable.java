package com.namans.namansores.core.crafting;

import net.minecraft.block.Block;

public interface Craftable {

	public void initCrafting();
	public void registerShapedRecipies();
	public void registerShapelessRecipies();
	public void registerSmeltingRecipies();
}
