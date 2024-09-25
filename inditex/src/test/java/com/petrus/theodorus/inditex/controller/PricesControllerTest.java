package com.petrus.theodorus.inditex.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.petrus.theodorus.inditex.constant.ControllerConstants;
import com.petrus.theodorus.inditex.controller.response.PricesResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
	 * (ZARA)
	 */
	@Test
	public void test1() {
		String uri = ControllerConstants.PRICES_CONTROLLER
				.concat(ControllerConstants.PRICES_CONTROLLER_PRODUCT_PRICE_BY_ID_AND_BRAND_AND_DATE)
				.concat(String.format("?brandId=%s&productId=%s&date=%s", 1, 35455, "2020-06-14-10.00.00"));

		ResponseEntity<PricesResponse> response = restTemplate.getForEntity(uri, PricesResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		PricesResponse pricesResponse = response.getBody();
		assertThat(pricesResponse).isNotNull();
		assertThat(pricesResponse.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(35.50));
	}

	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1
	 * (ZARA)
	 */
	@Test
	public void test2() {
		String uri = ControllerConstants.PRICES_CONTROLLER
				.concat(ControllerConstants.PRICES_CONTROLLER_PRODUCT_PRICE_BY_ID_AND_BRAND_AND_DATE)
				.concat(String.format("?brandId=%s&productId=%s&date=%s", 1, 35455, "2020-06-14-16.00.00"));

		ResponseEntity<PricesResponse> response = restTemplate.getForEntity(uri, PricesResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		PricesResponse pricesResponse = response.getBody();
		assertThat(pricesResponse).isNotNull();
		assertThat(pricesResponse.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(25.45));
	}

	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1
	 * (ZARA)
	 */
	@Test
	public void test3() {
		String uri = ControllerConstants.PRICES_CONTROLLER
				.concat(ControllerConstants.PRICES_CONTROLLER_PRODUCT_PRICE_BY_ID_AND_BRAND_AND_DATE)
				.concat(String.format("?brandId=%s&productId=%s&date=%s", 1, 35455, "2020-06-14-21.00.00"));

		ResponseEntity<PricesResponse> response = restTemplate.getForEntity(uri, PricesResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		PricesResponse pricesResponse = response.getBody();
		assertThat(pricesResponse).isNotNull();
		assertThat(pricesResponse.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(35.50));
	}

	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1
	 * (ZARA)
	 */
	@Test
	public void test4() {
		String uri = ControllerConstants.PRICES_CONTROLLER
				.concat(ControllerConstants.PRICES_CONTROLLER_PRODUCT_PRICE_BY_ID_AND_BRAND_AND_DATE)
				.concat(String.format("?brandId=%s&productId=%s&date=%s", 1, 35455, "2020-06-15-10.00.00"));

		ResponseEntity<PricesResponse> response = restTemplate.getForEntity(uri, PricesResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		PricesResponse pricesResponse = response.getBody();
		assertThat(pricesResponse).isNotNull();
		assertThat(pricesResponse.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(30.50));
	}

	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1
	 * (ZARA)
	 */
	@Test
	public void test5() {
		String uri = ControllerConstants.PRICES_CONTROLLER
				.concat(ControllerConstants.PRICES_CONTROLLER_PRODUCT_PRICE_BY_ID_AND_BRAND_AND_DATE)
				.concat(String.format("?brandId=%s&productId=%s&date=%s", 1, 35455, "2020-06-16-21.00.00"));

		ResponseEntity<PricesResponse> response = restTemplate.getForEntity(uri, PricesResponse.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		PricesResponse pricesResponse = response.getBody();
		assertThat(pricesResponse).isNotNull();
		assertThat(pricesResponse.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(38.95));
	}

}