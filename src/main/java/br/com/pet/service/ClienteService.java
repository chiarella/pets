package br.com.pet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.pet.dto.ClienteDTO;

@Service
@Transactional
public interface ClienteService {
	
	List<ClienteDTO> buscaTodos();
	
	String save(ClienteDTO dto);
	
	ClienteDTO buscaPorId(Long id);
	
	void update(int id, ClienteDTO cliente);
	
	void delete(Long id);

	ClienteDTO saveObj(ClienteDTO clientDTO);

}
