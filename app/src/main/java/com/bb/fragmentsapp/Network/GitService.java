package com.bb.fragmentsapp.Network;

import com.bb.fragmentsapp.Model.GitResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitService {
    @GET("/users/{userName}/repos")
    public Call<List<GitResult>> getRepo(@Path("userName")String userName);
}
