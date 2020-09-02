package br.com.pet.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pet.repository.PetsRepository;

public class PetsService {
	
	@Autowired
	private PetsRepository repository;

}
