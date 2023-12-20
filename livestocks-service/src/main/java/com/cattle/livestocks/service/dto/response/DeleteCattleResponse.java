package com.cattle.livestocks.service.dto.response;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
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
public class DeleteCattleResponse extends BaseResponse {
	public DeleteCattleResponse(ErrorCodeEnum errorCode) {
		super(errorCode);
	}
}