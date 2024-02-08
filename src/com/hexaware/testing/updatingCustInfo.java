package com.hexaware.testing;

import static org.junit.Assert.*;
import com.hexaware.entity.Customer;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.controller.CustomerService;
import org.junit.Test;

public class updatingCustInfo {

    @Test
    public void testUpdateCustomer() {
        // Create a mock customer with updated information
        Customer updatedCustomer = new Customer();
        updatedCustomer.setcustomerId(1);
        updatedCustomer.setfirstName("John");
        updatedCustomer.setlastName("Doe");
        updatedCustomer.setemail("john.doe@example.com");
        updatedCustomer.setphonenumber("1234567890");
        updatedCustomer.setaddress("123 Main St, Anytown");
        updatedCustomer.setusername("johndoe");
        updatedCustomer.setpass_word("password123");

        // Call the method to update customer information
        CustomerService customerService = new CustomerService();
        boolean updated = false;
        try {
            updated = customerService.updateCustomer(updatedCustomer);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            fail("CustomerNotFoundException should not occur during update");
        }

        // Assert that the customer information is updated successfully
        assertTrue("Customer information should be updated", updated);

        // You can also retrieve the updated customer from the database and assert its values
        // Customer retrievedCustomer = customerService.getCustomerById(updatedCustomer.getCustomerId());
        // assertEquals("John", retrievedCustomer.getFirstName());
        // assertEquals("Doe", retrievedCustomer.getLastName());
        // assertEquals("john.doe@example.com", retrievedCustomer.getEmail());
        // assertEquals("1234567890", retrievedCustomer.getPhoneNumber());
        // assertEquals("123 Main St, Anytown", retrievedCustomer.getAddress());
        // assertEquals("johndoe", retrievedCustomer.getUsername());
        // assertEquals("password123", retrievedCustomer.getPassword());
    }
}
