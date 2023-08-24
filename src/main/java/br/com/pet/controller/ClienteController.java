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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.pet.dto.ClienteDTO;
import br.com.pet.handler.ErrorResponse;
import br.com.pet.service.ClienteService;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping("/saveStr")
	public ResponseEntity<String> saveString(@RequestBody ClienteDTO clienteDTO) throws Exception {
		try {
			return new ResponseEntity<>(service.save(clienteDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(montarObjetoErroResponse(e.getMessage()), HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<ClienteDTO>> buscaTodos() {
		return ResponseEntity.ok(service.buscaTodos());
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<ClienteDTO> GetById(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(service.buscaPorId(id));
	}

	@PutMapping("/edit/{id}")
	public void update(@PathVariable(value = "id") int id, @RequestBody ClienteDTO cliente) {
		service.update(id, cliente);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	private String montarObjetoErroResponse(String errorDescription) {
		Gson gson = new Gson();
		return gson.toJson(new ErrorResponse(errorDescription, HttpStatus.CONFLICT));

	}
}
