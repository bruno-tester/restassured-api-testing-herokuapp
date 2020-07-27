package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

@Feature("Reservas.")
public class GetBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest= new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Listar IDs das Reservas.")
    public void  validarIdsDasReservas(){
        getBookingRequest.listaBooking()
                .then()
                    .statusCode(200)
                    .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({ContractTests.class, AllTests.class})
    @DisplayName("Garantir o contrato do retorno de lista de reservas.")
    public void garantirContratoListaReservas(){
        getBookingRequest.listaBooking()
                .then()
                    .statusCode(200)
                    .assertThat()
                        .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking","listaReserva"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Detalhes de uma Reserva.")
    public void  validarDetalhesDaReserva(){
        getBookingRequest.detalhesReserva()
                .then()
                    .statusCode(200)
                    .body("firstname", notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({ContractTests.class, AllTests.class})
    @DisplayName("Garantir o contrato do retorno dos detalhes de uma Reserva.")
    public void garantirContratoDetalhesDaReserva(){
        getBookingRequest.detalhesReserva()
                .then()
                    .statusCode(200)
                    .assertThat()
                        .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking","detalhesReserva"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Lista de reservas aplicando filtro firstname.")
    public void  validarReservasFiltroFirstname(){
        getBookingRequest.listaBookingFiltroFirstname()
                .then()
                    .statusCode(200)
                    .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Lista de reservas aplicando filtro lastname.")
    public void  validarReservasFiltroLastName(){
        getBookingRequest.listaBookingFiltroLastname()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Lista de reservas aplicando filtro checkin.")
    public void  validarReservasFiltroCheckin(){
        getBookingRequest.listaBookingFiltroCheckin()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Lista de reservas aplicando filtro checkout.")
    public void  validarReservasFiltroCheckout(){
        getBookingRequest.listaBookingFiltroCheckout()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Lista de reservas aplicando filtros checkout e checkin.")
    public void  validarReservasFiltrosCheckoutCheckin(){
        getBookingRequest.listaBookingFiltrosCheckinCheckin()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }
}
