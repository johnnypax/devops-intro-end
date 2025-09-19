package dev.archety.containerbase.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	@Value("${app.name:ContainerBase}")
	private String appName;
	
	@GetMapping("/hello")
	public String hello() {
		return "Ciao, sono: "  + this.appName;
	}
	
}
