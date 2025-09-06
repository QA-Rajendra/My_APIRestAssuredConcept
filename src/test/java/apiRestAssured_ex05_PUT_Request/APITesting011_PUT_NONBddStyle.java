package apiRestAssured_ex05_PUT_Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
public class APITesting011_PUT_NONBddStyle {

    // PUT

    // token, booking id - A

//    public void get_token(){ }
//    public void get_booking_id(){}

    @Description("Verify the PUT Request for the Restful Booker APIs")
    @Test
    public void test_put_non_bdd(){

        String token = "64ec151a1e677ed";
        String bookingid = "5406";

        String payloadPUT= "{\n"
        + "    \"firstname\": \"booking12326\",\n"
        + "    \"lastname\": \"akther12326\",\n"
        + "    \"totalprice\": 12326,\n"
        + "    \"depositpaid\": true,\n"
        + "    \"bookingdates\": {\n"
        + "        \"checkin\": \"2024-01-01\",\n"
        + "        \"checkout\": \"2024-01-02\"\n"
        + "    }\n"
        + "}";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
//        requestSpecification.auth().basic("admin","password123");


        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();


        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);



    }


}
