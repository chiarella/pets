package br.com.pet.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pet.domain.Cliente;
import br.com.pet.repository.ClienteRepository;
import br.com.pet.service.ClienteService2;

@Service
@Transactional
public class ClienteService2Impl implements ClienteService2 {

	@Autowired
	private ClienteRepository repository;

	@Override
	public void cadastrarCliente(Cliente cliente) {
//		for (Pet petz : cliente.getPets()) {
//			petz.setCliente(cliente);
//		}
		repository.save(cliente);
	}

	@Override
	public List<Cliente> buscarCliente() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Object> delete(Long id) {

		Optional<Cliente> cliente = repository.findById(id);
		if (cliente.isPresent()) {
			repository.delete(cliente.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Cliente> updateCliente(Long id, Cliente newCliente) {

		Optional<Cliente> clienteOld = repository.findById(id);

		if (clienteOld.isPresent()) {
			Cliente cliente = clienteOld.get();
//			cliente.setNome(newCliente.getNome());
//			cliente.setEndereco(newCliente.getEndereco());
//			cliente.setTelefone(newCliente.getTelefone());
			repository.save(cliente);
			return new ResponseEntity<Cliente>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Cliente> findById(Long id) {

		Optional<Cliente> cliente = repository.findById(id);
		if (cliente.isPresent())
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
