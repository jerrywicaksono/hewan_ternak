package com.cattle.livestocks.core.enumeration;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum {
	SUCCESS("1000", "Successful", "Berhasil."),
	PARSING_ERROR("1001", "Incorrect parameter format", "Format parameter salah."),
	INVALID_PARAMETER("1002", "Invalid parameter", "Parameter tidak sesuai."),
	INCOMPLETE_FIELD("1003", "Missing mandatory field", "Kolom wajib tidak ditemukan."),
	INVALID_DATE("1004", "Invalid date", "Tanggal tidak valid."),
	INVALID_DATE_FORMAT("1005", "Invalid date format", "Format tanggal tidak Valid."),
	DATA_NOT_FOUND("2000", "Data Not Found", "Data tidak ditemukan."),
	DATA_ALREADY_EXIST("2001", "Data Already Exist", "Data sudah ada."),
	DATA_NOT_MATCH("2002", "Data Not Match", "Data tidak sama."),
	UNKNOWN_ERROR("9999", "Unknown Error", "Error tidak dikenal");

	private final String code;
	private final String defaultMsg;
	private final String localeMsg;
	
	private static final Map<String, ErrorCodeEnum> lookup = new HashMap<>();
	
	static {
        for (ErrorCodeEnum d : ErrorCodeEnum.values()) {
            lookup.put(d.getCode(), d);
        }
    }
	
	public String getFullMsg(){
		return code + " : " + defaultMsg;
	}
	
	public static ErrorCodeEnum get(String code){
		return lookup.get(code);
	}
}