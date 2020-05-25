package tests;

import POJOs.User;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class PostTest {
    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }
    @Test
    public void postUsers_statusCode() {
        User user = new User("Reskill name", "reskillUsernName999", "reskill@reskill.res", "+123123", "resk.resk.res","");

        given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/user")
                .then()
                .statusCode(201);
    }



}
