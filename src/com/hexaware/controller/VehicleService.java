package com.hexaware.controller;

import com.hexaware.dao.IVehicleService;
import com.hexaware.entity.Vehicle;
import com.hexaware.exception.*;
import com.hexaware.util.DatabaseConn;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

public class VehicleService implements IVehicleService {

	@Override
	public List<Vehicle> getAvailableVehicles() {
	    List<Vehicle> vehicle = new ArrayList<>();
	    String sql = "SELECT * FROM vehicle WHERE availability = 1";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	    	 ResultSet rs = stmt.executeQuery(); {
	             while (rs.next()) {
	                 vehicle.add(new Vehicle(
	                     rs.getInt("vehicleid"),
	                     rs.getString("model"),
	                     rs.getString("make"),
	                     rs.getInt("ye_ar"),
	                     rs.getString("colour"),
	                     rs.getString("registration_number"),
	                     rs.getBoolean("availability"),
	                     rs.getDouble("daily_rate")
	                     ));
	             }
	    	 }
	    	 } catch (SQLException e) {
	             e.printStackTrace();
	         }
	         return vehicle;
	     }
	/*public List<Vehicle> getAvailableVehicles() throws SQLException, IOException, VehicleNotFoundException {
        List<Vehicle> availableVehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicle WHERE Availability = true";
		try (PreparedStatement statement = DatabaseConn.prepareStatement(sql);
		     ResultSet resultSet = statement.executeQuery()) {
		    while (resultSet.next()) {
		        availableVehicles.add(mapResultSetToVehicle(resultSet));
		    }
		    if(!availableVehicles.isEmpty()) {
		    	return availableVehicles;
		    }
		    else {
		    	throw new VehicleNotFoundException("No vehicles are available right now!");
		    }
		*/


	@Override
	public boolean removeVehicle(int vehicleId) throws VehicleNotFoundException {
	    String sql = "DELETE FROM vehicle WHERE vehicleid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, vehicleId);
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new VehicleNotFoundException("Vehicle with ID " + vehicleId + " not found.");
	        }
	        return true; 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; 
	    }
	}


	@Override
	public void updateVehicle(Vehicle vehicle) throws VehicleNotFoundException, ParseException {
	    String sql = "UPDATE vehicle SET model = ?, make = ?, ye_ar = ?, colour = ?, registration_number = ?, availability = ?, daily_rate = ? WHERE vehicleid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, vehicle.getmodel());
	        stmt.setString(2, vehicle.getmake());
	        stmt.setInt(3, vehicle.getye_ar()); // Assuming ye_ar is of type Year
	        stmt.setString(4, vehicle.getcolour());
	        stmt.setString(5, vehicle.getregistration_number());
	        stmt.setBoolean(6, vehicle.getavailability());
	        stmt.setDouble(7, vehicle.getdaily_rate());
	        stmt.setInt(8, vehicle.getvehicleId());
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new VehicleNotFoundException("No Vehicle found with ID " + vehicle.getvehicleId());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new VehicleNotFoundException("Database access error occurred", e);
	    }
	}
	
	@Override
	public boolean addVehicle(Vehicle vehicle) {
	    String sql = "INSERT INTO vehicle (vehicleid, model, make, ye_ar, colour, registration_number, availability, daily_rate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, vehicle.getvehicleId());
	        stmt.setString(2, vehicle.getmodel());
	        stmt.setString(3, vehicle.getmake());
	        stmt.setInt(4, vehicle.getye_ar()); 
	        stmt.setString(5, vehicle.getcolour());
	        stmt.setString(6, vehicle.getregistration_number());
	        stmt.setBoolean(7, vehicle.getavailability());
	        stmt.setDouble(8, vehicle.getdaily_rate());
	        
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	@Override
	public Vehicle getVehicleById(int vehicleId) throws VehicleNotFoundException {
	    String sql = "SELECT * FROM vehicle WHERE vehicleid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, vehicleId);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Vehicle(
	                    rs.getInt("vehicleid"),
	                    rs.getString("model"),
	                    rs.getString("make"),
	                    rs.getInt("ye_ar"), 
	                    rs.getString("colour"),
	                    rs.getString("registration_number"),
	                    rs.getBoolean("availability"),
	                    rs.getDouble("daily_rate"));
	            } else {
	                throw new VehicleNotFoundException("Vehicle with ID " + vehicleId + " not found.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new VehicleNotFoundException("Error accessing the database", e);
	    }
	}

}
