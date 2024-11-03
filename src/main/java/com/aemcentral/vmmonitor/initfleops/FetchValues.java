package com.aemcentral.vmmonitor.initfleops;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.aemcentral.vmmonitor.models.InitFile;
import com.google.gson.Gson;

public class FetchValues {

	public static void main(String Args[]) {
		// getosinfo();
		// CreateFile();
		System.out.print(getHostIP());
	}

	public static String getHostIP() {
		String HostIP = "";

		String filepath = Initialise.getpath();
		String input = "";
		if (Initialise.fileexists(filepath) == 1) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					input += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.print(input);

			Gson gson = new Gson();

			// Convert JSON string to Java object
			InitFile initfile = gson.fromJson(input, InitFile.class);

			HostIP = initfile.getHostIP();
		} else {

		}

		return HostIP;
	}
	
	
	public static String getMachineEnv() {
		String MachineEnv = "";

		String filepath = Initialise.getpath();
		String input = "";
		if (Initialise.fileexists(filepath) == 1) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					input += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.print(input);

			Gson gson = new Gson();

			// Convert JSON string to Java object
			InitFile initfile = gson.fromJson(input, InitFile.class);

			MachineEnv = initfile.getMachineEnvironment();
		} else {

		}

		return MachineEnv;
	}

	public static String getWebApp() {
		String WebApp = "";

		String filepath = Initialise.getpath();
		String input = "";
		if (Initialise.fileexists(filepath) == 1) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					input += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.print(input);

			Gson gson = new Gson();

			// Convert JSON string to Java object
			InitFile initfile = gson.fromJson(input, InitFile.class);

			WebApp = initfile.getWebApp();
		} else {

		}

		return WebApp;
	}
	public static String getVMlevel() {
		String VMlevel = "";

		String filepath = Initialise.getpath();
		String input = "";
		if (Initialise.fileexists(filepath) == 1) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					input += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.print(input);

			Gson gson = new Gson();

			// Convert JSON string to Java object
			InitFile initfile = gson.fromJson(input, InitFile.class);

			VMlevel = initfile.getVMlevel();
		} else {

		}

		return VMlevel;
	}
	
	public static String getVMMCode() {
		String VMMCode = "";

		String filepath = Initialise.getpath();
		String input = "";
		if (Initialise.fileexists(filepath) == 1) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					input += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.print(input);

			Gson gson = new Gson();

			// Convert JSON string to Java object
			InitFile initfile = gson.fromJson(input, InitFile.class);

			VMMCode = initfile.getVMMCode();
		} else {

		}

		return VMMCode;
	}
	
	public static String getsecret() {
		String secret = "";

		String filepath = Initialise.getpath();
		String input = "";
		if (Initialise.fileexists(filepath) == 1) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				String line;
				while ((line = reader.readLine()) != null) {
					input += line;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			// System.out.print(input);

			Gson gson = new Gson();

			// Convert JSON string to Java object
			InitFile initfile = gson.fromJson(input, InitFile.class);

			secret = initfile.getSecret();
		} else {

		}

		return secret;
	}
}