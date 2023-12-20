package com.cattle.livestocks.service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCattleRequest {
	private String animalCode;
	private String animalType;
	private String animalName;
	private Float animalBuyPrice;
	private Float animalSellPrice;
	private String dateOfEntry;
	private String dateOfBirth;
	private String animalInitialWeight;
	private String animalAge;
	private String animalInitialCondition;
	private String animalCompleteness;
}