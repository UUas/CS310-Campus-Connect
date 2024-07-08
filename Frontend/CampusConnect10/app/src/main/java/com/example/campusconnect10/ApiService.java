package com.example.campusconnect10;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("user/createuser")
    Call<Id> createUser(@Body Users user);

    @POST("user/geteuserid")
    Call<Users> getUserById(@Body String userId);
}
