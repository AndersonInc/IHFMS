package org.ihfms.ihfms.controllers;

import lombok.AllArgsConstructor;
import org.ihfms.ihfms.controllers.dtos.AuthenticationRequest;
import org.ihfms.ihfms.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class AuthenticationController {
	private final AuthenticationService service;
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	@PostMapping("login")
	@ResponseBody
	public String login(@RequestParam("user_name") String username,
			@RequestParam("password") String password){
		
		 service.loginUser(username,password);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(){
		return "dashboard";
	}
	
	

}
