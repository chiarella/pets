package br.com.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.pet.dto.ClienteDTO;
import br.com.pet.handler.ErrorResponse;
import br.com.pet.service.PetServiceImp;

@RestController
public class PetController {

	@Autowired
	private PetServiceImp service;

//	@PostMapping("/save")
//	public void save(@RequestBody ClienteDTO cliente) {
//		service.save(cliente);
//	}


	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody ClienteDTO cliente) throws Exception {
		//br.com.pet.dto.ClienteDTO cliente;
		
		try {
			//br.com.pet.dto.ClienteDTO cliente;
			return new ResponseEntity<>(service.save(cliente, null), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(montarObjetoErroResponse(e.getMessage()), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ClienteDTO>> buscaTodos() {
		return ResponseEntity.ok(service.buscaTodos());
	}

//	@GetMapping("/findById/{id}")
//	public ResponseEntity<ClienteDTO> GetById(@PathVariable(value = "id") Long id){
//		return  ResponseEntity.ok(service.buscaPorId(id));
//	}//404

	
	@GetMapping("/findById/{id}")
	public ResponseEntity<ClienteDTO> GetById(@PathVariable(value = "id") Long id){
		return ResponseEntity.ok(service.buscaPorId(id));
	}//404
	
	@PutMapping("/edit/{id}")
	public void update(@PathVariable(value = "id") Long id, @RequestBody ClienteDTO cliente){
		service.update(id, cliente);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	private String montarObjetoErroResponse(String errorDescription) {
		Gson gson = new Gson();
		return gson.toJson(new ErrorResponse(errorDescription, HttpStatus.CONFLICT));
		
	}
}
