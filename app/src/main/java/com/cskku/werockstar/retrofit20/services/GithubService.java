package com.cskku.werockstar.retrofit20.services;

import com.cskku.werockstar.retrofit20.models.Github;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("/users/{user}")
    Call<Github> getUserInfo(@Path("user") String user);
}
