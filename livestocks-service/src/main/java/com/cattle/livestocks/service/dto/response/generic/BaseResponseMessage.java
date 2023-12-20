package com.cattle.livestocks.service.dto.response.generic;

import com.cattle.livestocks.core.enumeration.ResponseCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Setter
@Getter
@NoArgsConstructor
public class BaseResponseMessage <P> {

	private String responseCode = ResponseCodeEnum.ERROR.getCode();
	private P response;
	
	public BaseResponseMessage(P response) {
		this.response = response;
	}
}