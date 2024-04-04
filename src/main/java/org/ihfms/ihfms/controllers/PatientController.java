package org.ihfms.ihfms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	
	@PostMapping("/addPatient")
	public String addPatient(){
		return "patients";
	}
	
	@GetMapping("/createPatient")
	public String createPatient(){
		return null;
	}

}
