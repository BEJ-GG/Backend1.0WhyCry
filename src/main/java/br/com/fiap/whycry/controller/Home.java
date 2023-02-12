package br.com.fiap.whycry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@RequestMapping("/")
	public String home() {
		return "Bem vindo ao WhyCry - API REST .....";
	}

}
