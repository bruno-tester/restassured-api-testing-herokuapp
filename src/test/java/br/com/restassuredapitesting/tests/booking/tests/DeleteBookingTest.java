package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeleteBookingTest extends BaseTest {
    DeleteBookingRequest deleteBooking = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, AllTests.class})
    @DisplayName("Exclusão de reserva existente.")
    public void validarExclusaoDeReservaValida(){
        deleteBooking.exclusaoReservaComAcesso(Utils.getIdBooking())
                .then()
                    .statusCode(201);
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, AllTests.class})
    @DisplayName("Exclusão de reserva inexistente.")
    public void validarExclusaoDeReservaInvalida(){
        deleteBooking.exclusaoReservaComAcesso(999999999)
                .then()
                    .statusCode(405);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, AllTests.class})
    @DisplayName("Exclusão de reserva existente, mas sem acesso.")
    public void validarExclusaoDeReservaValidaSemAcesso(){
        deleteBooking.exclusaoReservaSemAcesso(Utils.getIdBooking())
                .then()
                .statusCode(403);
    }
}
