package triplexgaming.forgetools.config;

import java.io.File;

public class ForgeToolsConfiguration{
	public static File mainConfigFile;
	public static File MachineConfigFile;

	public static void init(String configpath){
		mainConfigFile = new File(configpath + "ForgeTools.cfg");

		ForgeToolsConfigurationMain.init(mainConfigFile);
	}
}