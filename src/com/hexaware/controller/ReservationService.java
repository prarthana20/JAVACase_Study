package com.hexaware.controller;

import com.hexaware.dao.IReservationService;
import com.hexaware.entity.*;
import com.hexaware.exception.*;
import com.hexaware.util.DatabaseConn;
import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.ArrayList;

public class ReservationService implements IReservationService {

	@Override
	public void cancelReservation(int reservationId) throws ReservationException {
	    String sql = "DELETE FROM reservation WHERE reservationid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, reservationId);
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new ReservationException("Reservation with ID " + reservationId + " not found.");
	        }
	    } catch (SQLException e) {
	        throw new ReservationException("Error canceling reservation with ID " + reservationId);
	    }
	}



	@Override
	public boolean createReservation(Reservation reservation) {
	    String sql = "INSERT INTO reservation (reservationid, customerid, vehicleid, startdate, enddate, totalcost, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, reservation.getreservationId());
	        stmt.setCustomer(2, reservation.getcustomerId());
	        stmt.setVehicle(3, reservation.getvehicleId());
	        stmt.setLocalDateTime(4, reservation.getstartDate());
	        stmt.setLocalDateTime(5, reservation.getendDate());
	        stmt.setDouble(6, reservation.gettotalCost());
	        stmt.setString(7, reservation.getsta_tus());

	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}



	@Override
	public Reservation getReservationById(int reservationId) throws ReservationException {
	    String sql = "SELECT * FROM reservation WHERE reservationid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, reservationId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                // Retrieve reservation data from the ResultSet and create a Reservation object
	                Reservation reservation = new Reservation();
	                reservation.setreservationId(rs.getInt("reservationid"));
	                // Set other fields similarly
	                return reservation;
	            } else {
	                throw new ReservationException("Reservation with ID " + reservationId + " not found.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new ReservationException("Error accessing the database");
	    }
	}



	@Override
	System.out.print("Enter Reservation ID to update: ");
    int updateReservationId = scanner.nextInt();
    sc.nextLine(); // Consume newline
    Reservation updatedReservation = IReservationService.getReservationById(updateReservationId);
    if (updatedReservation != null) {
        System.out.print("Enter new Vehicle ID: ");
        updatedReservation.setVehicleID(sc.nextInt());
        System.out.print("Enter new Start Datetime in yyyy/MM/ddTHH:mm:ss format:");
        String userInput = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US);
		LocalDateTime userDateTime = LocalDateTime.parse(userInput, formatter);
        updatedReservation.setStartDate(userDateTime);
        System.out.print("Enter new End Datetime in yyyy/MM/ddTHH:mm:ss format:");
        String userInput1 = sc.next();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US);
		LocalDateTime userDateTime1 = LocalDateTime.parse(userInput1, formatter1);
        updatedReservation.setEndDate(userDateTime1);
       
        reservationDAO.updateReservation(updatedReservation);
        System.out.println("Reservation updated successfully");
    } else {
        System.out.println("Reservation not found");
    }


	@Override
	public void getReservationsByVehicleId() {
		System.out.print("Enter Vehicle ID : ");
	    int vehicleId = scanner.nextInt();
		List<Reservation> allReservations1 = IReservationService.getReservationsByVehicleId(vehicleId);
		    System.out.println("All Vehicle Reservation: " + allReservations1);
	}
	


	@Override
	public void getReservationsByCustomerId() {
		System.out.print("Enter Customer ID : ");
	    int customerId = sc.nextInt();
		List<Reservation> allReservations = reservationDAO.getReservationsByCustomerId(customerId);
		    System.out.println("All Customers Reservation: " + allReservations);
	}

}
