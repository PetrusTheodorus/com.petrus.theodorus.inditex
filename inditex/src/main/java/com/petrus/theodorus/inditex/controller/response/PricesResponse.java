package com.petrus.theodorus.inditex.controller.response;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PricesResponse {

	private Long priceListId;
	private Long brandId;
	private Long productId;
	private Timestamp startDate;
	private Timestamp endDate;
	private BigDecimal price;

}