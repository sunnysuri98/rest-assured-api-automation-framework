package com.demo.api.base;

import com.demo.api.models.request.UpdateProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {

    private static final String BASE_PATH = "/api/users/";

    public Response profileInfo(String token) {

        setToken(token);

        return getRequest(BASE_PATH + "profile");

    }

    public Response updateProfile(String token, UpdateProfileRequest updateProfileRequest) {

        setToken(token);

        return putRequest(updateProfileRequest, BASE_PATH + "profile");

    }

}
