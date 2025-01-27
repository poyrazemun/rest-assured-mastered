package day03;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class TestHeaders {

    @Test(enabled = false)
    public void testHeader() {
        when().get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip");
    }


    @Test
    public void testGetHeader() {
        Response response = when().get("https://www.google.com/");

//        get single header info
//        String header_one = response.getHeader("Content-Type");
//        System.out.println("Value of the header is: " + header_one);


        //get all headers
        Headers headers = response.getHeaders();

        for (Header hd : headers) {
            System.out.println(hd.getName() + ": " + hd.getValue());
        }
    }


}
