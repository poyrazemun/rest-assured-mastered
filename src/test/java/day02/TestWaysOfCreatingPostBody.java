package day02;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

//way1: Post request body using Hashmap
//way2: Post request body using org.json
//way3: Post request body using POJO class
//way4: Post request body using external json file data

public class TestWaysOfCreatingPostBody {

    int id;

    @Test(priority = 1, enabled = false)
    public void testPostUsingHashMap() {
        String[] courses = {"Java", "Selenium"};

        HashMap<Object, Object> myData = new HashMap<>();
        myData.put("name", "Monika");
        myData.put("location", "Mexico");
        myData.put("phone", "12345");
        myData.put("courses", courses);

        Response response = given().contentType("application/json")
                .body(myData)
                .when()
                .post("http://localhost:3000/students");

        response.then()
                .statusCode(201)
                .body("name", equalTo("Monika"))
                .body("location", equalTo("Mexico"))
                .body("phone", equalTo("12345"))
                .body("courses[0]", equalTo("Java"))
                .header("Content-Type", "application/json; charset=utf-8");

        id = response.jsonPath().getInt("id");
        System.out.println(response.jsonPath().getInt("id"));
    }

    @Test(priority = 2)
    public void testDeleteStudent() {

        when().delete("http://localhost:3000/students/" + id)
                .then().statusCode(200);


    }

    @Test(priority = 1, enabled = false)
    public void testPostUsingOrgJson() {

        String[] courses = {"Java", "Selenium"};

        JSONObject myData = new JSONObject();
        myData.put("name", "Toni");
        myData.put("location", "CL");
        myData.put("phone", "12345");
        myData.put("courses", courses);

        Response response = given().contentType("application/json")
                .body(myData.toString()) //HashMap'ten farki burada!!!!
                .when()
                .post("http://localhost:3000/students");

        response.then()
                .statusCode(201)
                .body("name", equalTo("Toni"))
                .body("location", equalTo("CL"))
                .body("phone", equalTo("12345"))
                .body("courses[0]", equalTo("Java"))
                .header("Content-Type", "application/json; charset=utf-8");

        id = response.jsonPath().getInt("id");
        System.out.println(response.jsonPath().getInt("id"));
    }

    @Test(priority = 1, enabled = false)
    public void testPostUsingPOJOClass() {

        String[] courses = {"Java", "Selenium"};

        Pojo_PostRequest myData = new Pojo_PostRequest();
        myData.setName("James");
        myData.setLocation("GU");
        myData.setPhone("12345");
        myData.setCourses(courses);


        Response response = given().contentType("application/json")
                .body(myData)
                .when()
                .post("http://localhost:3000/students");

        response.then()
                .statusCode(201)
                .body("name", equalTo("James"))
                .body("location", equalTo("GU"))
                .body("phone", equalTo("12345"))
                .body("courses[0]", equalTo("Java"))
                .header("Content-Type", "application/json; charset=utf-8");

        id = response.jsonPath().getInt("id");
        System.out.println(response.jsonPath().getInt("id"));
    }

    @Test(priority = 1)
    public void testPostUsingExternalJSONFile() throws FileNotFoundException {

        File file = new File(".\\newStudent.json");

        FileReader fileReader = new FileReader(file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject myData = new JSONObject(jsonTokener);


        Response response = given().contentType("application/json")
                .body(myData.toString())
                .when()
                .post("http://localhost:3000/students");

        response.then()
                .statusCode(201)
                .body("name", equalTo("Monika"))
                .body("location", equalTo("Mexico"))
                .body("phone", equalTo("12345"))
                .body("courses[0]", equalTo("Java"))
                .header("Content-Type", "application/json; charset=utf-8");

        id = response.jsonPath().getInt("id");
        System.out.println(response.jsonPath().getInt("id"));
    }

}
