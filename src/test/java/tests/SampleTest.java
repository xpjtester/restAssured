package tests;

import POJOs.User;
import POJOs.UserSuccessResponse;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class SampleTest {

    @Before
    public void setup() {
        baseURI = "http://spring-boot-test-aplication.herokuapp.com";
        basePath = "/api";
    }


    @Test
    public void getUsersFindById_statusCode() {
        get("/users/findById/60").then().assertThat().statusCode(200);
    }

    @Test
    public void getUsersFindById_headers() {
        get("/users/findById/60").then().assertThat().headers(
                "Server", "Cowboy",
                "Connection", "keep-alive",
                "Content-Type", "application/json",
                "Transfer-Encoding", "chunked");
    }

    @Test
    public void getUsersFindById_contentType() {
        get("/users/findById/60").then().assertThat().contentType(ContentType.JSON);
    }

    // Response body validation
    @Test
    public void getUsersFindById_userName() {
        get("/users/findById/60").then().assertThat().body("userName", is("someUserNameReskilling"));
    }

    @Test
    public void getUsersFindById_fullResponseBody() {
        get("/users/findById/60").then().assertThat().body(equalTo(
                "{" +
                        "\"id\":60," +
                        "\"name\":\"Some name\"," +
                        "\"userName\":\"someUserNameReskilling\"," +
                        "\"email\":\"asdas@adasd.cn\"," +
                        "\"address\":null," +
                        "\"phone\":\"123123123\"," +
                        "\"website\":\"asdasdasd\"," +
                        "\"company\":null}"));
    }

    @Test
    public void postUser_Serialize() {
        User user = new User("Reskill name", "reskillUsernName201", "reskill@reskill.res", "+123123", "resk.resk.res" ,"");

        given()
                .contentType("application/json")
                .body(user)
        .when()
                .post("/user")
        .then()
                .statusCode(201);
    }

    @Test
    public void postUser_Deserialize() {
        User user = new User("Reskill name", "reskillUsernName272", "reskill@reskill.res", "+123123", "resk.resk.res", "");

        Response response = given()
                                .contentType("application/json")
                                .body(user)
                            .when()
                                .post("/user");

        response.then().statusCode(201);

        UserSuccessResponse userResponse = response.as(UserSuccessResponse.class);
        System.out.println("User name: " + userResponse.getUserName());
        System.out.println("Generated id: " + userResponse.getId());

        assertEquals(user.getUserName(), userResponse.getUserName());
    }

}
