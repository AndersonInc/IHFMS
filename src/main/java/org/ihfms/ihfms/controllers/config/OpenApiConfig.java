package org.ihfms.ihfms.controllers.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Anderson",
						email = "andersonixon12@gmail.com"
				),
				description = "OpenAPI documentation for ihfms",
				title = "ihfms",
				version = "1.0"
		),
		servers = {
				@Server(
						description = "local host environment",
						url = "http://localhost:8083"
				),
				@Server(
						description = "Production environment",
						url = ""
				)
	}
		//		,
//		security = {
//				@SecurityRequirement(
//						name = "Bearer Auth"
//				)
//		}
)
//@SecurityScheme(
//		name = "Bearer Auth",
//		description = "JWT auth based authentication and authorization",
//		scheme = "bearer",
//		type = SecuritySchemeType.HTTP,
//		bearerFormat = "JWT",
//		in = SecuritySchemeIn.HEADER
//		)
public class OpenApiConfig {

}
