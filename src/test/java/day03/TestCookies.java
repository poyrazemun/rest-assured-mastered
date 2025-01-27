package day03;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.when;

public class TestCookies {

    @Test(enabled = false)
    public void testCookies() {

        when().get("https://www.google.com/")
                .then()
                .cookie("AEC", "AZ6Zc-VU-L_W2CYh_5n1BFsYmUicPd_7Ha0z95buffwAzsBZeuWAk7XoMQ");

        //bu sekilde cookiyi verify edebiliriz ama mantikli degil cunku cookie degeri dogal olarak her seferinde degisiyor.
        //Yine de kullanilacagi yerler olabilir.

    }

    @Test
    public void testGettingCookiesInfo() {

        Response response = when().get("https://www.google.com/");

//        get single cookie:
//        String cookie_one = response.getCookie("AEC");
//        System.out.println("Value of the cookie is: " + cookie_one);

        //get all cookies

        Map<String, String> cookies = response.getCookies();

        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + response.getCookie(key));
        }


    }


}
