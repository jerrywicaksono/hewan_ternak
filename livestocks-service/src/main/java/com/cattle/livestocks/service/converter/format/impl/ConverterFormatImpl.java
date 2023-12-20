package com.cattle.livestocks.service.converter.format.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.cattle.livestocks.service.converter.format.ConverterFormat;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConverterFormatImpl implements ConverterFormat {

	@Override
	public String convertFloatToString(Float inpuAmount) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String stringAmount = decimalFormat.format(inpuAmount);
		return stringAmount;
	}

	@Override
	public Date convertStringToDate(String inputDate) {
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}
}