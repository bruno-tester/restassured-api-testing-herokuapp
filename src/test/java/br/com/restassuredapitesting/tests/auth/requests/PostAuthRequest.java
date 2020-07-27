package br.com.restassuredapitesting.tests.auth.requests;

import br.com.restassuredapitesting.tests.auth.payloads.AuthPayload;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {
    AuthPayload authPayload = new AuthPayload();

    @Step
    public Response token(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .body(authPayload.jsonPostAuth("admin","password123"))
                .post("auth");
    }

    @Step("Retornar o Token")
    public String getToken(){
        return "token="+this.token()
                    .then()
                    .statusCode(200)
                    .extract().path("token");
    }
}
