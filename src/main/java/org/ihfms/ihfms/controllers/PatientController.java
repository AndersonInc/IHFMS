package org.ihfms.ihfms.controllers;

import lombok.RequiredArgsConstructor;
import org.ihfms.ihfms.controllers.dtos.PatientRequest;
import org.ihfms.ihfms.service.PatientService;
import org.ihfms.ihfms.service.PatientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
	private final PatientService service;
	
	
	@PostMapping("/addPatient")
	public String addPatient(){
		return "patients";
	}
	
	@PostMapping("/createPatient")
	public String createPatient(@RequestBody PatientRequest request)
	{
		service.createPatient(request);
		return null;
	}

}
