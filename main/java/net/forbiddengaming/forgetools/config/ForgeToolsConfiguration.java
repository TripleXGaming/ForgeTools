package net.forbiddengaming.forgetools.config;

import net.forbiddengaming.forgetools.config.ForgeToolsConfigurationMain;

import java.io.File;

public class ForgeToolsConfiguration{
	public static File mainConfigFile;
	public static File MachineConfigFile;

	public static void init(String configpath){
		mainConfigFile = new File(configpath + "ForgeTools.cfg");

		ForgeToolsConfigurationMain.init(mainConfigFile);
	}
}