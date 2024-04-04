package org.ihfms.ihfms.service;

import org.springframework.stereotype.Component;

@Component
public interface AuthenticationService {
	String loginUser(String username, String Password);
	
}
