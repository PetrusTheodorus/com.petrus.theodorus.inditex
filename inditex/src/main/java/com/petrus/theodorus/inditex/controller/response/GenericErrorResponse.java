package com.petrus.theodorus.inditex.controller.response;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase para representar la respuesta de error enviada al cliente.
 */
@Data
@AllArgsConstructor
public class GenericErrorResponse {

	private HttpStatus status;
	private String message;
	private Timestamp timestamp;

}