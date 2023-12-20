package com.cattle.livestocks.core.exception;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;

import lombok.Getter;

@Getter
public class CattleException extends Exception{
	private static final long serialVersionUID = -9016107033614055978L;
	private final ErrorCodeEnum errorCode;
	
	public CattleException(ErrorCodeEnum errorCode) {
		super(errorCode != null ? errorCode.getFullMsg() : null);
		this.errorCode = errorCode;
	}

	public CattleException(ErrorCodeEnum errorCode, String message) {
		super(errorCode != null ? errorCode.getCode() + " : " + message : message);
		this.errorCode = errorCode != null ? errorCode : null;
	}
}