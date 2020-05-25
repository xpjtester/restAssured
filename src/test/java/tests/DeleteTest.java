package tests;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;

import static io.restassured.RestAssured.*;

public class DeleteTest {
    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }

    @Test
    public void deleteUser(){
        given()
                .contentType("application/json")
                .delete("user/reskillUsernName999")
                .peek() // Use peek() to print the ouput
        .then()

                .statusCode(204)
                .extract()
                .asString();

    }
}
