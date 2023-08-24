package br.com.pet.dto;

import java.io.Serializable;

public class PetDto implements Serializable {

	private static final long serialVersionUID = 9029457982246862270L;

	private Long idPet;
	private String namePet;

	public Long getIdPet() {
		return idPet;
	}

	public void setIdPet(Long idPet) {
		this.idPet = idPet;
	}

	public String getNamePet() {
		return namePet;
	}

	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}

}
