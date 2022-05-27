package com.example.dogmap.database;

import com.example.dogmap.modules.Dog;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DogService {
    @GET("dogs")
    Call<List<Dog>> getDogs();

    @POST("dogs")
    Call<Dog> createDog(@Body Dog dog);
}
