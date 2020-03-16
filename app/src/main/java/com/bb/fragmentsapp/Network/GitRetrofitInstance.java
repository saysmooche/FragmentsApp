package com.bb.fragmentsapp.Network;

import com.bb.fragmentsapp.Model.GitResult;
import com.bb.fragmentsapp.Util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitRetrofitInstance {
    private GitService gitService;

    public GitRetrofitInstance() {
        gitService = createService(createRetrofit());
    }
    private Retrofit createRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private GitService createService(Retrofit retrofit) {
        return retrofit.create(GitService.class);
    }

    public Call<List<GitResult>> getRepos(String userName){
        return gitService.getRepo(userName);
    }
}
