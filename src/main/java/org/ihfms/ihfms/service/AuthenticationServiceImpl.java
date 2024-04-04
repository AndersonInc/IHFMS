package org.ihfms.ihfms.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Override
	public String loginUser(String username, String Password) {
		
		return username;
	}
}
