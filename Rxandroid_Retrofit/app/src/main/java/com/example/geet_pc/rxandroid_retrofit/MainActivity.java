package com.example.geet_pc.rxandroid_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    GitHubService gitHubService;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gitHubService = ApiClient.getInstance().create(GitHubService.class);

//       code 1 for using with retrofit only

//        Call<List<Repo>> result = gitHubService.listRepos("octocat");
//        result.enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                Log.e("TAG Result :", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//
//            }
//        });


//       code 2 for using with retrofit + RxJava

        Observable<List<Repo>> repoobservable = gitHubService.listRepos("octocat");
        repoobservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        Log.e("TAG RESPONSE", repos.get(0).getName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

//    private void handleError(Throwable throwable) {
//        Log.e("TAG:ERROR", "error");
//    }
//
//    private void handleResult(List<Repo> repos) {
//        Log.e("TAG", repos.get(0).getName());
//    }

    private Observable<List<Repo>> getRepoesponce(String name) {
        return gitHubService.listRepos(name);
    }
}
