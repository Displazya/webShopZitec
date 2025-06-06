package com.automation.framework.payloads;

import lombok.Data;
import java.util.List;

@Data
public class CustomerPayload {
    private Customer customer;
    private String password;

    public CustomerPayload() {}

    public CustomerPayload(Customer customer, String password) {
        this.customer = customer;
        this.password = password;
    }

    @Data
    public static class Customer {
        private String email;
        private String firstname;
        private String lastname;
        private List<Address> addresses;

        public Customer() {}

        public Customer(String email, String firstname, String lastname, List<Address> addresses) {
            this.email = email;
            this.firstname = firstname;
            this.lastname = lastname;
            this.addresses = addresses;
        }
    }

    @Data
    public static class Address {
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

        public Address() {}

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

    @Data
    public static class Region {
        private String regionCode;
        private String region;
        private Integer regionId;

        public Region(String regionCode, String region, Integer regionId) {
            this.regionCode = regionCode;
            this.region = region;
            this.regionId = regionId;
        }
    }
}