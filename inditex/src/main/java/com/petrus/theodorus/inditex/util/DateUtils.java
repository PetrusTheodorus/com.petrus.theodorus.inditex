package com.petrus.theodorus.inditex.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.petrus.theodorus.inditex.constant.DateConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DateUtils {

	/**
	 * Metodo que convierte una fecha en cadena de texto a un timestamp. El formato
	 * esperado (DateConstants.TIMESTAMP_DATE_FORMAT).
	 * 
	 * @param dateString Fecha en cadena.
	 * @return Timestamp
	 * @throws ParseException
	 */
	public Timestamp convertStringToTimestamp(String dateString) throws ParseException {
		log.debug("Formateando fecha recibida: {} a formato {}", dateString, DateConstants.TIMESTAMP_DATE_FORMAT);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateConstants.TIMESTAMP_DATE_FORMAT);
		Date date = simpleDateFormat.parse(dateString);
		return new Timestamp(date.getTime());
	}

}