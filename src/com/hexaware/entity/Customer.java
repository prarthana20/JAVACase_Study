package com.hexaware.entity;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class represents a Customer object.
 * It contains methods to set and get customer details.
 */
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phonenumber;
    private String address;
    private String username;
    private String pass_word;
    private Date registration_date;

    public Customer() {}
 
    public Customer(int customerID, String firstName, String lastName, String email, String phonenumber,
                    String address, String username, String pass_word, Date registration_date) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.username = username;
        this.pass_word = pass_word;
        this.registration_date = registration_date;
    }
    
    public int getcustomerId() {
        return customerID;
    }
    public void setcustomerId(int customerId) {
        this.customerID = customerId;
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
    
    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
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
    
    public Date getregistration_date() {
        return registration_date;
    }
    public void setregistration_date(Date registration_date ) {
        this.registration_date = registration_date;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean authenticate(String pass_word) {
        return this.pass_word.equals(pass_word);
    }
    
    public boolean validatePhoneNumber(String phoneNumber) {
        return isValidPhoneNumber(phoneNumber);
    }

    public boolean validateEmail(String email) {
        return isValidEmail(email);
    }
    
    @Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phonenumber=" + phonenumber + ", address=" + address + ", username=" + username + ", pass_word= " + pass_word + ", registration_date= " + registration_date + "]";
	}
    
    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false; 
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false; 
        }
        String phoneRegex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}




