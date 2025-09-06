package apiRestAssured_ex03_GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {

    // Class-level reusable variables
    RequestSpecification request;   // Used to build request (headers, params, body, etc.)
    Response response;              // Holds the API response
    ValidatableResponse validResp;  // Used to validate the response

    /*
     ======================================================
     TEST CASE 1: Positive Test → Valid Indian Pincode
     ======================================================
     */
    @Description("TC1 - Verify that a valid Indian pincode returns 200 OK")
    @Test
    public void test_NonBDD_GET_Positive() {
        String pincode = "560048"; // Valid Bangalore pincode

        // Step 1: Create Request
        request = RestAssured.given();            // Initialize request
        request.baseUri("https://api.zippopotam.us"); // Set Base URI
        request.basePath("/IN/" + pincode);       // Set endpoint path

        // Step 2: Send Request → GET
        response = request.when()
                          .log().all()            // Log Request Details
                          .get();                 // Fire GET Request

        // Step 3: Validate Response
        validResp = response.then()
                            .log().all()          // Log Response Details
                            .statusCode(200);     // Assert Status Code = 200
    }


    /*
     ======================================================
     TEST CASE 2: Negative Test → Invalid Indian Pincode (-1)
     ======================================================
     */
    @Description("TC2 - Verify that an invalid pincode (-1) returns 404 Not Found")
    @Test
    public void test_NonBDD_GET_Negative() {
        String pincode = "-1"; // Invalid Pincode

        // Step 1: Create Request
        request = RestAssured.given();
        request.baseUri("https://api.zippopotam.us");
        request.basePath("/IN/" + pincode);

        // Step 2: Send Request → GET
        response = request.when()
                          .log().all()
                          .get();

        // Step 3: Validate Response
        validResp = response.then()
                            .log().all()
                            .statusCode(404);  // Expecting 404 Not Found
    }
}

/*
 ✅ Summary:
 - Non-BDD style → More verbose than BDD (Given-When-Then chain).
 - Steps are broken down into:
     1. RequestSpecification (request setup)
     2. Response (execution)
     3. ValidatableResponse (validation)
 - TC1: Valid Pincode → 200 OK
 - TC2: Invalid Pincode (-1) → 404 Not Found

 📌 Best Practice: Non-BDD is useful when you want fine-grained control 
 over each step (e.g., reuse response object, extract values, etc.)
*/
 