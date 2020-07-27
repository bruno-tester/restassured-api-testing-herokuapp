package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {
    PostAuthRequest authRequest = new PostAuthRequest();

    public Response exclusaoReserva(int idReserva, String auth){
        return given()
                    .contentType(ContentType.JSON)
                    .accept("application/json")
                    .header("Cookie",auth)
                .when()
                    .delete("booking/" + idReserva);
    }

    @Step("Busca reserva para exclusão com acesso válido.")
    public Response exclusaoReservaComAcesso(int idReserva){
        return this.exclusaoReserva(idReserva, authRequest.getToken());
    }

    @Step("Busca reserva para exclusão sem acesso.")
    public Response exclusaoReservaSemAcesso(int idReserva){
        return this.exclusaoReserva(idReserva, "");
    }
}
