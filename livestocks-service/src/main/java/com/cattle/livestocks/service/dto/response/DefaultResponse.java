package com.cattle.livestocks.service.dto.response;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;
import com.cattle.livestocks.service.dto.response.generic.BaseResponse;

public class DefaultResponse extends BaseResponse {
	public DefaultResponse(ErrorCodeEnum errorCode) {
		super(errorCode);
	}
}