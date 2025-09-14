package com.demo.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.api.base.AuthService;
import com.demo.api.base.UserManagementService;
import com.demo.api.models.request.LoginRequest;
import com.demo.api.models.request.UpdateProfileRequest;
import com.demo.api.models.response.LoginResponse;
import com.demo.api.models.response.UpdateProfileResponse;
import com.demo.api.utils.TestDataGenerator;

import io.restassured.response.Response;

import org.testng.annotations.Listeners;

@Listeners(com.demo.api.listeners.TestListener.class)

public class UpdateProfileApiTest {

    @Test(description = "Verify update profile api is working fine...")
    public void updateProfileTest() {

        AuthService auth = new AuthService();

        LoginRequest payload = new LoginRequest(System.getenv("API_USERNAME"), System.getenv("API_PASSWORD"));
        

        Response resp = auth.login(payload);

        LoginResponse lResponse = resp.as(LoginResponse.class);

        String firstName = TestDataGenerator.firstName();
        String lastName = TestDataGenerator.lastName();
        String email = TestDataGenerator.email();
        String mobileNumber = TestDataGenerator.mobileNumber();

        UpdateProfileRequest request = new UpdateProfileRequest(firstName, lastName, email, mobileNumber);
        UserManagementService user = new UserManagementService();

        Response response = user.updateProfile(lResponse.getToken(), request);

        System.out.println(response.asPrettyString());

        UpdateProfileResponse updateProfileResponse = response.as(UpdateProfileResponse.class);

        Assert.assertEquals(updateProfileResponse.getEmail(), email);
        Assert.assertEquals(updateProfileResponse.getFirstName(), firstName);
        Assert.assertEquals(updateProfileResponse.getLastName(), lastName);
        Assert.assertEquals(updateProfileResponse.getMobileNumber(), mobileNumber);

    }

}
