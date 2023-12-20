package com.cattle.livestocks.repository.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.cattle.livestocks.repository.entities.CoreAnimal;
import com.cattle.livestocks.repository.generic.GenericRepository;

import jakarta.persistence.Tuple;

public interface CoreAnimalRepository extends GenericRepository<CoreAnimal, Long>{
	@Query(value = "select ca.* " 
					+ " from core_animal ca "
					+ " where ca.animal_code=:animalCode and ca.status<>'HIST'", nativeQuery = true)
	Optional<CoreAnimal> getByCode(final String animalCode);
	
	@Query(value = "select ca.id, ca.animal_code, ca.animal_type, ca.animal_name, ca.animal_buy_price, ca.animal_sell_price, ca.date_of_entry, ca.date_of_birth, ca.animal_initial_weight, ca.animal_age, ca.animal_initial_condition, ca.animal_completeness from core_animal ca where ca.animal_code=:animalCode and ca.status<>'HIST'", nativeQuery = true)
	Optional<Tuple> getAnimalInfo(final String animalCode);
	
	@Query(value = "select ca.id, ca.animal_code, ca.animal_type, ca.animal_name, ca.animal_buy_price, ca.animal_sell_price, ca.date_of_entry, ca.date_of_birth, ca.animal_initial_weight, ca.animal_age, ca.animal_initial_condition, ca.animal_completeness from core_animal ca where ca.status<>'HIST'", nativeQuery = true)
	Optional<List<Tuple>> getListAnimal();
}