package com.automation.framework.backend;

import com.automation.framework.ConfigReader;
import com.automation.framework.TestUtils;
import com.automation.framework.payloads.CustomerPayload;
import com.automation.framework.payloads.CustomerPayload.Address;
import com.automation.framework.payloads.CustomerPayload.Customer;
import com.automation.framework.payloads.CustomerPayload.Region;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateApiCustomerTest extends BaseApiTest {

    private static final String customerEmail = TestUtils.generateRandomString("Test@", ".test");
    private static final String customerPassword = TestUtils.uuidGenerator();

    @Test
    public void createNewApiCustomer() {
        TestUtils.logMessage("Starting createNewApiCustomer with email: " + customerEmail);
        Region region = new Region("NY", "New York", 43);

        Address customerAddress = new Address(
                true,
                true,
                "Zitec",
                "Test",
                region,
                "10755",
                Arrays.asList("123 Test test"),
                "Test",
                "111-222-333",
                "US"
        );

        Customer customer = new Customer(
                customerEmail,
                "Zitec",
                "test",
                List.of(customerAddress)
        );

        CustomerPayload payload = new CustomerPayload(customer, customerPassword);

        TestUtils.logMessage("Request Payload: " + payload);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + ConfigReader.getProperty("backend.properties", "magento.admin.token"))
                .body(payload)
                .when()
                .post("/rest/default/V1/customers")
                .then()
                .extract().response();

        TestUtils.logMessage("Response Status Code: " + response.statusCode());
        TestUtils.logMessage("Response Body: " + response.asString());
        assertEquals(200, response.statusCode());
        JSONObject jsonResponse = new JSONObject(response.asString());
        assertEquals(customerEmail, jsonResponse.getString("email"));
        TestUtils.logMessage("Customer account created successfully with ID: " + jsonResponse.getInt("id"));
    }
}