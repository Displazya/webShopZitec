package com.automation.framework.payloads.customer;

import lombok.Data;
import java.util.List;

@Data
public class Address {
    private Boolean defaultShipping;
    private Boolean defaultBilling;
    private String firstname;
    private String lastname;
    private Region region;
    private String postcode;
    private List<String> street;
    private String city;
    private String telephone;
    private String countryId;

    public Address(Boolean defaultShipping, Boolean defaultBilling, String firstname, String lastname, Region region, String postcode, List<String> street, String city, String telephone, String countryId) {
        this.defaultShipping = defaultShipping;
        this.defaultBilling = defaultBilling;
        this.firstname = firstname;
        this.lastname = lastname;
        this.region = region;
        this.postcode = postcode;
        this.street = street;
        this.city = city;
        this.telephone = telephone;
        this.countryId = countryId;
    }
}