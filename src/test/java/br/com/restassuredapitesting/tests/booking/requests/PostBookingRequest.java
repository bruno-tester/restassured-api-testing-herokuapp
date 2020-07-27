package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.booking.payloads.BookingPayload;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {

    BookingPayload bookingPayload = new BookingPayload();

    public Response criarReserva(String typePayload, String accept){
        return given()
                    .contentType(ContentType.JSON)
                    .accept(accept)
                .when()
                    .body(bookingPayload.alterAndCreatBooking(typePayload))
                    .post("booking");
    }

    @Step("Criar uma reserva.")
    public Response criarReservaComPayloadValido(){
        return this
                .criarReserva("simplePayload","application/json");
    }

    @Step("Tentar criar uma reserva com payload inválido.")
    public Response criarReservaComPayloadInvalido(){
        return this
                .criarReserva("invalidPayload","application/json");
    }

    @Step("Tentar criar uma reserva com payload maior que esperado.")
    public Response criarReservaComPayloadMaisAtributos(){
        return this
                .criarReserva("moreAttributePayload","application/json");
    }

    @Step("Tentar criar uma reserva com Header Accept inválido.")
    public Response criarReservaComHeaderInvalido(){
        return this
                .criarReserva("moreAttributePayload","application/javascript");
    }
}
