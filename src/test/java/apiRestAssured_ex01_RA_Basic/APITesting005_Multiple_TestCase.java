package apiRestAssured_ex01_RA_Basic;

import io.restassured.RestAssured;

public class APITesting005_Multiple_TestCase {

    public static void main(String[] args) {

        /*
         ======================================================
         TEST CASE 1: Valid Indian Pincode
         ======================================================
         Input    : 110048
         API Call : https://api.zippopotam.us/IN/110048
         Expected : Response should return location details of Delhi
         Validation : Status Code = 200 OK
         */
    	 String pincode = "110048";
         System.out.println("🚀 Running Test Case 1: Valid Indian Pincode (" + pincode + ")");
         RestAssured
                 .given()
                     .baseUri("https://api.zippopotam.us")
                     .basePath("/IN/" + pincode)
                 .when()
                     .get()
                 .then()
                     .log().all()
                     .statusCode(200);
         System.out.println("✅ Test Case 1 Passed: Valid pincode returned 200 OK\n");


     


        /*
         ======================================================
         TEST CASE 2: Invalid Pincode (Special Character)
         ======================================================
         Input    : @
         API Call : https://api.zippopotam.us/IN/@
         Expected : API should ideally return 404 (Not Found)
         Current Code : Validating statusCode(200) → This may fail
         */
      
        pincode = "@";
        System.out.println("🚀 Running Test Case 2: Invalid Pincode (" + pincode + ")");
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(404); // Negative test → should return 404
        System.out.println("✅ Test Case 2 Passed: Invalid pincode returned 404 Not Found\n");
        /*
         ======================================================
         TEST CASE 3: Empty Pincode with Wrong Country Code
         ======================================================
         Input    : " " (empty space)
         API Call : https://api.zippopotam.us/USA/ 
         Expected : API should ideally return 404 (Not Found)
         Current Code : Validating statusCode(200) → This may fail
         */
        pincode = " ";
        System.out.println("🚀 Running Test Case 3: Empty Pincode with USA Country");
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/USA/" + pincode)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(404); // Negative test → should return 404
        System.out.println("✅ Test Case 3 Passed: Wrong country + empty pincode returned 404 Not Found\n");


        /*
         ======================================================
         SUMMARY
         ======================================================
        */
        System.out.println("🎯 All test cases executed successfully!");
    }
}

/*
 ✅ SUMMARY:
 1. This program runs multiple test cases using Rest Assured.
 2. Test Case 1 → Valid Indian Pincode (110048) → Expected 200 OK.
 3. Test Case 2 → Invalid Pincode "@" → Should return 404, but code expects 200 (not ideal).
 4. Test Case 3 → Empty Pincode with USA code → Should return 404, but code expects 200 (not ideal).
 5. Best Practice → Update negative test cases to expect correct error codes (like 404).
*/
