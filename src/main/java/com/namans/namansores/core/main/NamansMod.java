package com.namans.namansores.core.main;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.namans.namansores.core.json.JsonWriter;
import com.namans.namansores.core.proxy.CommonProxy;

@Mod(modid = ModConfig.MOD_ID, version = ModConfig.MOD_VERSION)
public class NamansMod {

	@Instance
	public static NamansMod instance = new NamansMod();

	@SidedProxy(clientSide=ModConfig.PROXY_CLIENT, serverSide=ModConfig.PROXY_SERVER)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		if (!ModConfig.RELEASE) JsonWriter.writeAll();
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}