package com.cattle.livestocks.service.validator;

import java.util.Date;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
import com.cattle.livestocks.core.enumeration.StatusEnum;
import com.cattle.livestocks.core.exception.CattleException;
import com.cattle.livestocks.repository.entities.CoreAnimal;
import com.cattle.livestocks.repository.repositories.CoreAnimalRepository;
import com.cattle.livestocks.service.dto.request.UpdateCattleRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateCattleValidator {
	@Lazy
	private final CoreAnimalRepository coreAnimalRepository;
	
	CoreAnimal coreAnimal = null;

	public CoreAnimal validate(final UpdateCattleRequest updateCattleRequest) throws CattleException {
		validateData(updateCattleRequest);
		return saveCattleInformation(updateCattleRequest);
	}

	public void validateData(final UpdateCattleRequest updateCattleRequest) throws CattleException {
		coreAnimal = coreAnimalRepository.getByCode(updateCattleRequest.getAnimalCode()).orElse(null);
		if (coreAnimal == null) {
			throw new CattleException(ErrorCodeEnum.DATA_NOT_FOUND);
		}
		
		if (!coreAnimal.getAnimalCode().equals(updateCattleRequest.getAnimalCode())) {
			throw new CattleException(ErrorCodeEnum.DATA_NOT_MATCH);
		}
	}

	public CoreAnimal saveCattleInformation(final UpdateCattleRequest request) throws CattleException {
		coreAnimal.setAnimalAge(request.getAnimalAge());
		coreAnimal.setAnimalBuyPrice(request.getAnimalBuyPrice());
		coreAnimal.setAnimalCode(request.getAnimalCode());
		coreAnimal.setAnimalCompleteness(request.getAnimalCompleteness());
		coreAnimal.setAnimalInitialCondition(request.getAnimalInitialCondition());
		coreAnimal.setAnimalInitialWeight(request.getAnimalInitialWeight());
		coreAnimal.setAnimalName(request.getAnimalName());
		coreAnimal.setAnimalSellPrice(request.getAnimalSellPrice());
		coreAnimal.setAnimalType(request.getAnimalType());
		coreAnimal.setDateOfBirth(new Date());
		coreAnimal.setDateOfEntry(new Date());
		coreAnimal.setStatus(StatusEnum.LIVE.getStatus());
		coreAnimal = coreAnimalRepository.save(coreAnimal);
		return coreAnimal;

	}
}