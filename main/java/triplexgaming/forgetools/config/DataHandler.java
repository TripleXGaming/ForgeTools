package triplexgaming.forgetools.config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import scala.reflect.io.File;

public class DataHandler {

	public static void saveData(String DataPath)
	{
		System.out.println("testing this is a test to see if file is saving");
		 try{
			    // Create file 
			    FileWriter fstream = new FileWriter(DataPath);
			        BufferedWriter out = new BufferedWriter(fstream);
			    out.write("Hello Java");
			    //Close the output stream
			    out.close();
			    }catch (Exception e){//Catch exception if any
			      System.err.println("Error: " + e.getMessage());
			    }
		
	}
	
	public static void loadData()
	{
		
		
	}
	
	
}


