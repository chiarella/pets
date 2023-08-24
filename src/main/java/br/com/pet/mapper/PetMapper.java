package br.com.pet.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.pet.domain.Cliente;
import br.com.pet.domain.Pet;
import br.com.pet.dto.ClienteDTO;
import br.com.pet.dto.PetDto;

@Component
public class PetMapper {

	//SAVE
	public Cliente clienteDtoToClienteDomain(ClienteDTO dto) {

		Cliente cliente = new Cliente();
		cliente.setNameClient(dto.getNameClient());
		cliente.setAddress(dto.getAddress());
		cliente.setContact(dto.getContact());

		List<Pet> pets = new ArrayList<>();

		for (PetDto petDto : dto.getPets()) {
			Pet pet = this.petDtoToPetDomain(petDto);
			pet.setCliente(cliente);
			pets.add(pet);
		}

		cliente.setPets(pets);
		return cliente;

	}

	public Pet petDtoToPetDomain(PetDto dto) {
		Pet domain = new Pet();
		domain.setNamePet(dto.getNamePet());
		return domain;
	}

	public List<Cliente> listClienteDtoToListClienteDomain(List<ClienteDTO> listDto) {
		List<Cliente> clientes = new ArrayList<>();
		for (ClienteDTO clienteDto : listDto) {
			Cliente cliente = this.clienteDtoToClienteDomain(clienteDto);
			clientes.add(cliente);
		}
		return clientes;
	}

	public ClienteDTO clienteDomainToClienteDto(Cliente domain) {

		ClienteDTO clienteDto = new ClienteDTO();
		clienteDto.setIdCliente(domain.getIdCliente());
		clienteDto.setNameClient(domain.getNameClient());
		clienteDto.setAddress(domain.getAddress());
		clienteDto.setContact(domain.getContact());

		List<PetDto> pets = new ArrayList<>();

		for (Pet pet : domain.getPets()) {
			PetDto petDto = this.petDomainToPetDto(pet);
			pets.add(petDto);
		}
		clienteDto.setPets(pets);
		return clienteDto;
	}

	public PetDto petDomainToPetDto(Pet domain) {
		PetDto petDto = new PetDto();
		petDto.setIdPet(domain.getIdPet());
		petDto.setNamePet(domain.getNamePet());
		return petDto;
	}

	public List<ClienteDTO> listClienteDomainToListClienteDto(List<Cliente> domains) {
		List<ClienteDTO> listClienteDTOs = new ArrayList<>();
		for (Cliente cliente : domains) {
			ClienteDTO clienteDto = this.clienteDomainToClienteDto(cliente);
			listClienteDTOs.add(clienteDto);
		}
		return listClienteDTOs;

	}

}
