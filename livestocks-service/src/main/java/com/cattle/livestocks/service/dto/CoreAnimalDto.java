package com.cattle.livestocks.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.cattle.livestocks.repository.entities.CoreAnimal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Tuple;
import lombok.Getter;
import lombok.Setter;

@Component
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class CoreAnimalDto {
	private Long id;
	private String animalCode;
	private String animalType;
	private String animalName;
	private String animalBuyPrice;
	private String animalSellPrice;
	private String dateOfEntry;
	private String dateOfBirth;
	private String animalInitialWeight;
	private String animalAge;
	private String animalInitialCondition;
	private String animalCompleteness;

	public CoreAnimalDto mappingAnimal(final Tuple data) {
		CoreAnimalDto ca = new CoreAnimalDto();
		ca.setAnimalAge(data.get("animal_age", String.class));
		ca.setAnimalBuyPrice(data.get("animal_buy_price", Float.class).toString().replace(".0", ""));
		ca.setAnimalCode(data.get("animal_code", String.class));
		ca.setAnimalCompleteness(data.get("animal_completeness", String.class));
		ca.setAnimalInitialCondition(data.get("animal_initial_condition", String.class));
		ca.setAnimalInitialWeight(data.get("animal_initial_weight", String.class));
		ca.setAnimalName(data.get("animal_name", String.class));
		ca.setAnimalSellPrice(data.get("animal_sell_price", Float.class).toString().replace(".0", ""));
		ca.setAnimalType(data.get("animal_type", String.class));
		ca.setDateOfBirth(data.get("date_of_birth", Date.class)!=null?data.get("date_of_birth", Date.class).toString():"");
		ca.setDateOfEntry(data.get("date_of_entry", Date.class)!=null?data.get("date_of_entry", Date.class).toString():"");
		ca.setId(data.get("id", Long.class));
		return ca;
	}
	
	public CoreAnimalDto mappingAnimalModel(final CoreAnimal data) {
		CoreAnimalDto ca = new CoreAnimalDto();
		ca.setAnimalAge(data.getAnimalAge());
		ca.setAnimalBuyPrice(String.valueOf(data.getAnimalBuyPrice()).replace(".0", ""));
		ca.setAnimalCode(data.getAnimalCode());
		ca.setAnimalCompleteness(data.getAnimalCompleteness());
		ca.setAnimalInitialCondition(data.getAnimalInitialCondition());
		ca.setAnimalInitialWeight(data.getAnimalInitialWeight());
		ca.setAnimalName(data.getAnimalName());
		ca.setAnimalSellPrice(String.valueOf(data.getAnimalSellPrice()).replace(".0", ""));
		ca.setAnimalType(data.getAnimalType());
		ca.setDateOfBirth(data.getDateOfBirth().toString());
		ca.setDateOfEntry(data.getDateOfEntry().toString());
		ca.setId(data.getId());
		return ca;
	}
	
	public List<CoreAnimalDto> mappingListAnimal(final List<Tuple> data) {
		List<CoreAnimalDto> ca = new ArrayList<>();
		data.forEach(animal -> {
			CoreAnimalDto coreAnimalDto = new CoreAnimalDto();
			coreAnimalDto.setAnimalAge(animal.get("animal_age", String.class));
			coreAnimalDto.setAnimalBuyPrice(animal.get("animal_buy_price", Float.class).toString().replace(".0", ""));
			coreAnimalDto.setAnimalCode(animal.get("animal_code", String.class));
			coreAnimalDto.setAnimalCompleteness(animal.get("animal_completeness", String.class));
			coreAnimalDto.setAnimalInitialCondition(animal.get("animal_initial_condition", String.class));
			coreAnimalDto.setAnimalInitialWeight(animal.get("animal_initial_weight", String.class));
			coreAnimalDto.setAnimalName(animal.get("animal_name", String.class));
			coreAnimalDto.setAnimalSellPrice(animal.get("animal_sell_price", Float.class).toString().replace(".0", ""));
			coreAnimalDto.setAnimalType(animal.get("animal_type", String.class));
			coreAnimalDto.setDateOfBirth(animal.get("date_of_birth", Date.class)!=null?animal.get("date_of_birth", Date.class).toString():"");
			coreAnimalDto.setDateOfEntry(animal.get("date_of_entry", Date.class)!=null?animal.get("date_of_entry", Date.class).toString():"");
			coreAnimalDto.setId(animal.get("id", Long.class));
			ca.add(coreAnimalDto);
		});
		return ca;
	}
	
	public List<CoreAnimalDto> mappingListAnimalStream(final List<Tuple> data) {
		List<CoreAnimalDto> ca = new ArrayList<>();
		Stream<Tuple> anim = data.stream();
		anim.forEach(record ->{
			CoreAnimalDto coreAnimalDto = new CoreAnimalDto();
			coreAnimalDto.setAnimalAge(record.get("animal_age", String.class));
			coreAnimalDto.setAnimalBuyPrice(record.get("animal_buy_price", Float.class).toString().replace(".0", ""));
			coreAnimalDto.setAnimalCode(record.get("animal_code", String.class));
			coreAnimalDto.setAnimalCompleteness(record.get("animal_completeness", String.class));
			coreAnimalDto.setAnimalInitialCondition(record.get("animal_initial_condition", String.class));
			coreAnimalDto.setAnimalInitialWeight(record.get("animal_initial_weight", String.class));
			coreAnimalDto.setAnimalName(record.get("animal_name", String.class));
			coreAnimalDto.setAnimalSellPrice(record.get("animal_sell_price", Float.class).toString().replace(".0", ""));
			coreAnimalDto.setAnimalType(record.get("animal_type", String.class));
			coreAnimalDto.setDateOfBirth(record.get("date_of_birth", Date.class)!=null?record.get("date_of_birth", Date.class).toString():"");
			coreAnimalDto.setDateOfEntry(record.get("date_of_entry", Date.class)!=null?record.get("date_of_entry", Date.class).toString():"");
			coreAnimalDto.setId(record.get("id", Long.class));
			ca.add(coreAnimalDto);
		});
		
		return ca;
	}
}