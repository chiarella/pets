package br.com.pet.dto;

import java.io.Serializable;

public class PetDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9029457982246862270L;

	private Long idPet;
	private String nome;

	public Long getIdPet() {
		return idPet;
	}

	public void setIdPet(Long idPet) {
		this.idPet = idPet;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
