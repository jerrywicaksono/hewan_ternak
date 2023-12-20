package com.cattle.livestocks.service.interfaces;

import com.cattle.livestocks.core.exception.CattleException;
import com.cattle.livestocks.service.dto.response.CattleInformationResponse;
import com.cattle.livestocks.service.dto.response.DeleteCattleResponse;
import com.cattle.livestocks.service.dto.response.ListCattleResponse;
import com.cattle.livestocks.service.dto.response.RegisterCattleResponse;
import com.cattle.livestocks.service.dto.response.UpdateCattleResponse;
import com.cattle.livestocks.service.dto.response.generic.BaseResponseMessage;

public interface CattleService {
	BaseResponseMessage<CattleInformationResponse> getCattleInformation(final String request) throws CattleException;
	BaseResponseMessage<RegisterCattleResponse> registerCattle(final String request) throws CattleException;
	BaseResponseMessage<ListCattleResponse> listCattle(final String request) throws CattleException;
	BaseResponseMessage<ListCattleResponse> list() throws CattleException;
	BaseResponseMessage<UpdateCattleResponse> updateCattle(final String request) throws CattleException;
	BaseResponseMessage<DeleteCattleResponse> deleteCattle(final String request) throws CattleException;
}