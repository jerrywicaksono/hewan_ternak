package com.cattle.livestocks.service.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
import com.cattle.livestocks.core.enumeration.ResponseCodeEnum;
import com.cattle.livestocks.core.exception.CattleException;
import com.cattle.livestocks.core.exception.CattleExceptionNotFound;
import com.cattle.livestocks.repository.entities.CoreAnimal;
import com.cattle.livestocks.repository.repositories.CoreAnimalRepository;
import com.cattle.livestocks.service.converter.format.ConverterFormat;
import com.cattle.livestocks.service.dto.CoreAnimalDto;
import com.cattle.livestocks.service.dto.request.CattleInformationRequest;
import com.cattle.livestocks.service.dto.request.DeleteCattleRequest;
import com.cattle.livestocks.service.dto.request.ListCattleRequest;
import com.cattle.livestocks.service.dto.request.RegisterCattleRequest;
import com.cattle.livestocks.service.dto.request.UpdateCattleRequest;
import com.cattle.livestocks.service.dto.request.generic.BaseMessage;
import com.cattle.livestocks.service.dto.response.CattleInformationResponse;
import com.cattle.livestocks.service.dto.response.DeleteCattleResponse;
import com.cattle.livestocks.service.dto.response.ListCattleResponse;
import com.cattle.livestocks.service.dto.response.RegisterCattleResponse;
import com.cattle.livestocks.service.dto.response.UpdateCattleResponse;
import com.cattle.livestocks.service.dto.response.generic.BaseResponseMessage;
import com.cattle.livestocks.service.interfaces.CattleService;
import com.cattle.livestocks.service.validator.RegisterCattleValidator;
import com.cattle.livestocks.service.validator.UpdateCattleValidator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CattleServiceImpl implements CattleService {

	@Lazy
	private final CoreAnimalRepository coreAnimalRepository;

	@Lazy
	private final CoreAnimalDto coreAnimalDto;
	
	@Lazy
	private final ConverterFormat converterFormat;
	
	@Lazy
	private final RegisterCattleValidator registerCattleValidator;
	
	@Lazy
	private final UpdateCattleValidator updateCattleValidator;

	@Override
	public BaseResponseMessage<CattleInformationResponse> getCattleInformation(final String request) throws CattleException {
		log.info("REQUEST getCattleInformation : "+request);
		final ObjectMapper mapper = new ObjectMapper();
		BaseMessage<CattleInformationRequest> requestMessage = new BaseMessage<>();
		try {
			requestMessage = mapper.readValue(request, new TypeReference<BaseMessage<CattleInformationRequest>>() {
			});
		} catch (JsonProcessingException e) {
			throw new CattleException(ErrorCodeEnum.INVALID_PARAMETER);
		}

		final CattleInformationRequest cattleInformationRequest = requestMessage.getRequest();

		BaseResponseMessage<CattleInformationResponse> responseMessage = new BaseResponseMessage<>();
		
		Tuple data = coreAnimalRepository.getAnimalInfo(cattleInformationRequest.getAnimalCode()).orElseThrow(CattleExceptionNotFound::new);

		CoreAnimalDto coreAnimal = coreAnimalDto.mappingAnimal(data);

		responseMessage.setResponse(new CattleInformationResponse(ErrorCodeEnum.SUCCESS, coreAnimal));
		responseMessage.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());

		return responseMessage;
	}

	@Override
	public BaseResponseMessage<RegisterCattleResponse> registerCattle(String request) throws CattleException {
		log.info("REQUEST registerCattle : "+request);
		final ObjectMapper mapper = new ObjectMapper();
		BaseMessage<RegisterCattleRequest> requestMessage = new BaseMessage<>();
		try {
			requestMessage = mapper.readValue(request, new TypeReference<BaseMessage<RegisterCattleRequest>>() {
			});
		} catch (JsonProcessingException e) {
			throw new CattleException(ErrorCodeEnum.INVALID_PARAMETER);
		}
		
		final RegisterCattleRequest registerCattleRequest = requestMessage.getRequest();

		BaseResponseMessage<RegisterCattleResponse> responseMessage = new BaseResponseMessage<>();
		
		CoreAnimal registerCattle = registerCattleValidator.validate(registerCattleRequest);
		
		CoreAnimalDto coreAnimal = coreAnimalDto.mappingAnimalModel(registerCattle);
		
		responseMessage.setResponse(new RegisterCattleResponse(ErrorCodeEnum.SUCCESS, coreAnimal));
		responseMessage.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
		
		return responseMessage;
	}

	@Override
	public BaseResponseMessage<ListCattleResponse> listCattle(String request) throws CattleException {
		log.info("REQUEST listCattle : "+request);
		final ObjectMapper mapper = new ObjectMapper();
		BaseMessage<ListCattleRequest> requestMessage = new BaseMessage<>();
		try {
			requestMessage = mapper.readValue(request, new TypeReference<BaseMessage<ListCattleRequest>>() {
			});
		} catch (JsonProcessingException e) {
			throw new CattleException(ErrorCodeEnum.INVALID_PARAMETER);
		}
		
		final ListCattleRequest listCattleRequest = requestMessage.getRequest();

		BaseResponseMessage<ListCattleResponse> responseMessage = new BaseResponseMessage<>();
		
		List<Tuple> cattleList = coreAnimalRepository.getListAnimal().orElse(null);
		
		List<CoreAnimalDto> listAnimal = coreAnimalDto.mappingListAnimalStream(cattleList);
		
		responseMessage.setResponse(new ListCattleResponse(ErrorCodeEnum.SUCCESS, listAnimal));
		responseMessage.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
		
		return responseMessage;
	}

	@Override
	public BaseResponseMessage<UpdateCattleResponse> updateCattle(String request) throws CattleException {
		log.info("REQUEST updateCattle : "+request);
		final ObjectMapper mapper = new ObjectMapper();
		BaseMessage<UpdateCattleRequest> requestMessage = new BaseMessage<>();
		try {
			requestMessage = mapper.readValue(request, new TypeReference<BaseMessage<UpdateCattleRequest>>() {
			});
		} catch (JsonProcessingException e) {
			throw new CattleException(ErrorCodeEnum.INVALID_PARAMETER);
		}
		
		final UpdateCattleRequest registerCattleRequest = requestMessage.getRequest();

		BaseResponseMessage<UpdateCattleResponse> responseMessage = new BaseResponseMessage<>();
		
		CoreAnimal registerCattle = updateCattleValidator.validate(registerCattleRequest);
		
		CoreAnimalDto coreAnimal = coreAnimalDto.mappingAnimalModel(registerCattle);
		
		responseMessage.setResponse(new UpdateCattleResponse(ErrorCodeEnum.SUCCESS, coreAnimal));
		responseMessage.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
		
		return responseMessage;
	}

	@Override
	public BaseResponseMessage<DeleteCattleResponse> deleteCattle(String request) throws CattleException {
		log.info("REQUEST deleteCattle : "+request);
		final ObjectMapper mapper = new ObjectMapper();
		BaseMessage<DeleteCattleRequest> requestMessage = new BaseMessage<>();
		try {
			requestMessage = mapper.readValue(request, new TypeReference<BaseMessage<DeleteCattleRequest>>() {
			});
		} catch (JsonProcessingException e) {
			throw new CattleException(ErrorCodeEnum.INVALID_PARAMETER);
		}
		
		final DeleteCattleRequest deleteCattleRequest = requestMessage.getRequest();
		
		BaseResponseMessage<DeleteCattleResponse> responseMessage = new BaseResponseMessage<>();
		
		Tuple data = coreAnimalRepository.getAnimalInfo(deleteCattleRequest.getAnimalCode()).orElseThrow(CattleExceptionNotFound::new);
		
		coreAnimalRepository.deleteById(data.get("id", Long.class));
		
		responseMessage.setResponse(new DeleteCattleResponse(ErrorCodeEnum.SUCCESS));
		responseMessage.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
		
		return responseMessage;
	}

	@Override
	public BaseResponseMessage<ListCattleResponse> list() throws CattleException {
		final ObjectMapper mapper = new ObjectMapper();
		BaseResponseMessage<ListCattleResponse> responseMessage = new BaseResponseMessage<>();
		
		List<Tuple> cattleList = coreAnimalRepository.getListAnimal().orElse(null);
		
		List<CoreAnimalDto> listAnimal = coreAnimalDto.mappingListAnimalStream(cattleList);
		
		responseMessage.setResponse(new ListCattleResponse(ErrorCodeEnum.SUCCESS, listAnimal));
		responseMessage.setResponseCode(ResponseCodeEnum.SUCCESS.getCode());
		
		return responseMessage;
	}
}