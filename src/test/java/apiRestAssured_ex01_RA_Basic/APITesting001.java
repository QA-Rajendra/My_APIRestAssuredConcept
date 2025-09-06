package apiRestAssured_ex01_RA_Basic;

import java.util.Scanner;
import io.restassured.RestAssured;

public class APITesting001 {

    public static void main(String[] args) {

        // Step 1: Gherkin Style in Rest Assured
        // Given() -> Pre-requisites: Base URL, Headers, Auth, Body etc.
        // When()  -> Action: HTTP Method (GET/POST/PUT/DELETE)
        // Then()  -> Validation: Status Code, Response Data, etc.

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the pincode: ");
        String pincode = scanner.nextLine();

        // Example: Full URL = https://api.zippopotam.us/IN/560016
        // Base URI = https://api.zippopotam.us
        // Base Path = /IN/{pincode}

        RestAssured
            .given()   // Pre-requisite setup
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
            .when()   // Action (HTTP method)
                .get()
            .then()   // Validation
                .log().all()       // Logs complete response
                .statusCode(200);  // Verifies response status code is 200 OK

        scanner.close();
    }
}
