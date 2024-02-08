package com.hexaware.exception;

import java.sql.SQLException;

public class CustomerNotFoundException extends Exception {
		public CustomerNotFoundException(String message) {
			super(message);
		}
		public CustomerNotFoundException(String message, SQLException cause) {
	        super(message, cause);
		}
}
