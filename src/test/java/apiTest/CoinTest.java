package apiTest;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class CoinTest {

	@Test
	public void getRequest() {
		 RestAssured.baseURI = "https://api.coindesk.com/v1/bpi";
	        RestAssured.given()
	            .when()
	                .get("/currentprice.json")
	            .then()
	                .statusCode(200)
	                .body("bpi.USD", notNullValue()) 
	                .body("bpi.GBP", notNullValue()) 
	                .body("bpi.EUR", notNullValue()) 
	                .body("bpi.GBP.description", equalTo("British Pound Sterling"))
	                .log().all();
	}
}
