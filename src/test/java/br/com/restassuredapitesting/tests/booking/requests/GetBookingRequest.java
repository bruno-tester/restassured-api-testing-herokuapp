package br.com.restassuredapitesting.tests.booking.requests;

import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    public Response allBooking(String param1, String objeto1, String param2, String objeto2) {
        return given()
                    .contentType(ContentType.JSON)
                    .accept("application/json")
                    .queryParams(param1, objeto1, param2, objeto2)
                .when()
                    .get("booking");
    }

    @Step("Buscar todas as reservas.")
    public Response listaBooking() {
        return this.allBooking("", "", "", "");
    }

    @Step("Buscar todas as reservas com filtro de firstname.")
    public Response listaBookingFiltroFirstname() {
        return this.allBooking("firstname", Utils.getInfoBooking("firstname"), "", "");
    }

    @Step("Buscar todas as reservas com filtro de lastname.")
    public Response listaBookingFiltroLastname() {
        return this.allBooking("lastname", Utils.getInfoBooking("lastname"), "", "");
    }

    @Step("Buscar todas as reservas com filtro de checkin.")
    public Response listaBookingFiltroCheckin() {
        return this.allBooking("bookingdates.checkin", Utils.getInfoBooking("bookingdates.checkin"), "", "");
    }

    @Step("Buscar todas as reservas com filtro de checkout.")
    public Response listaBookingFiltroCheckout() {
        return this.allBooking("checkout", Utils.getInfoBooking("bookingdates.checkout"), "", "");
    }

    @Step("Buscar todas as reservas com filtros de checkout e checkin.")
    public Response listaBookingFiltrosCheckinCheckin() {
        return this.allBooking("bookingdates.checkin", Utils.getInfoBooking("bookingdates.checkin"), "bookingdates.checkout", Utils.getInfoBooking("bookingdates.checkout"));
    }

    @Step("Busca detalhes de uma reserva.")
    public Response detalhesReserva() {
        return given()
                    .contentType(ContentType.JSON)
                    .accept("application/json")
                .when()
                    .get("booking/" + Utils.getIdBooking());
    }
}