package TripleXGaming.ForgeTools.Config;

import java.io.File;

public class SpaceCraftConfiguration{
	public static File mainConfigFile;
	public static File MachineConfigFile;

	public static void init(String configpath){
		mainConfigFile = new File(configpath + "main.cfg");

		SpaceCraftConfigurationMain.init(mainConfigFile);
	}
}