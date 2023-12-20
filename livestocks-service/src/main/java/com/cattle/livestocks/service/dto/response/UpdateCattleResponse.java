package com.cattle.livestocks.service.dto.response;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
import com.cattle.livestocks.service.dto.CoreAnimalDto;
import com.cattle.livestocks.service.dto.response.generic.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCattleResponse extends BaseResponse {
	public UpdateCattleResponse(ErrorCodeEnum errorCode, CoreAnimalDto cattleInfo) {
		super(errorCode);
		this.cattleInfo = cattleInfo;
	}

	private CoreAnimalDto cattleInfo;
}