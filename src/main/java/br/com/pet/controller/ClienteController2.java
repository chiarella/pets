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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pet.domain.Cliente;
import br.com.pet.service.ClienteService2;

@RestController
@RequestMapping("/api/v1/cliente2")
public class ClienteController2 {

	@Autowired
	private ClienteService2 service;

	@PostMapping(value = "/save")
	public void save(@RequestBody Cliente cliente) {
		service.cadastrarCliente(cliente);
	}

	@PutMapping(value = "/edit/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		return service.updateCliente(id, cliente);
	}

	@ResponseBody
	@GetMapping(value = "/findAll")
	public List<Cliente> findAll() {
		return service.buscarCliente();
	}

	@ResponseBody
	@GetMapping(value = "/findAll2")
	public ResponseEntity<List<Cliente>> buscarTodos() {
		return new ResponseEntity<List<Cliente>>(service.buscarCliente(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		return service.delete(id);
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Cliente> GetById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

}
