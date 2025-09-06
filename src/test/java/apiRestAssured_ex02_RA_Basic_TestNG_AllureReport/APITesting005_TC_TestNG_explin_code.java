package apiRestAssured_ex02_RA_Basic_TestNG_AllureReport;


import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.restassured.RestAssured;

public class APITesting005_TC_TestNG_explin_code {

    /*
     ======================================================
     TEST CASE 1: Positive Test → Valid Indian Pincode
     ======================================================
     */
    @Test
    @Description("TC1 - Verify that a valid Indian pincode returns 200 OK")
    public void test_GET_Positive_TC1() {
        RestAssured
                .given()   // Precondition → Base URL & Path setup
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/110048") // Valid Indian pincode
                .when()    // Action → Send GET request
                    .get()
                .then()    // Validation
                    .log().all()            // Log full response
                    .statusCode(200);       // Assert HTTP 200 OK
    }


    /*
     ======================================================
     TEST CASE 2: Negative Test → Invalid Pincode (-1)
     ======================================================
     */
    @Test
    @Description("TC2 - Verify that an invalid pincode (-1) returns 404 Not Found")
    public void test_GET_Negative_TC2() {
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/-1")     // Invalid pincode
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(404);       // Assert HTTP 404 for invalid input
    }


    /*
     ======================================================
     TEST CASE 3: Negative Test → Special Character Pincode ($)
     ======================================================
     */
    @Test
    @Description("TC3 - Verify that a special character pincode ($) returns 404 Not Found")
    public void test_GET_Negative_TC3() {
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/$")      // Invalid pincode with special char
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(404);       // Assert HTTP 404 for invalid input
    }
}

/*
 ✅ Summary:
 1. TC1 → Valid Indian Pincode (110048) → Expected: 200 OK.
 2. TC2 → Invalid Pincode (-1) → Expected: 404 Not Found.
 3. TC3 → Special Character Pincode ($) → Expected: 404 Not Found.

 🛠 Best Practice:
 - Positive tests should return 200.
 - Negative tests should return 404/400 based on API design.
 - Allure @Description helps generate detailed test reports.
*/
