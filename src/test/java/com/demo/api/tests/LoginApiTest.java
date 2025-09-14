package com.demo.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.api.base.AuthService;
import com.demo.api.models.request.LoginRequest;
import com.demo.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.demo.api.listeners.TestListener.class)
public class LoginApiTest {

    @Test(description = "Verify If login api is working...")
    public void LoginTest() {

        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"));
        

        Response resp = authService.login(loginRequest);

        System.out.println(resp.asPrettyString());

        LoginResponse loginresponse = resp.as(LoginResponse.class);

      

        Assert.assertTrue(loginresponse.getToken() != null);

    }

}
