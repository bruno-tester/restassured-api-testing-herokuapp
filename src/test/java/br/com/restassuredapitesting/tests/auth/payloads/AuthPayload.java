package br.com.restassuredapitesting.tests.auth.payloads;

import org.json.simple.JSONObject;

public class AuthPayload {
    public JSONObject jsonPostAuth(String username, String passWord){
        JSONObject authPayload = new JSONObject();

        authPayload.put("username", username);
        authPayload.put("password", passWord);

        return authPayload;
    }
}
