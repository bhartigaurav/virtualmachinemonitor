package com.aemcentral.vmmonitor.models;



public class InitFile {

	   private String VMMCode;
	   private String Secret;
	   private String MachineEnvironment;
	   private String VMlevel;
	   private String WebApp;
	   private String HostIP;

	   

	public InitFile(String vMMCode, String secret, String machineEnvironment, String vMlevel, String webApp,
			String hostIP) {
		super();
		VMMCode = vMMCode;
		Secret = secret;
		MachineEnvironment = machineEnvironment;
		VMlevel = vMlevel;
		WebApp = webApp;
		HostIP = hostIP;
	}

	public String getVMMCode() {
		return VMMCode;
	}

	public void setVMMCode(String vMMCode) {
		VMMCode = vMMCode;
	}

	public String getSecret() {
		return Secret;
	}

	public void setSecret(String secret) {
		Secret = secret;
	}

	public String getMachineEnvironment() {
		return MachineEnvironment;
	}

	public void setMachineEnvironment(String machineEnvironment) {
		MachineEnvironment = machineEnvironment;
	}

	public String getVMlevel() {
		return VMlevel;
	}

	public void setVMlevel(String vMlevel) {
		VMlevel = vMlevel;
	}

	public String getWebApp() {
		return WebApp;
	}

	public void setWebApp(String webApp) {
		WebApp = webApp;
	}

	
	public String getHostIP() {
		return HostIP;
	}

	public void setHostIP(String hostIP) {
		HostIP = hostIP;
	}

	@Override
	public String toString() {
		return "InitFile [VMMCode=" + VMMCode + ", Secret=" + Secret + ", MachineEnvironment=" + MachineEnvironment
				+ ", VMlevel=" + VMlevel + ", WebApp=" + WebApp + "]";
	}
	   
	   
	
}
