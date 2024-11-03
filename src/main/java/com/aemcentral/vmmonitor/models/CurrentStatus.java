package com.aemcentral.vmmonitor.models;

public class CurrentStatus {

	    private String VMMCode;
	   private int CpuLoadPercentage;
	    
	    private double TotalMemoryMB;
	    private double MemoryinuseMB;
	    private int PercentageMemoryUse;
	    
	    private long TotalDiskSpaceGB;
	    private long DiskSpaceinUseGB;
	    private int PercentageDiskUse;
	    
	    private String Status;

		public CurrentStatus(String vMMCode, int cpuLoadPercentage, double totalMemoryMB, double memoryinuseMB,
				int percentageMemoryUse, long totalDiskSpaceGB, long diskSpaceinUseGB, int percentageDiskUse,
				String status) {
			super();
			VMMCode = vMMCode;
			CpuLoadPercentage = cpuLoadPercentage;
			TotalMemoryMB = totalMemoryMB;
			MemoryinuseMB = memoryinuseMB;
			PercentageMemoryUse = percentageMemoryUse;
			TotalDiskSpaceGB = totalDiskSpaceGB;
			DiskSpaceinUseGB = diskSpaceinUseGB;
			PercentageDiskUse = percentageDiskUse;
			Status = status;
		}

		
}

