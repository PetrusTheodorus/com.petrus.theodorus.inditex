package com.petrus.theodorus.inditex.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PricesException extends Exception {
	private static final long serialVersionUID = 1L;

	private PricesExceptionReasons reason;

	public PricesException(PricesExceptionReasons reason) {
		this.reason = reason;
	}

	public PricesException(PricesExceptionReasons reason, String message) {
		super(message);
		this.reason = reason;
	}

	public PricesException(PricesExceptionReasons reason, String message, Throwable cause) {
		super(message, cause);
		this.reason = reason;
	}
	
}