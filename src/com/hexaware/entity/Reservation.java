package com.hexaware.entity;

import java.time.LocalDateTime;

public class Reservation {
	
	private int reservationID;
    private Customer customerID;
    private Vehicle vehicleID;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double totalCost;
    private String sta_tus;
    
    public Reservation() {}
    
    public Reservation(int reservationID, Customer customerID, Vehicle vehicleID, LocalDateTime startDate,
            LocalDateTime endDate, double totalCost, String sta_tus) {
    	this.reservationID = reservationID;
    	this.customerID = customerID;
    	this.vehicleID = vehicleID;
    	this.startDate = startDate;
    	this.endDate = endDate;
    	this.totalCost = totalCost;
    	this.sta_tus = sta_tus;
    	
    }
    
    public int getreservationId() {
        return reservationID;
    }
    public void setreservationId(int reservationId) {
        this.reservationID = reservationId;
    }
    
    public Customer getcustomerId() {
        return customerID;
    }
    public void setcustomerId(Customer customerId) {
        this.customerID = customerId;
    }
    
    public Vehicle getvehicleId() {
        return vehicleID;
    }
    public void setvehicleId(Vehicle vehicleId) {
        this.vehicleID = vehicleId;
    }
    
    public LocalDateTime getstartDate() {
        return startDate;
    }
    public void setstartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    
    public LocalDateTime getendDate() {
        return endDate;
    }
    public void setendDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    
    public double gettotalCost() {
        return totalCost;
    }
    public void settotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    
    public String getsta_tus() {
        return sta_tus;
    }
    public void setsta_tus(String sta_tus) {
        this.sta_tus = sta_tus;
    }
    	
    public double calculateTotalCost(double distanceTraveled, double ratePerKm) {
        return distanceTraveled * ratePerKm;
    }


}
