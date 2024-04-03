package org.ihfms.ihfms.controllers;

import org.ihfms.ihfms.controllers.dtos.AuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AuthenticationController {
	
	@GetMapping("index")
	public String index(){
		return "index";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody AuthenticationRequest request){
		String username = request.getUsername();
		String password = request.getPassword();
		
		return ResponseEntity.ok("Registration Successful "+username);
	}

}
