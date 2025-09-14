package com.demo.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.api.base.AuthService;
import com.demo.api.models.request.SignUpRequest;
import com.demo.api.utils.TestDataGenerator;

import io.restassured.response.Response;

import org.testng.annotations.Listeners;

@Listeners(com.demo.api.listeners.TestListener.class)

public class SignUpApiTest {

    @Test(description = "Verify signup api is working fine")

    public void signUpTest() {


        String firstName = TestDataGenerator.firstName();
        String lastName = TestDataGenerator.lastName();

        String userName = TestDataGenerator.username();
        String password = TestDataGenerator.password();
        String email = TestDataGenerator.email();
        String phoneNo= TestDataGenerator.mobileNumber();

       


        AuthService auth = new AuthService();

        SignUpRequest signupRequest = new SignUpRequest.Builder().firstName(firstName).lastName(lastName).email(email)
                .password(password).username(userName).phoneNumber(phoneNo).build();

        Response resp = auth.signUp(signupRequest);
        System.out.println(resp.asPrettyString());

        Assert.assertEquals(resp.statusCode(), 200);
        Assert.assertEquals(resp.asPrettyString(), "User registered successfully!");

    }

}
