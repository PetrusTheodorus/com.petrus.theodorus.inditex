package com.petrus.theodorus.inditex.model.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRICES")
public class PricesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRICE_LIST")
	private Long priceListId;

	@Column(name = "BRAND_ID")
	private Long brandId;

	@Column(name = "START_DATE")
	private Timestamp startDate;

	@Column(name = "END_DATE")
	private Timestamp endDate;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRIORITY")
	private Long priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private String currency;

}