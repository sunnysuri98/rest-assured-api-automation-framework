package com.demo.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.api.base.AuthService;
import com.demo.api.base.UserManagementService;
import com.demo.api.models.request.LoginRequest;
import com.demo.api.models.response.LoginResponse;
import com.demo.api.models.response.ProfileDetailsResponse;

import io.restassured.response.Response;

import org.testng.annotations.Listeners;

@Listeners(com.demo.api.listeners.TestListener.class)

public class ProfileDetailsApiTest {

    @Test(description = "Verify profile details api is working fine...")
    public void profileDetailTest() {

        AuthService auth = new AuthService();

       LoginRequest payload = new LoginRequest(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"));

        Response resp = auth.login(payload);

        LoginResponse lResponse = resp.as(LoginResponse.class);


        UserManagementService user = new UserManagementService();

        Response response = user.profileInfo(lResponse.getToken());

        ProfileDetailsResponse details = response.as(ProfileDetailsResponse.class);

        Assert.assertEquals(details.getUsername(), "studdy_buddy");
        Assert.assertEquals(details.getId(), 2680);



    }

}
