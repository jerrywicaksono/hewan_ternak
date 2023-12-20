package com.cattle.livestocks.core.exception;

import com.cattle.livestocks.core.enumeration.ErrorCodeEnum;

public class CattleExceptionNotFound extends CattleException{
	private static final long serialVersionUID = 5791230119088572883L;

	public CattleExceptionNotFound() {
		super(ErrorCodeEnum.DATA_NOT_FOUND);
	}
}