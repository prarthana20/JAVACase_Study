package com.hexaware.controller;

import com.hexaware.dao.IAdminService;
import com.hexaware.entity.Admin;
import com.hexaware.exception.AdminNotFoundException;
import com.hexaware.util.DatabaseConn;
import java.sql.*;


public class AdminService implements IAdminService {

	@Override
	public Admin getAdminByUsername(String adminUsername) throws AdminNotFoundException {
		String sql = "SELECT * FROM admin WHERE username = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, adminUsername);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Admin(
	                    rs.getInt("adminid"),
	                    rs.getString("firstname"),
	                    rs.getString("lastname"),
	                    rs.getString("email"),
	                    rs.getString("phonenumber"),
	                    rs.getString("username"),
	                    rs.getString("pass_word"),
	                    rs.getString("ro_le"),
	                    rs.getDate("join_date"));
	            } else {
	                throw new AdminNotFoundException("Admin with UserName " + adminUsername + " not found.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new AdminNotFoundException("Error accessing the database", e);
	    }
	}


	@Override
	public boolean registerAdmin(Admin admin) {
	    String sql = "INSERT INTO admin (adminid, firstname, lastname, email, phonenumber, username, pass_word, ro_le, join_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, admin.getadminId());
	        stmt.setString(2, admin.getfirstName());
	        stmt.setString(3, admin.getlastName());
	        stmt.setString(4, admin.getemail());
	        stmt.setString(5, admin.getphonenumber());
	        stmt.setString(7, admin.getusername());
	        stmt.setString(8, admin.getpass_word());
	        stmt.setString(6, admin.getro_le());
	        java.util.Date utilDate = admin.getjoin_date();
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
	public Admin getAdminById(int adminId) throws AdminNotFoundException {
	    String sql = "SELECT * FROM admin WHERE adminid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, adminId);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Admin(
	                    rs.getInt("adminid"),
	                    rs.getString("firstname"),
	                    rs.getString("lastname"),
	                    rs.getString("email"),
	                    rs.getString("phonenumber"),                 
	                    rs.getString("username"),
	                    rs.getString("pass_word"),
	                    rs.getString("ro_le"),
	                    rs.getDate("join_date"));
	            } else {
	                throw new AdminNotFoundException("Admin with ID " + adminId + " not found.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new AdminNotFoundException("Error accessing the database", e);
	    }
	}


	@Override
	public boolean deleteAdmin(int adminId) throws AdminNotFoundException {
		 String sql = "DELETE FROM admin WHERE adminid = ?";
	        try (Connection conn = DatabaseConn.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1,adminId);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected == 0) {
	                throw new AdminNotFoundException("Admin with ID " + adminId + " not found.");
	            }
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	
	public boolean updateAdmin(Admin admin) throws AdminNotFoundException {
	    String sql = "UPDATE admin SET firstname = ?, lastname = ?, email = ?, phonenumber = ?, username = ?, pass_word = ?, ro_le = ?, join_date = ? WHERE adminid = ?";
	    try (Connection conn = DatabaseConn.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, admin.getfirstName());
	        stmt.setString(2, admin.getlastName());
	        stmt.setString(3, admin.getemail());
	        stmt.setString(4, admin.getphonenumber());
	        stmt.setString(5, admin.getusername());
	        stmt.setString(6, admin.getpass_word());
	        stmt.setString(7, admin.getro_le());
	        java.util.Date utiljoin_date = admin.getjoin_date();
	        java.sql.Date sqljoin_date = new java.sql.Date(utiljoin_date.getTime());
	        stmt.setDate(8, sqljoin_date);
	        stmt.setInt(9, admin.getadminId());
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected == 0) {
	            throw new AdminNotFoundException("No Admin found with ID " + admin.getadminId());
	        }
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new AdminNotFoundException("Database access error occurred", e);
	    }
	}
}

