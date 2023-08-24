package br.com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pet.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	
	@Modifying
	@Query("DELETE FROM Cliente c WHERE c.id = :idCliente")
	void deletarCliente(@Param("id") Long idCliente);
	

}
