package com.cskku.werockstar.retrofit20.services;

import com.cskku.werockstar.retrofit20.models.Github;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GithubService {

    @GET("/users/{user}")
    Call<Github> getUserInfo(@Path("user") String user);
}
