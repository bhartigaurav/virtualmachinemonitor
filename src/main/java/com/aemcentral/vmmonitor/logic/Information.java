package com.aemcentral.vmmonitor.logic;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
//import java.lang.management.OperatingSystemMXBean;
import java.util.Properties;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

import oshi.hardware.HardwareAbstractionLayer;

import com.aemcentral.vmmonitor.models.MachineInfo;
import com.aemcentral.vmmonitor.initfleops.FetchValues;
import com.aemcentral.vmmonitor.models.CurrentStatus;
import com.google.gson.Gson;

import com.sun.management.OperatingSystemMXBean;

public class Information {

	public static void main(String Args[]) {
		// CurrentStatus();
		statCpu();
	}

	public static String result(int CpuLoadPercentage, int PercentageMemoryUse, int PercentageDiskUse) {
		String result = "metrics under control";

		// join
		if (CpuLoadPercentage > 90 && PercentageMemoryUse > 90 && PercentageDiskUse > 90) {
			result = "all metrics above 90";
		}

		// double values
		else if (PercentageMemoryUse > 90 && PercentageDiskUse > 90) {
			result = "memory and disk above 90";
		}

		else if (CpuLoadPercentage > 90 && PercentageMemoryUse > 90) {
			result = "cpu and memory above 90";
		}

		else if (CpuLoadPercentage > 90 && PercentageDiskUse > 90) {
			result = "cpu and disk above 90";
		}

		// individual
		else if (CpuLoadPercentage > 90) {
			result = "cpu above 90";
		}

		else if (PercentageMemoryUse > 90) {
			result = "memory above 90";
		}

		else if (PercentageDiskUse > 90) {
			result = "disk above 90";
		}

		return result;

	}

	public static int statCpu() {
		int cpu = 0;
		SystemInfo systemInfo = new SystemInfo();
		com.sun.management.OperatingSystemMXBean osBean = ManagementFactory
				.getPlatformMXBean(OperatingSystemMXBean.class);

		cpu = (int) Math.round(osBean.getSystemCpuLoad() * 100.00);
		return cpu;
	}

	public static String CurrentStatus() {

		// read from INIT file (JSON)
		String VMMCode = FetchValues.getVMMCode();

		@SuppressWarnings("unused")
		Properties properties = System.getProperties();

		float totalMemoryMB = 0;
		float availableMemoryMB = 0;

		try {
			SystemInfo systemInfo = new SystemInfo();

			GlobalMemory memory = systemInfo.getHardware().getMemory();

			// Memory information changed to mb
			totalMemoryMB = memory.getTotal() / (1024 * 1024);
			availableMemoryMB = memory.getAvailable() / (1024 * 1024);

		} catch (Exception e) {
			System.out.print("Exception Handled!");
			e.printStackTrace();
		}

		float MemoryinuseMB = totalMemoryMB - availableMemoryMB;
		int percentagememoryuse = (int) ((float) MemoryinuseMB / (float) totalMemoryMB * 100);

		// Disk information
		File diskPartitionGB = new File("/");
		long totalDiskSpaceGB = diskPartitionGB.getTotalSpace() / (1024 * 1024 * 1024);
		long freeDiskSpaceGB = diskPartitionGB.getFreeSpace() / (1024 * 1024 * 1024);

		long DiskSpaceinuseGB = totalDiskSpaceGB - freeDiskSpaceGB;

		int percentagediskuse = (int) ((double) DiskSpaceinuseGB / (double) totalDiskSpaceGB * 100);

		int CpuLoadPercentage = statCpu();
		String webappresult = result(CpuLoadPercentage, percentagememoryuse, percentagediskuse);

		CurrentStatus cs = new CurrentStatus(VMMCode, CpuLoadPercentage, totalMemoryMB, MemoryinuseMB,
				percentagememoryuse, totalDiskSpaceGB, DiskSpaceinuseGB, percentagediskuse, webappresult);

		// Create Json and return
		Gson gson = new Gson();
		String json = gson.toJson(cs);

		return json;
	}

	public static String VM() {

		// read from INIT file (JSON)
		String VMMCode = FetchValues.getVMMCode();// "vmx1";
		String VMlevel = FetchValues.getVMlevel();// "critical";
		String WebApp = FetchValues.getWebApp();// "LogSmith";
		String MachineEnv = FetchValues.getMachineEnv();// "PROD";

		Properties properties = System.getProperties();

		// Operating System information
		String OSName = properties.getProperty("os.name");

		SystemInfo systemInfo = new SystemInfo();
		CentralProcessor processor = systemInfo.getHardware().getProcessor();
		GlobalMemory memory = systemInfo.getHardware().getMemory();

		// CPU information
		int cpuCores = processor.getLogicalProcessorCount();

		// Memory information
		long totalMemoryMB = memory.getTotal() / (1024 * 1024);

		// Disk information
		File diskPartitionGB = new File("/");
		long totalDiskSpaceGB = diskPartitionGB.getTotalSpace() / (1024 * 1024 * 1024);

		// Creating Model object
		MachineInfo machineInfo = new MachineInfo(VMMCode, VMlevel, WebApp, MachineEnv, OSName, cpuCores, totalMemoryMB,
				totalDiskSpaceGB);

		Gson gson = new Gson();
		String json = gson.toJson(machineInfo);

		return json;
	}

}
