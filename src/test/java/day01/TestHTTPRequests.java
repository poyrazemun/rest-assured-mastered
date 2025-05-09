package day01;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

/*
given ():
    content type, set cookies, add auth, add param, set headers info etc.

when():
    get, put, post, delete

then():
    validate status code, extract response, extract headers cookies & response body

*/

public class TestHTTPRequests {

    int id;

    @Test(priority = 1)
    public void testListUser() {

        given().header("x-api-key", "reqres-free-v1").
                when().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
                .body("page", equalTo(2));


    }

    @Test(priority = 2)
    public void testAddNewUser() {

        HashMap<Object, Object> hm = new HashMap<>();
        hm.put("name", "Veli");
        hm.put("job", "Senior QA Engineer");

        id = given().contentType("application/json").body(hm).header("x-api-key", "reqres-free-v1")
                .when().post("https://reqres.in/api/users")
                .jsonPath().getInt("id");


    }

    @Test(priority = 3, dependsOnMethods = {"testAddNewUser"})
    public void testUpdateUser() {
        HashMap<Object, Object> newData = new HashMap<>();
        newData.put("name", "Ali");
        newData.put("job", "QA Manager");

        given().contentType("application/json").body(newData).header("x-api-key", "reqres-free-v1")
                .when().put("https://reqres.in/api/users/" + id)
                .then().statusCode(200);
    }


    @Test(priority = 4, dependsOnMethods = {"testUpdateUser"})
    public void testDeleteUser() {
        given().header("x-api-key", "reqres-free-v1")
                .when().delete("https://reqres.in/api/users/" + id)
                .then().statusCode(204);
    }
}
