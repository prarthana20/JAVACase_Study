package com.hexaware.exception;

import java.sql.SQLException;

public class VehicleNotFoundException extends Exception {
	public VehicleNotFoundException(String message) {
		super(message);
		
	}
	public VehicleNotFoundException(String message, SQLException cause) {
        super(message, cause);
	}

}
