package br.com.pet.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.pet.domain.Cliente;
import br.com.pet.dto.ClienteDTO;
import br.com.pet.mapper.PetMapper;
import br.com.pet.repository.PetRepository;

@Service
@Transactional
public class PetServiceImp implements PetService{

	@Autowired
	private PetMapper petMapper;

	@Autowired
	private PetRepository repository;

	public List<ClienteDTO> buscaTodos() {
		List<Cliente> domains = repository.findAll();
		return petMapper.listClienteDomainToListClienteDto(domains);
	}

//	public void save(ClienteDTO dto) {
//		Cliente cliente = petMapper.clienteDtoToClienteDomain(dto);
//		repository.save(cliente);
//	}

	
	
	public ClienteDTO buscaPorId(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		
			return petMapper.clienteDomainToClienteDto(cliente.get());
	}

	public void update(Long id, ClienteDTO cliente) {
		cliente.setIdCliente(id);
		Cliente cliente2 = petMapper.clienteDtoToClienteDomain(cliente);
		repository.save(cliente2);
	}

	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	public String save(ClienteDTO dto, HttpStatus ok) {
		Cliente cliente = petMapper.clienteDtoToClienteDomain(dto);
		repository.save(cliente);
		return "Cadastro efetuado com sucesso.";
	}


	

}
