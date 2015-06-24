package com.namans.namansores.core.main;

public class ModConfig {
	
	public static final boolean RELEASE = false;
	
	public static final String MOD_ID = "namansores";
	public static final String MOD_NAME = "Namans Ores";
	public static final String MOD_VERSION = "1.0.0";
	
	public static final String PACKAGE   = "com.namans." + MOD_ID + ".";
	
	public static final String PROXY_PATH   = PACKAGE + "core.proxy.";
	public static final String PROXY_CLIENT = PROXY_PATH + "ClientProxy";
	public static final String PROXY_SERVER = PROXY_PATH + "CommonProxy";
	
	public static final String JSON_PATH                     = formatSlash(PACKAGE) + "/core/json/";
	public static final String JSON_TEMPLATE_BLOCKSTATE      = JSON_PATH + "StdBlockstate.json";
	public static final String JSON_TEMPLATE_MODELBLOCK      = JSON_PATH + "StdModelBlock.json";
	public static final String JSON_TEMPLATE_MODELITEMBLOCK  = JSON_PATH + "StdModelItemBlock.json";
	public static final String JSON_TEMPLATE_MODELITEM       = JSON_PATH + "StdModelItem.json";
	
	
	private static String formatSlash(String str) {
		return str.replaceAll("\\.", "/");
	}
}
