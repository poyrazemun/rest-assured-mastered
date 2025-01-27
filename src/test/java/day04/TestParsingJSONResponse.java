package day04;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class TestParsingJSONResponse {

    @Test(enabled = false) //1
    public void testParsingJSONResponse() {

        when().get("http://localhost:3000/store")
                .then().statusCode(200)
                .body("books[3].title", equalTo("The Great Gatsby"));
    }


    @Test(enabled = false) //2
    public void testParsingJSONResponseTwo() {
        Response response = when().get("http://localhost:3000/store");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        System.out.println(response.jsonPath().get("books[3].title").toString());
    }


    @Test(enabled = true) //3
    public void testParsingJSONResponseThree() {
        Response response = when().get("http://localhost:3000/store");
//        List<String> books = response.jsonPath().getList("books.title");
//        for (int i = 0; i < books.size(); i++) {
//            System.out.println(i + 1 + ":" + books.get(i));

        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        for (int i = 0; i < jsonObject.getJSONArray("books").length(); i++) {

            System.out.println(jsonObject.getJSONArray("books").getJSONObject(i).getString("title") + ": " + jsonObject.getJSONArray("books").getJSONObject(i).getString("author"));

        }

    }


    @Test(enabled = true) //4
    public void testParsingJSONResponseFour() { //find the total price of all books
        Response response = when().get("http://localhost:3000/store");

        double total = 0;


        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        for (int i = 0; i < jsonObject.getJSONArray("books").length(); i++) {
            double price = jsonObject.getJSONArray("books").getJSONObject(i).getDouble("price");
            total += price;
        }

        BigDecimal roundedTotal = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        Assert.assertEquals(104.69, roundedTotal.doubleValue());

    }
}



