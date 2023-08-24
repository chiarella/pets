package br.com.pet.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.pet.domain.Cliente;
import br.com.pet.dto.ClienteDTO;
import br.com.pet.mapper.PetMapper;
import br.com.pet.repository.ClienteRepository;
import br.com.pet.service.ClienteService;

@Service
@Transactional
public class ClienteServiceImp implements ClienteService {

	@Autowired
	private PetMapper petMapper;

	@Autowired
	private ClienteRepository repository;

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

	public void update(int id, ClienteDTO cliente) {
		cliente.setIdCliente(id);
		Cliente cliente2 = petMapper.clienteDtoToClienteDomain(cliente);
		repository.save(cliente2);
	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

	public String save(ClienteDTO clientDTO) {
		Cliente clientSaved = petMapper.clienteDtoToClienteDomain(clientDTO);
		repository.save(clientSaved);
		return "[save] - Cadastro efetuado com sucesso.";
	}

	@Override
	public ClienteDTO saveObj(ClienteDTO clientDTO) {
		Cliente clientSaved = petMapper.clienteDtoToClienteDomain(clientDTO);
		repository.save(clientSaved);
		return ClienteDTO.mapper(clientSaved);
	}

}
