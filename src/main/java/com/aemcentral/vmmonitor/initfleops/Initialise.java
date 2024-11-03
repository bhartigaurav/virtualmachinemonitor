package com.aemcentral.vmmonitor.initfleops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.aemcentral.vmmonitor.models.InitFile;
import com.google.gson.Gson;

public class Initialise {

	public static void main(String Args[]) {
		//getosinfo();
		 //CreateFile();
		fileexists(getpath());
	}

	public static int fileexists(String filePath) {
        
        int result=0;
        // Create a File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
        	result=1;
        
        } else {
            
        }
		return result;
    }
	
	public static String getpath() {
		String os = "unknown";

		String osName = System.getProperty("os.name").toLowerCase();

		if (osName.contains("win")) {
			os = Variables.fp_os_windows;

		} else if (osName.contains("mac")) {
			os = Variables.mac_os_windows;

		} else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
			os = Variables.linux_os_windows;

		} else {

		}
		return os;
	}

	public static String createjson(String VMMCode,String Secret,String MachineEnvironment,String VMlevel,String WebApp, String HostIP) {
		/*
		    String VMMCode = "vm1";
		    String Secret = "asqwer";
		    String MachineEnvironment = "critical";
		    String VMlevel = "PROD";
		    String WebApp = "NA";
		   */
		
		    InitFile init = new InitFile(VMMCode,  Secret,  MachineEnvironment,  VMlevel,  WebApp, HostIP);
		
		Gson gson = new Gson();
		String json = gson.toJson(init);
		return (json);
		
	}
	
	public static String CreateFile(String VMMCode,String Secret,String MachineEnvironment,String VMlevel,String WebApp, String HostIP) {

		String result = "";
		
		//System.out.print(getpath());
		String filepath =getpath();
		
		if(fileexists(filepath)==0) {
		
		String fileName = getpath();
		String content = createjson( VMMCode, Secret, MachineEnvironment, VMlevel, WebApp, HostIP);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(content);
			result = "Init File created and content written successfully at : "+filepath;
		} catch (IOException e) {
			e.printStackTrace();
			result = "An error occurred: " + e.getMessage();
		}
	}
		else {
			result = "File Already Exists, Values not updated!";
		}
	
		return result;
	}

}
