package br.com.pet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pet.domain.Cliente;

@Service
@Transactional
public interface ClienteService2 {
	
	void cadastrarCliente(Cliente cliente);
	
	List<Cliente> buscarCliente();
		
	ResponseEntity<Object> delete(Long id);
		
	ResponseEntity<Cliente> updateCliente(Long id, Cliente cliente);

	ResponseEntity<Cliente> findById(Long id);

}
