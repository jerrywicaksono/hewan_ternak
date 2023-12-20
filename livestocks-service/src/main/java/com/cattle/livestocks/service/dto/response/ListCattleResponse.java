package com.cattle.livestocks.service.dto.response;

import java.util.List;

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
public class ListCattleResponse extends BaseResponse{

	public ListCattleResponse(ErrorCodeEnum errorCode, List<CoreAnimalDto> liveStocksList) {
		super(errorCode);
		this.liveStocksList = liveStocksList;
	}
	
	private List<CoreAnimalDto> liveStocksList;
}