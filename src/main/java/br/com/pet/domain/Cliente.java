package br.com.pet.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7449936580410661035L;

	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;

	@Column(name = "nameClient")
	private String nameClient;

	@Column(name = "endereco")
	private String address;

	@Column(name = "contact")
	private Long contact;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Pet> pets;
	
//	public static Cliente mapper(Object object) {
//		var result = Cliente.bui
//	}

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

	public List<Pet> getPets() {
		return Collections.unmodifiableList(pets);
		// return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
