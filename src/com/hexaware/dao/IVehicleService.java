package com.hexaware.dao;

import com.hexaware.entity.Vehicle;
import com.hexaware.exception.VehicleNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface IVehicleService {
	
	List<Vehicle> getAvailableVehicles();
	boolean removeVehicle(int vehicleId) throws VehicleNotFoundException ;
	void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException, ParseException;
	boolean addVehicle(Vehicle vehicle);
	Vehicle getVehicleById(int vehicleId)throws VehicleNotFoundException;
	//List<Vehicle> getAvailableVehicles() throws SQLException, IOException, VehicleNotFoundException; 
}
