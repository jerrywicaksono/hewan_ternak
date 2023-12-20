package com.cattle.livestocks.core.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseCodeEnum {
	
	SUCCESS("00"),
	ERROR("06"),
	INPROCESS("09");
	
	private final String code;
}