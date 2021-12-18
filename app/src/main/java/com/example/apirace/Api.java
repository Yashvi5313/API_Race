package com.example.apirace;

import com.example.apirace.Model.Root;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("results.json")
    Call<Root> getcontact();
}
