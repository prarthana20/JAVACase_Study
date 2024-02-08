package com.hexaware.main;

import java.util.List;
import java.util.Scanner;
import com.hexaware.controller.ReservationService;
import com.hexaware.dao.IReservationService;
import com.hexaware.entity.*;
import com.hexaware.exception.ReservationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReservationView {
    static Scanner scanner = new Scanner(System.in);
    static IReservationService reservationService = new ReservationService();

    public void displayMenu() throws ReservationException {
    	while(true) {
            System.out.println("Enter your choice");
            System.out.println("1. View Reservation By ID");
            System.out.println("2. View Reservation By CustomerId");
            System.out.println("3. Create Reservation");
            System.out.println("4. Update Reservation");
            System.out.println("5. Cancel Reservation");
            
            int choice = scanner.nextInt();
       
            switch (choice) {
                case 1:
                    getReservationById(reservationService,scanner);
                    break;
                case 2:
                    getReservationByCustomerId(reservationService,scanner);
                    break;
                case 3:
                    createReservation(reservationService,scanner);
                    break;
                case 4:
                    updateReservation(reservationService,scanner);
                    break;
                case 5:
                    cancelReservation(reservationService,scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
                }
            	System.out.println("Press Enter to continue");
            	scanner.nextLine();
    		}
        }

    private void createReservation(IReservationService reservationService2, Scanner scanner2) {
    	reservationService = new Reservation(); 

		System.out.println("--Please enter reservation details--\n");

		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();
		reservationService.setCustomerId(customerId);

		System.out.print("Enter Vehicle ID: ");
		int vehicleId = scanner.nextInt();
		reservationService.setVehicleID(vehicleId);
		
		System.out.print("Enter Start date and time in yyyy/MM/ddTHH:mm:ss format:");
		String userInput = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US);
		LocalDateTime userDateTime = LocalDateTime.parse(userInput, formatter);
		reservationService.setstartdate(userDateTime);
		
	    System.out.print("Enter End date and time in yyyy/MM/ddTHH:mm:ss format: ");
	    String userInput1 = scanner.next();
		LocalDateTime endDate = LocalDateTime.parse(userInput1, DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss", Locale.US));
		reservationService.setenddate(endDate);


		//custList.add(cust);

		System.out.println("reservation details were added succesfully!");
		IReservationService.createReservation(reservationService);
	}

	private void getReservationByCustomerId(IReservationService reservationService2, Scanner scanner2) {
		System.out.print("Enter Customer ID : ");
	    int customerId = scanner.nextInt();
		List<Reservation> allReservations = IReservationService.getReservationByCustomerId(customerId);
		    System.out.println("All Customers Reservation: " + allReservations);
		
	}

	private void getReservationById(IReservationService reservationService2, Scanner scanner2) {
		public void getReservationsByVehicleId() {
			System.out.print("Enter Vehicle ID : ");
		    int vehicleId = scanner.nextInt();
			List<Reservation> allReservations1 = IReservationService.getReservationsByVehicleId(vehicleId);
			    System.out.println("All Vehicle Reservation: " + allReservations1);
		}
		
	}

	private void updateReservation(IReservationService reservationService2, Scanner scanner2) throws ReservationException {
        System.out.print("Enter Reservation ID to update: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new CustomerId: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new VehicleId: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();
        Vehicle vehicle = null; // Replace null with the logic to fetch the Vehicle object
        if (vehicle == null) {
            System.out.println("Vehicle with ID " + vehicleId + " not found.");
            return;
        }
        System.out.print("Enter new StartDate (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr);
        System.out.print("Enter new EndDate (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateStr);
        System.out.print("Enter new TotalCost: ");
        double totalCost = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter new sta_tus: ");
        String sta_tus = scanner.nextLine();
        Reservation reservation = new Reservation();
		reservationService2.updateReservation(reservation);
		System.out.println("Reservation updated successfully.");
		}

	private void cancelReservation(IReservationService reservationService2, Scanner scanner2)throws ReservationException {
		System.out.print("Enter Reservation ID to delete: ");
	    int reservationId = scanner.nextInt();
	    reservationService.cancelReservation(reservationId);
	    System.out.println("Customer deleted successfully.");
	}
}

		
