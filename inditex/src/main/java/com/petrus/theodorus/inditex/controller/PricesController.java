package com.petrus.theodorus.inditex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petrus.theodorus.inditex.constant.ControllerConstants;
import com.petrus.theodorus.inditex.controller.response.PricesResponse;
import com.petrus.theodorus.inditex.exception.PricesException;
import com.petrus.theodorus.inditex.service.PricesService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ControllerConstants.PRICES_CONTROLLER)
public class PricesController {

	private final PricesService pricesService;

	@GetMapping(value = ControllerConstants.PRICES_CONTROLLER_PRODUCT_PRICE_BY_ID_AND_BRAND_AND_DATE)
	public ResponseEntity<PricesResponse> productPriceByIdAndBrandAndDate(@RequestParam("brandId") Long brandId,
			@RequestParam("productId") Long productId, @RequestParam("date") String date) throws PricesException {
		try {
			log.info(
					"Peticion recibida en getProductPriceByIdAndBrandAndDate con parametros brandId: {}, productId:{}, date:{}",
					brandId, productId, date);
			PricesResponse pricesResponse = pricesService.getProductPriceByIdAndBrandAndDate(brandId, productId, date);

			log.info("Peticion respondida en getProductPriceByIdAndBrandAndDate: {}", pricesResponse);
			return ResponseEntity.ok(pricesResponse);
		} catch (PricesException pricesException) {
			log.error("Error en getProductPriceByIdAndBrandAndDate {}", pricesException.getMessage(), pricesException);
			throw pricesException;
		}
	}

}