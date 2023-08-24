package br.com.pet.dto;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.pet.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.var;

@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class ClienteDTO {

	private int idCliente;
	private String nameClient;
	private String address;
	private Long contact;
	private List<PetDto> pets;
	
	public static ClienteDTO mapper(Cliente entity) {
		var result = ClienteDTO.builder().build();
		BeanUtils.copyProperties(entity, result);
		return result;
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public List<PetDto> getPets() {
		return Collections.unmodifiableList(pets);
		// return pets;
	}

	public void setPets(List<PetDto> pets) {
		this.pets = pets;
	}

}
