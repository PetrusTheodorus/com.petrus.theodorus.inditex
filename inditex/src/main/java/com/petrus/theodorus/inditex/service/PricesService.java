package com.petrus.theodorus.inditex.service;

import com.petrus.theodorus.inditex.controller.response.PricesResponse;
import com.petrus.theodorus.inditex.exception.PricesException;

public interface PricesService {

	/**
	 * Metodo utilizado para recuperar el precio de un producto concreto de una
	 * marca concreta a una determinada hora.
	 * 
	 * @param brandId   Id de la marca.
	 * @param productId Id del producto.
	 * @param date      Fecha recibida en la peticion.
	 * @return Objeto de respuesta del precio del producto.
	 * @throws PricesException
	 */
	public PricesResponse getProductPriceByIdAndBrandAndDate(Long brandId, Long productId, String date)
			throws PricesException;

}