package com.cattle.livestocks.rest.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cattle.livestocks.core.exception.CattleException;
import com.cattle.livestocks.service.dto.response.CattleInformationResponse;
import com.cattle.livestocks.service.dto.response.DeleteCattleResponse;
import com.cattle.livestocks.service.dto.response.ListCattleResponse;
import com.cattle.livestocks.service.dto.response.RegisterCattleResponse;
import com.cattle.livestocks.service.dto.response.UpdateCattleResponse;
import com.cattle.livestocks.service.dto.response.generic.BaseResponseMessage;
import com.cattle.livestocks.service.interfaces.CattleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("cattle")
public class CattleController {
	@Lazy
	private final CattleService cattleService;

	@PostMapping(path = "/cattle-information", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponseMessage<CattleInformationResponse>> getCattleInformation(
			@RequestBody String request) throws CattleException {
		return new ResponseEntity<>(cattleService.getCattleInformation(request), HttpStatus.OK);
	}

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponseMessage<RegisterCattleResponse>> registerCattle(
			@RequestBody String request) throws CattleException {
		return new ResponseEntity<>(cattleService.registerCattle(request), HttpStatus.OK);
	}

	@PostMapping(path = "/list-cattle", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponseMessage<ListCattleResponse>> listCattle(@RequestBody String request)
			throws CattleException {
		return new ResponseEntity<>(cattleService.listCattle(request), HttpStatus.OK);
	}
	
	@PostMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponseMessage<UpdateCattleResponse>> updateCattle(
			@RequestBody String request) throws CattleException {
		return new ResponseEntity<>(cattleService.updateCattle(request), HttpStatus.OK);
	}
	
	@PostMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponseMessage<DeleteCattleResponse>> deleteCattle(
			@RequestBody String request) throws CattleException {
		return new ResponseEntity<>(cattleService.deleteCattle(request), HttpStatus.OK);
	}
	
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<BaseResponseMessage<ListCattleResponse>> getListCattle()
			throws CattleException {
		return new ResponseEntity<>(cattleService.list(), HttpStatus.OK);
	}
}