package com.aemcentral.vmmonitor.models;

public class MachineInfo {

	    private String VMMCode;
	    private String VMlevel;
	    private String WebApp;
	    private String MachineEnv;
	    private String OSName;
	    private int CpuCores;
	    
	    private long TotalMemoryMB;
	    private long TotalDiskSpaceGB;
		public MachineInfo(String vMMCode, String vMlevel, String webApp, String machineEnv, String oSName,
				int cpuCores, long totalMemoryMB, long totalDiskSpaceGB) {
			super();
			VMMCode = vMMCode;
			VMlevel = vMlevel;
			WebApp = webApp;
			MachineEnv = machineEnv;
			OSName = oSName;
			CpuCores = cpuCores;
			TotalMemoryMB = totalMemoryMB;
			TotalDiskSpaceGB = totalDiskSpaceGB;
		}
		
}
