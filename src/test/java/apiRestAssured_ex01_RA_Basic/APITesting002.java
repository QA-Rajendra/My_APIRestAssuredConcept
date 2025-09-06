package apiRestAssured_ex01_RA_Basic;


import io.restassured.RestAssured;


import static org.hamcrest.Matchers.*;        // For response validations (equalTo, notNullValue, etc.)

public class APITesting002 {

    public static void main(String[] args) {

        /*
         ==================================================
         REST ASSURED BASICS (Gherkin Style)
         ==================================================
         Given() -> Pre-requisites like Base URL, Headers, Auth, Body, etc.
         When()  -> Action (HTTP Method like GET, POST, PUT, DELETE)
         Then()  -> Validation (Status Code, Response Data, Logs, etc.)
         ==================================================
      
         ==================================================
         API Details
         ==================================================
         Full URL   : https://api.zippopotam.us/IN/560016
         Base URI   : https://api.zippopotam.us
         Base Path  : /IN/{pincode}
         
         Example:
         If user enters -> 560016
         Final API call -> https://api.zippopotam.us/IN/560016
         ==================================================
        */

        RestAssured
            .given()   // ================== GIVEN ==================
                .baseUri("https://api.zippopotam.us")  // Set Base URI
                .basePath("/IN/" + 560016)            // Set Base Path dynamically using user input

            .when()    // ================== WHEN ==================
                .get()   // Perform GET request

            .then()    // ================== THEN ==================
                .log().all()              // Log entire response (headers + body)
                .statusCode(200)          // Validate response status code = 200 (OK)
                .body("country", equalTo("India"))       // Validate field "country" = India
                .body("country abbreviation", equalTo("IN")) // Validate field "country abbreviation" = IN
                .body("places[0].state", notNullValue()) // Validate that "state" is not null
                .body("places[0].'place name'", notNullValue()); // Validate that "place name" is not null

       
   
    }
}
