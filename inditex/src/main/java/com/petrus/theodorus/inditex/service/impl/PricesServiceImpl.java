package com.petrus.theodorus.inditex.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.petrus.theodorus.inditex.controller.response.PricesResponse;
import com.petrus.theodorus.inditex.exception.PricesException;
import com.petrus.theodorus.inditex.exception.PricesExceptionReasons;
import com.petrus.theodorus.inditex.mapper.PricesEntityMapper;
import com.petrus.theodorus.inditex.model.entity.PricesEntity;
import com.petrus.theodorus.inditex.model.repository.PricesRepository;
import com.petrus.theodorus.inditex.service.PricesService;
import com.petrus.theodorus.inditex.util.DateUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

	private final PricesRepository pricesRepository;
	private final PricesEntityMapper pricesEntityMapper;
	private final DateUtils dateUtils;

	public PricesResponse getProductPriceByIdAndBrandAndDate(Long brandId, Long productId, String date)
			throws PricesException {
		try {
			log.info(
					"Realizando busqueda findByProductPriceByIdAndBrandAndDate con parametros brandId: {}, productId:{}, date:{}",
					brandId, productId, date);
			List<PricesEntity> prices = pricesRepository.findByProductPriceByIdAndBrandAndDate(brandId, productId,
					dateUtils.convertStringToTimestamp(date));

			// Comprobacion de precio
			if (prices.isEmpty()) {
				throw new PricesException(PricesExceptionReasons.NOT_FOUND,
						"No se han encontrado precios para los parametros recibidos");
			}

			return pricesEntityMapper.toPricesResponse(prices.getFirst());
		} catch (ParseException parseException) {
			throw new PricesException(PricesExceptionReasons.BAD_REQUEST, parseException.getMessage(),
					parseException.getCause());
		} catch (PricesException pricesException) {
			throw pricesException;
		} catch (Exception exception) {
			throw new PricesException(PricesExceptionReasons.INTERNAL_ERROR, exception.getMessage(),
					exception.getCause());
		}
	}

}