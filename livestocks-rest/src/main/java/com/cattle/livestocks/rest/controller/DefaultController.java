package com.cattle.livestocks.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
import com.cattle.livestocks.core.exception.CattleException;
import com.cattle.livestocks.service.dto.response.DefaultResponse;
import com.cattle.livestocks.service.dto.response.generic.BaseResponseMessage;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class DefaultController {
	
	@ExceptionHandler(CattleException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<BaseResponseMessage<DefaultResponse>> handleException(final CattleException e) {
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(new BaseResponseMessage<>(new DefaultResponse(e.getErrorCode())), HttpStatus.OK);
	}
	
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<BaseResponseMessage<DefaultResponse>> handleUnknownError(final Throwable e) {
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(new BaseResponseMessage<>(new DefaultResponse(ErrorCodeEnum.UNKNOWN_ERROR)), HttpStatus.OK);
	}
}