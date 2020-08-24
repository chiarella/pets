package br.com.pet.dto;

import java.util.Collections;
import java.util.List;

public class ClienteDTO {

	private Long idCliente;
	private String nome;
	private String endereco;
	private Long telefone;	
	private List<PetDto> pets;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public List<PetDto> getPets() {
		return Collections.unmodifiableList(pets);
		//return pets;
	}

	public void setPets(List<PetDto> pets) {
		this.pets = pets;
	}

}
