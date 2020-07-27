package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.booking.payloads.BookingPayload;
import br.com.restassuredapitesting.utils.Utils;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    Faker faker = new Faker();

    PostAuthRequest authRequest = new PostAuthRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();
    BookingPayload bookingPayload = new BookingPayload();

    public Response alterarReserva(String tipoAuth, String auth, int idBooking){
        return given()
                    .contentType(ContentType.JSON)
                    .accept("application/json")
                    .header(tipoAuth, auth)
               .when()
                    .body(bookingPayload.alterAndCreatBooking("simplePayload"))
                   .put("booking/" + idBooking);
    }

    @Step("Alterar uma reserva com token.")
    public Response alterarReservaToken(){
        return this.alterarReserva("Cookie", authRequest.getToken(), Utils.getIdBooking());
    }

    @Step("Alterar uma reserva com Authorization.")
    public Response alterarReservaAuthorization(){
        return this.alterarReserva("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=", Utils.getIdBooking());
    }

    @Step("Alterar uma reserva autenticação.")
    public Response alterarReservaSemToken(){
        return this.alterarReserva("","", Utils.getIdBooking());
    }

    @Step("Alterar uma reserva com token inválido.")
    public Response alterarReservaComTokenInvalido(){
        return this.alterarReserva("Cookie", faker.beer().name(), Utils.getIdBooking());
    }

    @Step("Alterar uma reserva inexistente.")
    public Response alterarReservaInexistente(){
        return this.alterarReserva("Cookie", authRequest.getToken(), 999999999);
    }
}
