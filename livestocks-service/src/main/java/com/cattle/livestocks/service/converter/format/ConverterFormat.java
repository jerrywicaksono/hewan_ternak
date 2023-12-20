package com.cattle.livestocks.service.converter.format;

import java.util.Date;

public interface ConverterFormat {
	String convertFloatToString(final Float inputAmount);

	Date convertStringToDate(final String inputDate);
}