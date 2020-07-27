package br.com.restassuredapitesting.utils;

import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class Utils extends BaseTest {
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    public static  String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/restassuredapitesting/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }

    public static String getDate(String dateFormat, Integer dateFutureMin, Integer dateFutureMax) {
        Faker faker = new Faker();
        DateFormat dateFormatChoosed = new SimpleDateFormat(dateFormat);
        return dateFormatChoosed.format(faker.date().future(faker.random().nextInt(dateFutureMin,dateFutureMax), TimeUnit.DAYS));
    }

    @Step("Busca ID de reserva.")
    public static int getIdBooking(){
        return given()
                    .contentType(ContentType.JSON)
                    .accept("application/json")
                .when()
                    .get("booking")
                .then()
                    .statusCode(200)
                    .extract()
                        .path("bookingid[0]");
    }

    @Step("Busca dado da reserva.")
    public static String getInfoBooking(String attribute){
        return given()
                    .contentType(ContentType.JSON)
                    .accept("application/json")
                .when()
                    .get("booking/"+ getIdBooking())
                .then()
                    .statusCode(200)
                    .extract()
                        .path(attribute);
    }
}
