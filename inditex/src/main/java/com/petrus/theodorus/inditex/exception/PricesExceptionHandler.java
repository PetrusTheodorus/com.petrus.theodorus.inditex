package com.petrus.theodorus.inditex.exception;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.petrus.theodorus.inditex.controller.response.GenericErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class PricesExceptionHandler {

	/**
	 * Metodo para capturar excepciones PricesException.
	 * 
	 * @param pricesException Excepcion lanzada.
	 * @param request         Peticion recibida.
	 * @return ResponseEntity<ErrorResponse>.
	 */
	@ExceptionHandler(PricesException.class)
	public ResponseEntity<GenericErrorResponse> handlePricesException(PricesException pricesException,
			WebRequest request) {
		log.error("PricesException capturada: {}", pricesException.getMessage(), pricesException);

		HttpStatus status;
		String message = pricesException.getMessage();

		switch (pricesException.getReason()) {
		case NOT_FOUND:
			status = HttpStatus.NOT_FOUND;
			message = "Recurso no encontrado: " + message;
			break;
		case BAD_REQUEST:
			status = HttpStatus.BAD_REQUEST;
			message = "Solicitud incorrecta: " + message;
			break;
		case INTERNAL_ERROR:
		default:
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			message = "Error interno del servidor: " + message;
			break;
		}

		GenericErrorResponse genericErrorResponse = new GenericErrorResponse(status, message,
				new Timestamp(System.currentTimeMillis()));
		return new ResponseEntity<>(genericErrorResponse, status);

	}

	/**
	 * Metodo para la captura de una excepcion generica.
	 *
	 * @param exception Excepcion lanzada.
	 * @param request   Peticion recibida.
	 * @return Una respuesta con un mensaje de error genérico y código de estado
	 *         HTTP 500.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericErrorResponse> handleGeneralException(Exception exception, WebRequest request) {
		log.error("Exception capturada: {}", exception.getMessage(), exception);

		GenericErrorResponse genericErrorResponse = new GenericErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
				"Error interno del servidor", new Timestamp(System.currentTimeMillis()));
		return new ResponseEntity<>(genericErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
