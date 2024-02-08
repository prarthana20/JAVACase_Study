package com.hexaware.entity;

/**
 * This class represents a Vehicle object.
 * It contains methods to set and get vehicle details.
 */
public class Vehicle {
	
	private int vehicleID;
    private String model;
    private String make;
    private int ye_ar;
    private String colour;
    private String registration_number;
    private boolean availability;
    private double daily_rate;
    
    public Vehicle() {}
    
    public Vehicle(int vehicleID, String model, String make, int ye_ar, String colour,
            String registration_number, boolean availability, double daily_rate) {
    	this.vehicleID = vehicleID;
    	this.model = model;
    	this.make = make;
    	this.ye_ar = ye_ar;
    	this.colour = colour;
    	this.registration_number = registration_number;
    	this.availability = availability;
 		this.daily_rate = daily_rate;
    }

	public int getvehicleId() {
        return vehicleID;
    }
    public void setvehicleId(int vehicleId) {
        this.vehicleID = vehicleId;
    }
    
    public String getmodel() {
        return model;
    }
    public void setmodel(String model) {
        this.model = model;
    }
    
    public String getmake() {
        return make;
    }
    public void setmake(String make) {
        this.make = make;
    }
    
    public int getye_ar() {
        return ye_ar;
    }
    public void setyear(int ye_ar) {
        this.ye_ar = ye_ar;
    }
    
    public String getcolour() {
        return colour;
    }
    public void setcolour(String colour) {
        this.colour = colour;
    }
    
    public String getregistration_number() {
        return registration_number;
    }
    public void setregistration_number(String registration_number) {
        this.registration_number = registration_number;
    }
    
    public boolean getavailability() {
        return availability;
    }
    public void setavailability(boolean availability) {
        this.availability = availability;
    }
    
    public double getdaily_rate() {
        return daily_rate;
    }
    public void setdaily_rate(double daily_rate) {
        this.daily_rate = daily_rate;
    }
    
    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", ye_ar='" + ye_ar + '\'' +
                ", colour='" + colour + '\'' +
                ", registration_number='" + registration_number + '\'' +
                ", availability='" + availability + '\'' +
                ", daily_rate='" + daily_rate + '\'' +
                '}';
    }
}
