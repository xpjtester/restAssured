package tests;

import POJOs.Address;
import POJOs.User;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PutTest {
    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }

    @Test
    public void putUserUpadateAddress(){

       Address address= new Address("somestreet","someSuite","someCity","5678");

        given()
                .contentType("application/json")
                .body(address)
                .when()
                .put("/user/reskillUsernName999/address")
                .then()
                .statusCode(204)
                .extract()
                .asString();
    }
}
