package tests;

import POJOs.User;
import POJOs.UserSuccessResponse;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetTest {
    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }

    @Test
    public void getUsersFindById_statusCode() {
        get("/users/findById/18").then().assertThat().statusCode(200);
    }

    @Test
    public void getUsersFindById_headers() {
        get("/users/findById/18").then().assertThat().headers(
                "Server", "Cowboy",
                "Connection", "keep-alive",
                "Content-Type", "application/json",
                "Transfer-Encoding", "chunked",
                "Via", "1.1 vegur");
    }

    @Test
    public void getUsersFindById_contentType() {
        get("/users/findById/18").then().assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void getUsersFindById_userName() {
        get("/users/findById/18").then().assertThat().body("userName", is("ilyasLqs"));


    }
    @Test
    public void getUsersFindById_fullResponseBody() {
        get("/users/findById/18").then().assertThat().body(equalTo(
                "{" +
                "\"id\": 18," +
                "\"name\": \"ilyasa\","+
                "\"userName\": \"ilyasLqs\","+
                "\"email\": \"wmvHMHMI@gmail.com\","+
                "\"address\": null,"+
                "\"phone\": \"855353\","+
                "\"website\": \"https://MpelNAjbM.com\","+
                "\"company\": null}"));
    }
}