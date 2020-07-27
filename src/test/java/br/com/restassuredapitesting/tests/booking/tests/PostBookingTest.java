package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.PostBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class PostBookingTest extends BaseTest {
    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Criar uma reserva.")
    public void validarCriarReservaComToken(){
        postBookingRequest.criarReservaComPayloadValido()
                .then()
                    .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({ContractTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Garantir o contrato do retorno de alterar reserva.")
    public void garantirContratoListaReserva(){
        postBookingRequest.criarReservaComPayloadValido()
                    .then()
                        .statusCode(200)
                        .assertThat()
                            .body(matchesJsonSchema(new File(Utils.getContractsBasePath("booking","novaReserva"))));
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Category(AllTests.class)
    @DisplayName("Verificar erro ao enviar payload inválido.")
    public void validarErroCriarReservaPayloadInvalido(){
        postBookingRequest.criarReservaComPayloadInvalido()
                .then()
                    .statusCode(500);
    }
    @Test
    @Severity(SeverityLevel.MINOR)
    @Category(AllTests.class)
    @DisplayName("Validar criação de reserva ao enviar payload com mais atributos.")
    public void validarCriarReservaPayloadMaisAtributos(){
        postBookingRequest.criarReservaComPayloadMaisAtributos()
                .then()
                    .statusCode(200);
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Category(AllTests.class)
    @DisplayName("Validar criação de reserva ao enviar payload com mais atributos.")
    public void validarErroCriarReservaAcceptInvalido(){
        postBookingRequest.criarReservaComHeaderInvalido()
                .then()
                    .statusCode(418);
    }
}
