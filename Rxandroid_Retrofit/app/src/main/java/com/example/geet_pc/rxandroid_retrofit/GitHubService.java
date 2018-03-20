package com.example.geet_pc.rxandroid_retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by aplitelinux1 on 3/2/17.
 */

public interface GitHubService {
    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);
//    Call<List<Repo>> listRepos(@Path("user") String user);
}
