package day03;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class TestLoggings {

    @Test
    public void testLoggings() {

        when().get("https://reqres.in/api/users?page=2")
                .then()
                //.log().body();
                // .log().cookies();
                .log().headers();


        //yani log'dan sonra bircok farkli seyi print edebilirim.

    }


}
