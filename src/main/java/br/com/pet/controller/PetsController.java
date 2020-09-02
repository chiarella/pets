package br.com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.pet.service.PetsService;

@RestController
public class PetsController {
	
	@Autowired
	private PetsService service;
	

}
