package com.hexaware.controller;

import com.hexaware.dao.ICustomerService;
import com.hexaware.entity.Customer;
import com.hexaware.exception.*;
import com.hexaware.util.DatabaseConn;
import java.sql.*;

public class CustomerService implements ICustomerService {

	@Override
	public Customer getCustomerByUsername(String customerUsername) throws CustomerNotFoundException {
		String sql = "SELECT * FROM customer WHERE username = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, customerUsername);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Customer(
	                    rs.getInt("customerid"),
	                    rs.getString("firstname"),
	                    rs.getString("lastname"),
	                    rs.getString("email"),
	                    rs.getString("phonenumber"),
	                    rs.getString("address"),
	                    rs.getString("username"),
	                    rs.getString("pass_word"),
	                    rs.getDate("registration_date"));
	            } else {
	                throw new CustomerNotFoundException("Customer with UserName " + customerUsername + " not found.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new CustomerNotFoundException("Error accessing the database", e);
	    }
	}


	@Override
	public boolean registerCustomer(Customer customer) {
	    String sql = "INSERT INTO customer (customerid, firstname, lastname, email, phonenumber, address, username, pass_word, registration_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, customer.getcustomerId());
	        stmt.setString(2, customer.getfirstName());
	        stmt.setString(3, customer.getlastName());
	        stmt.setString(4, customer.getemail());
	        stmt.setString(5, customer.getphonenumber());
	        stmt.setString(6, customer.getaddress());
	        stmt.setString(7, customer.getusername());
	        stmt.setString(8, customer.getpass_word());
	        
	        java.util.Date utilDate = customer.getregistration_date();
	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	        stmt.setDate(9, sqlDate);
	        
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}


	
	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
	    String sql = "SELECT * FROM customer WHERE customerid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, customerId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Customer(
	                    rs.getInt("customerid"),
	                    rs.getString("firstname"),
	                    rs.getString("lastname"),
	                    rs.getString("email"),
	                    rs.getString("phonenumber"),
	                    rs.getString("address"),
	                    rs.getString("username"),
	                    rs.getString("pass_word"),
	                    rs.getDate("registration_date"));
	            } else {
	                throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new CustomerNotFoundException("Error accessing the database", e);
	    }
	}


	@Override
	public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
		 String sql = "DELETE FROM customer WHERE customerid = ?";
	        try (Connection conn = DatabaseConn.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1,customerId);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected == 0) {
	                throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
	            }
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	
	public boolean updateCustomer(Customer customer) throws CustomerNotFoundException {
	    String sql = "UPDATE customer SET firstname = ?, lastname = ?, email = ?, phonenumber = ?, address = ?, username = ?, pass_word = ? WHERE customerid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, customer.getfirstName());
	        stmt.setString(2, customer.getlastName());
	        stmt.setString(3, customer.getemail());
	        stmt.setString(4, customer.getphonenumber());
	        stmt.setString(5, customer.getaddress());
	        stmt.setString(6, customer.getusername());
	        stmt.setString(7, customer.getpass_word());
	        stmt.setInt(8, customer.getcustomerId());
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new CustomerNotFoundException("No Customer found with ID " + customer.getcustomerId());
	        }
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new CustomerNotFoundException("Database access error occurred", e);
	    }
	}
}

