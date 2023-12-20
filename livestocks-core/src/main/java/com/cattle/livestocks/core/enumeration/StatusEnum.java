package com.cattle.livestocks.core.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusEnum {
	
	LIVE("LIVE"),
	HISTORY("HIST");
	
	private final String status;
}