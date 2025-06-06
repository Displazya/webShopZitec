package com.automation.framework.payloads.customer;

import lombok.Data;

@Data
public class CustomerPayload {
    private Customer customer;
    private String password;

    public CustomerPayload() {}

    public CustomerPayload(Customer customer, String password) {
        this.customer = customer;
        this.password = password;
    }
}