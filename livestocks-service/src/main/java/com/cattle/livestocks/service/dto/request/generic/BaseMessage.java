package com.cattle.livestocks.service.dto.request.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Setter
@Getter
public class BaseMessage<T> {
	private String messageType;
//	private String messageId;
//	private String moduleCode;
//	private String processingCode;
//	private String clientId;
//	private String datetime;
	private T request;
}