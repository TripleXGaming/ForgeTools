package triplexgaming.forgetools.config;

import java.io.File;

public class ForgeToolsConfiguration{
	public static File mainConfigFile;
	public static File PermsConfigFile;

	public static void init(String configpath){
		mainConfigFile = new File(configpath + "ForgeTools.cfg");
		PermsConfigFile = new File(configpath + "Permissions.cfg");
		
		ForgeToolsConfigurationMain.init(mainConfigFile);
		ForgeToolsConfigurationPerms.init(PermsConfigFile);
	}
}