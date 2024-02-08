package com.hexaware.testing;

import static org.junit.Assert.*;
import com.hexaware.entity.Vehicle;
import com.hexaware.controller.VehicleService;
import org.junit.Test;

public class addingNewVehicle {

    @Test
    public void testAddVehicle() {
        // Create a mock vehicle object to be added
        Vehicle newVehicle = new Vehicle();
        newVehicle.setmodel("Toyota");
        newVehicle.setmake("Camry");
        //newVehicle.setYe_ar(2022);
        newVehicle.setcolour("Black");
        newVehicle.setregistration_number("ABC123");
        newVehicle.setavailability(true);
        newVehicle.setdaily_rate(50.0);

        // Call the method to add the new vehicle
        VehicleService vehicleService = new VehicleService();
        boolean added = vehicleService.addVehicle(newVehicle);

        // Assert that the vehicle is added successfully
        assertTrue("Vehicle should be added", added);

        // Optionally, you can retrieve the added vehicle from the database and assert its values
        // Vehicle retrievedVehicle = vehicleService.getVehicleById(newVehicle.getVehicleId());
        // assertEquals("Toyota", retrievedVehicle.getModel());
        // assertEquals("Camry", retrievedVehicle.getMake());
        // assertEquals(2022, retrievedVehicle.getYear());
        // assertEquals("Black", retrievedVehicle.getColour());
        // assertEquals("ABC123", retrievedVehicle.getRegistrationNumber());
        // assertTrue(retrievedVehicle.getAvailability());
        // assertEquals(50.0, retrievedVehicle.getDailyRate(), 0.01);
    }
}

