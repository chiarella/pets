package br.com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pet.domain.Pet;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long>{

	@Modifying
	@Query("DELETE FROM Pet p WHERE p.id = :idPet")
	void deletarPet(@Param("id") Long idPet);

}
