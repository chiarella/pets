package br.com.pet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.pet.dto.ClienteDTO;

@Service
@Transactional
public interface PetService {
	
	List<ClienteDTO> buscaTodos();
	
	String save(ClienteDTO dto, HttpStatus ok);
	
	ClienteDTO buscaPorId(Long id);
	
	void update(Long id, ClienteDTO cliente);
	
	void delete(Long id);

}
