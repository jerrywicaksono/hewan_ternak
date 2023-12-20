package com.cattle.livestocks.service.dto.response.generic;

import java.util.List;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class BaseResponse {
	private String errorCode = ErrorCodeEnum.SUCCESS.getCode();
	private String errorMessage = ErrorCodeEnum.SUCCESS.getDefaultMsg();
	private List<String> detail;

	public BaseResponse(ErrorCodeEnum errorCode) {
		this.errorCode = errorCode.getCode();
		this.errorMessage = errorCode.getDefaultMsg();
	}
}