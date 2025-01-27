package day05;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestFileUpload {

    @Test(enabled = false)
    public void testSingleFileUpload() {
        File file = new File("src/test/resources/thisIsATestFile.txt");
        given().multiPart("file", file)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:3000/upload")
                .then().statusCode(200)
                .body("status", equalTo("success"));

    }


    @Test
    public void testMultipleFilesUpload() {
        File file = new File("src/test/resources/thisIsATestFile.txt");
        File file_two = new File("src/test/resources/fileToTest.txt");


        given().multiPart("files", file)
                .multiPart("files", file_two)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:3000/upload")
                .then().statusCode(200)
                .body("status", equalTo("success"));

    }
}
