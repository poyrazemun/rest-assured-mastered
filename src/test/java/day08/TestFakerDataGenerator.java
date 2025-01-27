package day08;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestFakerDataGenerator {
    @Test
    public void testFakerDataGenerator() {


        Faker fkr = new Faker();
        String[] courses = {fkr.programmingLanguage().name(), fkr.programmingLanguage().name()};

        Pojo_PostRequestForFaker myData = new Pojo_PostRequestForFaker();
        myData.setName(fkr.name().fullName());
        myData.setLocation(fkr.country().name());
        myData.setPhone(fkr.phoneNumber().cellPhone());
        myData.setCourses(courses);

        Response response = given().contentType("application/json")
                .body(myData)
                .when()
                .post("http://localhost:3000/students");

        System.out.println(response.jsonPath().getString("name"));
        System.out.println(response.jsonPath().getString("location"));
        System.out.println(response.jsonPath().getString("phone"));
        System.out.println(response.jsonPath().getString("courses[0]"));

    }
}
