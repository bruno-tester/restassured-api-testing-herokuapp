package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.PutBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.io.File;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

@Feature("Reservas.")
public class PutBookingTest extends BaseTest {
    PutBookingRequest putBookingRequest = new PutBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Alterar uma reserva com Token.")
    public void validarAlterarReservaComToken(){
        putBookingRequest.alterarReservaToken()
                .then()
                    .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Alterar uma reserva com Authorization.")
    public void validarAlterarReservaComAuthorization(){
        putBookingRequest.alterarReservaAuthorization()
                .then()
                .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({ContractTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Garantir o contrato do retorno de alterar reserva.")
    public void garantirContratoListaReserva(){
        putBookingRequest.alterarReservaToken()
                .then()
                    .statusCode(200)
                    .assertThat()
                        .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking","alterarReserva"))));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Validar alterar uma reserva sem autenticação.")
    public void validarAlterarReservaSemAutenticar(){
        putBookingRequest.alterarReservaSemToken()
                .then()
                    .statusCode(403);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Validar alterar uma reserva com token inválido.")
    public void validarAlterarReservaComTokenInvalido(){
        putBookingRequest.alterarReservaComTokenInvalido()
                .then()
                    .statusCode(403);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Validar alterar uma reserva com token inválido.")
    public void validarAlterarReservaInexistente(){
        putBookingRequest.alterarReservaInexistente()
                .then()
                    .statusCode(405);
    }
}
