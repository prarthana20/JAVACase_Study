package com.hexaware.main;

import java.util.Scanner;
import com.hexaware.exception.*;
/***
 * This is main Class of Project Car_connect
 * @author Prarthana Kamthe
 *
 */
public class CarConnect {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("***** WELCOME TO CarConnect *****");
		String input = null;
		do {
			System.out.println("Select a Module ");
			System.out.println("1. Admin Login");
			System.out.println("2. Customer Login");
			System.out.println("3. Vehicle Login");
			System.out.println("4. Reservation Details");
			System.out.println("5. Exit System");
			
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				AdminView AdminView = new AdminView();
				try {
					AdminView.displayMenu();
				} catch (AdminNotFoundException e) {
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				CustomerView CustomerView = new CustomerView();
				try {
					CustomerView.displayMenu();
				} catch (CustomerNotFoundException e) {
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				VehicleView vehicleView = new VehicleView();
				try {
				    vehicleView.displayMenu();
				} catch (VehicleNotFoundException e) {
				    e.printStackTrace(); 
				}
				break;
			}
			case 4: {
				ReservationView ReservationView = new ReservationView();
				try {
					ReservationView.displayMenu();
				} catch (ReservationException e) {
					e.printStackTrace();
				}
				break;
			}
			case 5:{
				System.out.println("***** THANKS FOR USING OUR SYSTEM *****");
				return;
			}
			default: {
				System.out.println("Choose a proper choice");
				break;
			}
		}
			System.out.println("To Continue - Press 'C' | 'c'");
			input = scan.next();
			
		} while (input.equals("c") || input.equals("C"));
	}
}