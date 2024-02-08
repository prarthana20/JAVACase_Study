package com.hexaware.main;

import java.util.Scanner;
import com.hexaware.controller.AdminService;
import com.hexaware.dao.IAdminService;
import com.hexaware.entity.Admin;
import com.hexaware.exception.AdminNotFoundException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdminView {
    static Scanner scanner = new Scanner(System.in);
    static IAdminService adminService = new AdminService();

    public void displayMenu() throws AdminNotFoundException {
    	while(true) {
            System.out.println("Enter your choice");
            System.out.println("1. View Admin By ID");
            System.out.println("2. View Admin By Username");
            System.out.println("3. Register Admin");
            System.out.println("4. Update Admin");
            System.out.println("5. Delete Admin");
            
            int choice = scanner.nextInt();
       
            switch (choice) {
                case 1:
                    getAdminById(adminService,scanner);
                    break;
                case 2:
                    getAdminByUsername(adminService,scanner);
                    break;
                case 3:
                    registerAdmin(adminService,scanner);
                    break;
                case 4:
                    updateAdmin(adminService,scanner);
                    break;
                case 5:
                    deleteAdmin(adminService,scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
                }
            	System.out.println("Press Enter to continue");
            	scanner.nextLine();
    		}
        }
    /**
     * Sets the delete Admin function.
     * @param adminId of admin class.
     */
		private static void deleteAdmin(IAdminService adminService2, Scanner scanner2) throws AdminNotFoundException {
			System.out.print("Enter Admin ID to delete: ");
	        int adminId = scanner.nextInt();
	        adminService.deleteAdmin(adminId);
			System.out.println("Admin deleted successfully.");
		
		}

		private void updateAdmin(IAdminService adminService, Scanner scanner) throws AdminNotFoundException {
		    System.out.print("Enter Admin ID to update: ");
		    int adminId = scanner.nextInt();
		    scanner.nextLine();
		    System.out.print("Enter new FirstName: ");
		    String firstName = scanner.nextLine();
		    System.out.print("Enter new LastName: ");
		    String lastName = scanner.nextLine();
		    System.out.print("Enter new Email: ");
		    String email = scanner.nextLine();
		    System.out.print("Enter new PhoneNumber: ");
		    String phonenumber = scanner.nextLine();
		    System.out.print("Enter new UserName: ");
		    String username = scanner.nextLine();
		    System.out.print("Enter new Password: ");
		    String pass_word = scanner.nextLine();
		    System.out.print("Enter new Role: ");
		    String ro_le = scanner.nextLine();
		    System.out.print("Enter new Join Date (YYYY-MM-DD): ");
		    String join_dateStr = scanner.nextLine();
		    try {		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        Date parsedDate = dateFormat.parse(join_dateStr);
		        java.sql.Date join_date = new java.sql.Date(parsedDate.getTime());
		        Admin admin = new Admin(adminId, firstName, lastName, email, phonenumber, username, pass_word, ro_le, join_date);
		        adminService.updateAdmin(admin);
		        System.out.println("Admin updated successfully.");
		    } catch (ParseException e) {
		        System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
		    }
		}
		
		private void registerAdmin(IAdminService adminService2, Scanner scanner2) {
			System.out.println("Enter AdminId:");
	        scanner.nextLine();  
	        int adminid = scanner.nextInt();
	        System.out.println("Enter FirstName :");
	        scanner.nextLine();
	        String firstname = scanner.nextLine();
	        System.out.println("Enter LastName :");
	        String lastname = scanner.nextLine();
	        System.out.println("Enter Email :");
	        String email = scanner.nextLine();
	        System.out.println("Enter PhoneNumber :");
	        String phonenumber = scanner.nextLine();
	        System.out.println("Enter UserName :");	 
	        String username = scanner.nextLine();
	        System.out.println("Enter Password :");	    
	        String pass_word = scanner.nextLine();
	        System.out.println("Enter Role :");	    
	        String ro_le = scanner.nextLine();
	        System.out.println("Enter JoinDate (YYYY-MM-DD):");        
	        String join_dateStr = scanner.nextLine();
	        join_dateStr = join_dateStr.replace("\"", "");
	        Date join_date;
	        try {
	            join_date = new SimpleDateFormat("yyyy-MM-dd").parse(join_dateStr);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return;
	        }
	        Admin admin = new Admin(adminid, firstname, lastname, email, phonenumber, username, pass_word, ro_le, new java.sql.Date(join_date.getTime()));
	        boolean success = adminService.registerAdmin(admin);
	        System.out.println(success ? "Admin added successfully." : "Failed to add Admin.");
	    }

		private void getAdminByUsername(IAdminService adminService, Scanner scanner) throws AdminNotFoundException {
		    System.out.print("Enter Admin Username: ");
		    String adminUsername = scanner.next();
		    Admin admin = adminService.getAdminByUsername(adminUsername);
		    System.out.println("Admin Found: " + admin);
		}


		private static void getAdminById(IAdminService adminService, Scanner scanner) throws AdminNotFoundException {
		    System.out.print("Enter Admin ID: ");
		    int adminId = scanner.nextInt(); 
		    try{
		    	Admin admin = adminService.getAdminById(adminId);
		    	System.out.println("Admin Found: " + admin);
		    }catch(AdminNotFoundException e) {
		    	System.out.println(e.getMessage());
		    }
			
		}
}