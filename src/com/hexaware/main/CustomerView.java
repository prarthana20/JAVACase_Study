package com.hexaware.main;

import java.util.Scanner;
import com.hexaware.controller.CustomerService;
import com.hexaware.dao.ICustomerService;
import com.hexaware.entity.Customer;
import com.hexaware.exception.CustomerNotFoundException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerView {
    static Scanner scanner = new Scanner(System.in);
    static ICustomerService customerService = new CustomerService();

    public void displayMenu() throws CustomerNotFoundException {
    	while(true) {
            System.out.println("Enter your choice");
            System.out.println("1. View Customer By ID");
            System.out.println("2. View Customer By Username");
            System.out.println("3. Register Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customers");
            
            int choice = scanner.nextInt();
       
            switch (choice) {
                case 1:
                    getCustomerById(customerService,scanner);
                    break;
                case 2:
                    getCustomerByUsername(customerService,scanner);
                    break;
                case 3:
                    registerCustomer(customerService,scanner);
                    break;
                case 4:
                    updateCustomer(customerService,scanner);
                    break;
                case 5:
                    deleteCustomer(customerService,scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
                }
            	System.out.println("Press Enter to continue");
            	scanner.nextLine();
    		}
        }

		private static void deleteCustomer(ICustomerService customerService2, Scanner scanner2) throws CustomerNotFoundException {
			System.out.print("Enter Customer ID to delete: ");
	        int customerId = scanner.nextInt();
	        customerService.deleteCustomer(customerId);
			System.out.println("Customer deleted successfully.");
		
		}

		private void updateCustomer(ICustomerService customerService, Scanner scanner) {
		    System.out.print("Enter Customer ID to update: ");
		    int customerId = scanner.nextInt();
		    scanner.nextLine();
		    System.out.print("Enter new FirstName: ");
		    String firstName = scanner.nextLine();
		    System.out.print("Enter new LastName: ");
		    String lastName = scanner.nextLine();
		    System.out.print("Enter new Email: ");
		    String email = scanner.nextLine();
		    System.out.print("Enter new PhoneNumber: ");
		    String phoneNumber = scanner.nextLine();
		    System.out.print("Enter new Address: ");
		    String address = scanner.nextLine();
		    System.out.print("Enter new UserName: ");
		    String username = scanner.nextLine();
		    System.out.print("Enter new Password: ");
		    String password = scanner.nextLine();
		    System.out.print("Enter new Registration Date (YYYY-MM-DD): ");
		    String registration_dateStr = scanner.nextLine();
		    try {		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        Date parsedDate = dateFormat.parse(registration_dateStr);
		        java.sql.Date registration_date = new java.sql.Date(parsedDate.getTime());
		        Customer customer = new Customer(customerId, firstName, lastName, email, phoneNumber, address, username, password, registration_date);
		        customerService.updateCustomer(customer);
		        System.out.println("Customer updated successfully.");
		    } catch (ParseException e) {
		        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
		    } catch (CustomerNotFoundException e) {
		        System.out.println("Customer not found. Unable to update.");
		    }
		}
		
		private void registerCustomer(ICustomerService customerService2, Scanner scanner2) {
			System.out.println("Enter CustomerId:");
	        scanner.nextLine();  
	        int customerid = scanner.nextInt();
	        System.out.println("Enter FirstName :");
	        scanner.nextLine();
	        String firstname = scanner.nextLine();
	        System.out.println("Enter LastName :");
	        String lastname = scanner.nextLine();
	        System.out.println("Enter Email :");
	        String email = scanner.nextLine();
	        System.out.println("Enter PhoneNumber :");
	        String phonenumber = scanner.nextLine();
	        System.out.println("Enter Address :");	       
	        String address = scanner.nextLine();
	        System.out.println("Enter UserName :");	 
	        String username = scanner.nextLine();
	        System.out.println("Enter Password :");	    
	        String pass_word = scanner.nextLine();
	        System.out.println("Enter RegistrationDate (YYYY-MM-DD):");        
	        String registration_dateStr = scanner.nextLine();
	        registration_dateStr = registration_dateStr.replace("\"", "");
	        Date registration_date;
	        try {
	            registration_date = new SimpleDateFormat("yyyy-MM-dd").parse(registration_dateStr);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return;
	        }
	        Customer customer = new Customer(customerid, firstname, lastname, email, phonenumber, address, username, pass_word, new java.sql.Date(registration_date.getTime()));
	        boolean success = customerService.registerCustomer(customer);
	        System.out.println(success ? "Customer added successfully." : "Failed to add Customer.");
	    }

		private void getCustomerByUsername(ICustomerService customerService, Scanner scanner) throws CustomerNotFoundException {
		    System.out.print("Enter Customer Username: ");
		    String customerUsername = scanner.next();
		    Customer customer = customerService.getCustomerByUsername(customerUsername);
		    System.out.println("Customer Found: " + customer);
		}


		private static void getCustomerById(ICustomerService customerService, Scanner scanner) throws CustomerNotFoundException {
		    System.out.print("Enter Customer ID: ");
		    int customerId = scanner.nextInt(); 
		    Customer customer = customerService.getCustomerById(customerId); 
			System.out.println("Customer Found: " + customer);
		}
}
    

