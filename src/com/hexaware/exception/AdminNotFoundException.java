package com.hexaware.exception;

import java.sql.SQLException;

public class AdminNotFoundException extends Exception{
	public AdminNotFoundException(String message) {
		super(message);
		
	}
	
	public AdminNotFoundException(String message, SQLException cause) {
        super(message, cause);
	}

}