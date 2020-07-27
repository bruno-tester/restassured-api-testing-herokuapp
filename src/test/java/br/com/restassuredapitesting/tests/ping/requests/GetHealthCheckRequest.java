package br.com.restassuredapitesting.tests.ping.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetHealthCheckRequest {
    public Response healthCheck(){
        return given()
                .when()
                .get("ping");
    }
}
