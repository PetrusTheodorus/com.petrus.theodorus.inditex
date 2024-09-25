package com.petrus.theodorus.inditex.mapper;

import org.springframework.stereotype.Component;

import com.petrus.theodorus.inditex.controller.response.PricesResponse;
import com.petrus.theodorus.inditex.model.entity.PricesEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PricesEntityMapper {

	/**
	 * Metodo que mapea la entidad al objeto de respuesta.
	 * 
	 * @param pricesEntity Entidad a mapear.
	 * @return Respuesta mapeada.
	 */
	public PricesResponse toPricesResponse(PricesEntity pricesEntity) {
		log.debug("Mapeando PricesEntity recibido: {}", pricesEntity);
		if (pricesEntity == null) {
			return null;
		}

		PricesResponse pricesResponse = new PricesResponse(pricesEntity.getPriceListId(), pricesEntity.getBrandId(),
				pricesEntity.getProductId(), pricesEntity.getStartDate(), pricesEntity.getEndDate(),
				pricesEntity.getPrice());
		log.debug("PricesResponse mapeado: {}", pricesResponse);
		return pricesResponse;
	}

}