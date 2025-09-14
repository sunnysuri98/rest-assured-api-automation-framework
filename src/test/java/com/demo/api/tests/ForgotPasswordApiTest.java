package com.demo.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.api.base.AuthService;
import com.demo.api.models.response.ForgotPasswordResponse;

import io.restassured.response.Response;

import org.testng.annotations.Listeners;

@Listeners(com.demo.api.listeners.TestListener.class)
public class ForgotPasswordApiTest {

    @Test(description = "verify forgot password api is working...")
    public void forgotPasswordTest(){


        AuthService auth=new AuthService();

        Response resp=auth.forgotPassword("magigi5581@kwifa.com");
        System.out.println(resp.asPrettyString());

        ForgotPasswordResponse forgotPasswordResponse= resp.as(ForgotPasswordResponse.class);

        System.out.println(forgotPasswordResponse.getMessage());

        Assert.assertEquals(forgotPasswordResponse.getMessage(),"If your email exists in our system, you will receive reset instructions.");


    }
    
}
