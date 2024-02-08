package com.hexaware.main;

import java.util.Scanner;
import com.hexaware.controller.VehicleService;
import com.hexaware.dao.IVehicleService;
import com.hexaware.entity.Vehicle;
import com.hexaware.exception.VehicleNotFoundException;
import java.util.List;
import java.text.ParseException;
import java.time.Year;

public class VehicleView {
	public VehicleView() {}
    static Scanner scanner = new Scanner(System.in);
    private static IVehicleService vehicleService = new VehicleService();
    public VehicleView(IVehicleService vehicleService) {
        VehicleView.vehicleService = vehicleService;
    }
    public void displayMenu() throws VehicleNotFoundException {
    	while(true) {
            System.out.println("Enter your choice");
            System.out.println("1. View Vehicle By ID");
            System.out.println("2. View Availabel Vehicles");
            System.out.println("3. Add Vehicle");
            System.out.println("4. Update Vehicle");
            System.out.println("5. Remove Vehicle");
            
            int choice = scanner.nextInt();
       
            switch (choice) {
                case 1:
                    getVehicleById(vehicleService,scanner);
                    break;
                case 2:
                    getAvailabelVehicles(vehicleService,scanner);
                    break;
                case 3:
                    addVehicle(vehicleService,scanner);
                    break;
                case 4:
				try {
					updateVehicle(vehicleService,scanner);
				} catch (VehicleNotFoundException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
                    break;
                case 5:
                    removeVehicle(vehicleService,scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
                }
            	System.out.println("Press Enter to continue");
            	scanner.nextLine();
    		}
        }

	private void getAvailabelVehicles(IVehicleService vehicleService2, Scanner scanner2) {
		List<Vehicle> vehicles = vehicleService.getAvailableVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No Available Vehicle found.");
        } else {
            System.out.println("Available Vehicles:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
	}
	
	private void removeVehicle(IVehicleService vehicleService, Scanner scanner) {
	    System.out.print("Enter Vehicle ID to delete: ");
	    int vehicleId = scanner.nextInt();
	    try {
	        boolean removed = vehicleService.removeVehicle(vehicleId);
	        if (removed) {
	            System.out.println("Vehicle deleted successfully.");
	        } else {
	            System.out.println("Failed to delete vehicle.");
	        }
	    } catch (VehicleNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	}


	private void updateVehicle(IVehicleService vehicleService2, Scanner scanner2) throws VehicleNotFoundException, ParseException {
		System.out.print("Enter Vehicle ID to update: ");
	    int vehicleId = scanner.nextInt();
	    scanner.nextLine();
	    System.out.print("Enter new Model: ");
	    String model = scanner.nextLine();
	    System.out.print("Enter new Make: ");
	    String make = scanner.nextLine();
	    System.out.print("Enter new Year: "); 
	    String yearString = scanner.nextLine();
	    System.out.print("Enter new Colour: ");
	    String colour = scanner.nextLine();
	    System.out.print("Enter new registration_number: ");
	    String registration_number = scanner.nextLine();
	    System.out.print("Enter new Availability: ");
	    Boolean availability = scanner.nextBoolean();
	    System.out.print("Enter new daily_rate: ");
	    Double daily_rate = scanner.nextDouble();
	    Year ye_ar = Year.parse(yearString);
	    System.out.println("Year: " + ye_ar);
	    Vehicle vehicle = new Vehicle();
		vehicleService.updateVehicle(vehicle);
		System.out.println("Vehicle updated successfully.");
}

	private void addVehicle(IVehicleService vehicleService2, Scanner scanner2) {
		System.out.println("Enter VehicleId:");
        scanner.nextLine();  
        int vehicleid = scanner.nextInt();
        System.out.println("Enter Model :");
        scanner.nextLine();
        String model = scanner.nextLine();
        System.out.println("Enter Make :");
        String make = scanner.nextLine();
        System.out.println("Enter Ye_ar :");
        int year = scanner.nextInt();
        System.out.println("Year: " + year);
        System.out.println("Enter Colour :");
        String colour = scanner.nextLine();
        System.out.println("Enter Registration_Number :");	       
        String registration_number = scanner.nextLine();
        System.out.println("Enter Availability :");	 
        Boolean availability = scanner.nextBoolean();
        System.out.println("Enter Daily_Rate :");	    
        Double daily_rate = scanner.nextDouble();
        Vehicle vehicle = new Vehicle(vehicleid, model, make, year, colour, registration_number, availability, daily_rate);
        boolean success = vehicleService.addVehicle(vehicle);
        System.out.println(success ? "Vehicle added successfully." : "Failed to add vehicle.");
    }

	private void getVehicleById(IVehicleService vehicleService2, Scanner scanner2)throws VehicleNotFoundException {
		System.out.print("Enter Vehicle ID: ");
	    int vehicleId = scanner.nextInt(); 
	    Vehicle vehicle = vehicleService.getVehicleById(vehicleId); 
		System.out.println("Vehicle Found: " + vehicle);
	}

}