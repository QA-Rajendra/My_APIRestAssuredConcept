package apiRestAssured_ex02_RA_Basic_TestNG_AllureReport;

import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;
import io.qameta.allure.Description;
import io.restassured.RestAssured;

public class APITesting005_TC_TestNG_Fix {

	@Test
	@Description("TC1-Verify that the Valid Pincode gives 200 Ok")
	public void test_GET_Positive_TC1() {
		
		RestAssured
		      .given()
		      .baseUri("https://api.zippopotam.us")
		      .basePath("/IN/110048")
		      .when()
              .get()
              .then()
              .log().all().statusCode(200);
	}
	

    @Test
    @Description("TC#2 - Verify that the Invalid Pincode gives error")
    public void test_GET_Negative_TC2(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+"-1")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    @Description("TC#3 - Verify that the InValid Pincode gives 200 Ok")
    public void test_GET_Negative_TC3(){

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+"$")
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

}
