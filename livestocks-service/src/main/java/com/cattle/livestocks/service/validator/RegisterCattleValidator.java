package com.cattle.livestocks.service.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
import com.cattle.livestocks.core.enumeration.StatusEnum;
import com.cattle.livestocks.core.exception.CattleException;
import com.cattle.livestocks.repository.entities.CoreAnimal;
import com.cattle.livestocks.repository.repositories.CoreAnimalRepository;
import com.cattle.livestocks.service.converter.format.ConverterFormat;
import com.cattle.livestocks.service.dto.request.RegisterCattleRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegisterCattleValidator {
	@Lazy
	private final CoreAnimalRepository coreAnimalRepository;

	@Lazy
	private final ConverterFormat converterFormat;

	public CoreAnimal validate(final RegisterCattleRequest registerCattleRequest) throws CattleException {
		validateData(registerCattleRequest);
		validateDate(registerCattleRequest.getDateOfBirth());
		return saveCattleInformation(registerCattleRequest);
	}

	public void validateData(final RegisterCattleRequest registerCattleRequest) throws CattleException {
		CoreAnimal checkAnimalCode = coreAnimalRepository.getByCode(registerCattleRequest.getAnimalCode()).orElse(null);
		if (checkAnimalCode != null) {
			throw new CattleException(ErrorCodeEnum.DATA_ALREADY_EXIST);
		}
	}

	public void validateDate(final String date) throws CattleException {
		if (isValidDateFormat(date)) {
			if (!isValidDate(date)) {
				throw new CattleException(ErrorCodeEnum.INVALID_DATE);
			}
		} else {
			throw new CattleException(ErrorCodeEnum.INVALID_DATE_FORMAT);
		}
	}

	public CoreAnimal saveCattleInformation(final RegisterCattleRequest request) throws CattleException {
		CoreAnimal coreAnimal = new CoreAnimal();
		coreAnimal.setAnimalAge(request.getAnimalAge());
		coreAnimal.setAnimalBuyPrice(request.getAnimalBuyPrice());
		coreAnimal.setAnimalCode(request.getAnimalCode());
		coreAnimal.setAnimalCompleteness(request.getAnimalCompleteness());
		coreAnimal.setAnimalInitialCondition(request.getAnimalInitialCondition());
		coreAnimal.setAnimalInitialWeight(request.getAnimalInitialWeight());
		coreAnimal.setAnimalName(request.getAnimalName());
		coreAnimal.setAnimalSellPrice(request.getAnimalSellPrice());
		coreAnimal.setAnimalType(request.getAnimalType());
		coreAnimal.setDateOfBirth(converterFormat.convertStringToDate(request.getDateOfBirth()));
		coreAnimal.setDateOfEntry(new Date());
		coreAnimal.setStatus(StatusEnum.LIVE.getStatus());
		coreAnimal = coreAnimalRepository.save(coreAnimal);
		return coreAnimal;

	}

	// Validasi format tanggal
	public static boolean isValidDateFormat(String dateString) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate.parse(dateString, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	// Validasi tanggal yang valid sesuai kalender (termasuk Februari dengan tahun
	// kabisat)
	public static boolean isValidDate(String dateString) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dateString, formatter);
			return date.getDayOfMonth() == Integer.parseInt(dateString.split("-")[2]);
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}