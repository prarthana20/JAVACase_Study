package com.hexaware.entity;

import java.util.Date;

/**
 * This class represents a Admin object.
 * It contains methods to set and get admin details.
 */

public class Admin {
	
	private int adminID;
    private String firstName;
    private String lastName;
    private String email;
    private String phonenumber;
    private String username;
    private String pass_word;
    private String ro_le;
    private Date join_date;

    public Admin() {}

    public Admin(int adminID, String firstName, String lastName, String email, String phonenumber,
                    String username, String pass_word, String ro_le, Date join_date) {
        this.adminID = adminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phonenumber = phonenumber;
        this.username = username;
        this.pass_word = pass_word;
        this.ro_le = ro_le;
        this.join_date = join_date;
    }
    
    public int getadminId() {
        return adminID;
    }
    public void setadminId(int adminId) {
        this.adminID = adminId;
    }
    
    public String getfirstName() {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getlastName() {
        return lastName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    
    public String getphonenumber() {
        return phonenumber;
    }
    public void setphonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getusername() {
        return username;
    }
    public void setusername(String username) {
        this.username = username;
    }
    
    public String getpass_word() {
        return pass_word;
    }
    public void setpass_word(String pass_word) {
        this.pass_word = pass_word;
    }
    
    public String getro_le() {
        return ro_le;
    }
    public void setro_le(String ro_le) {
        this.ro_le = ro_le;
    }
    
    public Date getjoin_date() {
        return join_date;
    }
    public void setjoin_date(Date join_date ) {
        this.join_date = join_date;
    }

    public boolean Authenticate(String Password) {
        return this.pass_word.equals(Password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", username='" + username + '\'' +
                ", pass_word='" + pass_word + '\'' +
                ", ro_le='" + ro_le + '\'' +
                ", join_date='" + join_date + '\'' +
                '}';
    }
}


  

