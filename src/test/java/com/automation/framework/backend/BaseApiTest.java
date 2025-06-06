package com.automation.framework.backend;

import com.automation.framework.ConfigReader;
import com.automation.framework.TestUtils;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = ConfigReader.getProperty("backend.properties", "softwareTestingBoard.base.url");
    }
}