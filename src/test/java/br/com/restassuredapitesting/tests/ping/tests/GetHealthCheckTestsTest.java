package br.com.restassuredapitesting.tests.ping.tests;

import br.com.restassuredapitesting.suites.HealthCheckTests;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.ping.requests.GetHealthCheckRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GetHealthCheckTestsTest extends BaseTest {
    GetHealthCheckRequest healthCheckRequest = new GetHealthCheckRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(HealthCheckTests.class)
    @DisplayName("Validar status da aplicação.")
    public void validarStatusDaAplicacao(){
        healthCheckRequest.healthCheck()
                .then()
                .statusCode(201);
    }
}
