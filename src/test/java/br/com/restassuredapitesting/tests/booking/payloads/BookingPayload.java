package br.com.restassuredapitesting.tests.booking.payloads;

import br.com.restassuredapitesting.utils.Utils;
import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

public class BookingPayload {
    Faker faker = new Faker();
    public JSONObject alterAndCreatBooking(String typePayload) {
        JSONObject alterBooking = new JSONObject();

        if (typePayload.equalsIgnoreCase("simplePayload")) {
            JSONObject bookingdates = new JSONObject();
            bookingdates.put("checkin", Utils.getDate("yyyy-MM-dd", 1, 1));
            bookingdates.put("checkout", Utils.getDate("yyyy-MM-dd", 180, 180));

            alterBooking.put("firstname", faker.name().firstName());
            alterBooking.put("lastname", faker.name().lastName());
            alterBooking.put("totalprice", faker.number().numberBetween(100, 9999));
            alterBooking.put("depositpaid", true);
            alterBooking.put("bookingdates", bookingdates);
            alterBooking.put("additionalneeds", "Breakfast");

        } else if (typePayload.equalsIgnoreCase("invalidPayload")) {

            JSONObject bookingdates = new JSONObject();
            bookingdates.put("checkin", Utils.getDate("yyyy-MM-dd", 1, 1));
            bookingdates.put("checkout", Utils.getDate("yyyy-MM-dd", 180, 180));

            alterBooking.put("firstname", 1111);
            alterBooking.put("lastname", 38283.292);
            alterBooking.put("totalprice", "string");
            alterBooking.put("depositpaid", true);
            alterBooking.put("bookingdates", bookingdates);
            alterBooking.put("additionalneeds", "Breakfast");

        } else if(typePayload.equalsIgnoreCase("moreAttributePayload")){
            JSONObject bookingdates = new JSONObject();
            bookingdates.put("checkin", Utils.getDate("yyyy-MM-dd", 1, 1));
            bookingdates.put("checkout", Utils.getDate("yyyy-MM-dd", 180, 180));
            bookingdates.put("birthday", Utils.getDate("yyyy-MM-dd", 180, 180));

            alterBooking.put("fullname", faker.name().fullName());
            alterBooking.put("firstname", faker.name().firstName());
            alterBooking.put("lastname", faker.name().lastName());
            alterBooking.put("totalprice", faker.number().numberBetween(100, 9999));
            alterBooking.put("depositpaid", true);
            alterBooking.put("bookingdates", bookingdates);
            alterBooking.put("additionalneeds", "Breakfast");
        } else if (typePayload.equalsIgnoreCase("withoutPayload")){
            alterBooking.put("","");
        }
        return alterBooking;
    }
}
