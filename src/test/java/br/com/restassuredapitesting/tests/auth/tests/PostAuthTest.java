package br.com.restassuredapitesting.tests.auth.tests;

import br.com.restassuredapitesting.suites.AcceptanceTests;
import br.com.restassuredapitesting.suites.AllTests;
import br.com.restassuredapitesting.suites.ContractTests;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
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

@Feature("Autenticação.")
public class PostAuthTest extends BaseTest {
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Category({AcceptanceTests.class, br.com.restassuredapitesting.suites.AllTests.class})
    @DisplayName("Realizar login.")
    public void validarLogin(){
        postAuthRequest.token()
                .then()
                .statusCode(200)
                .body("token",notNullValue());
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({ContractTests.class, AllTests.class})
    @DisplayName("Garantir o contrato do retorno de autenticação.")
    public void garantirContratoLogin(){
        postAuthRequest.token()
                .then()
                .statusCode(200)
                .assertThat()
                    .body(matchesJsonSchema(new File(Utils.getContractsBasePath("auth","auth"))));
    }
}
