package com.aemcentral.vmmonitor.controller;

import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.aemcentral.vmmonitor.logic.*;

import com.aemcentral.vmmonitor.models.InitialiseBody;
import com.aemcentral.vmmonitor.initfleops.FetchValues;
import com.aemcentral.vmmonitor.initfleops.Initialise;
import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

	@GetMapping("/remotemachine/system/check")
	public ResponseEntity<String> acknowledge(HttpServletRequest request) {
		// Logg.writetofile("System Check - Working as Expected", 1);
		String hostop = "Host Address does not match";
		if (request.getRemoteAddr().equals(FetchValues.getHostIP())) {
			hostop = "Host Address match";
		}
		System.out.println(request.getRemoteAddr());

		return ResponseEntity.status(200).body("Acknowledged | System is up and Working | " + hostop);
	}

	@GetMapping("/remotemachine/{secret}/information")
	public ResponseEntity<String> Information(@PathVariable("secret") String secret, HttpServletRequest request) {
		int status = 403;
		String output = "Invalid Secret";

		if (request.getRemoteAddr().equals(FetchValues.getHostIP())) {
			if (FetchValues.getsecret().equals(secret)) {
				// Secret Validation from Init File
				status = 200;
				output = Information.VM();
			}

		}

		else {
			output = "Host Address does not match!";
		}

		return ResponseEntity.status(status).body(output);
	}

	@GetMapping("/remotemachine/{secret}/monitoring/currentstats")
	public ResponseEntity<String> CurrentStats(@PathVariable("secret") String secret, HttpServletRequest request) {
		int status = 403;
		String output = "Invalid Secret";

		if (request.getRemoteAddr().equals(FetchValues.getHostIP())) {
			if (FetchValues.getsecret().equals(secret)) {
				// Secret Validation from Init File
				status = 200;
				output = Information.CurrentStatus();
			}
		}
		else {
			output = "Host Address does not match!";
		}
		// Secret Validation from Init File
		return ResponseEntity.status(status).body(output);
	}

	@PostMapping(value = "/remotemachine/Initialise", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<String> Initialise(@RequestBody InitialiseBody detail, HttpServletRequest request) {

		// Get Json Response and create init file
		String VMMCode = detail.getVMMCode();
		String hostip = request.getRemoteAddr();
		String Secret = detail.getSecret();
		String MachineEnvironment = detail.getMachineEnvironment();
		String VMlevel = detail.getVMlevel();
		String WebApp = detail.getWebApp();

		String result = Initialise.CreateFile(VMMCode, Secret, MachineEnvironment, VMlevel, WebApp, hostip);

		return ResponseEntity.status(200).body(result);
	}

}
