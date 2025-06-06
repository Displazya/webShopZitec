package com.automation.framework.payloads.customer;

import lombok.Data;
import java.util.List;

@Data
public class Customer {
    private String email;
    private String firstname;
    private String lastname;
    private List<Address> addresses;

    public Customer(String email, String firstname, String lastname, List<Address> addresses) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = addresses;
    }
}