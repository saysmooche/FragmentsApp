package com.bb.fragmentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bb.fragmentsapp.Fragments.FragmentFraggle;
import com.bb.fragmentsapp.Fragments.SecondFragment;
import com.bb.fragmentsapp.Model.GitResult;
import com.bb.fragmentsapp.Network.GitRetrofitInstance;
import com.bb.fragmentsapp.Util.ErrorLogger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FragmentFraggle fragmentFraggle = new FragmentFraggle();
    private SecondFragment secondFragment = new SecondFragment();

    private Button button;

    private GitRetrofitInstance retrofitInstance = new GitRetrofitInstance();

    private SecondFragment repositoryFragment = new SecondFragment();
    private FragmentFraggle gitUserFragment = new FragmentFraggle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        getRepositories();
    }

    public void getRepositories(){

        retrofitInstance.getRepos("saysmooche").enqueue(new Callback<List<GitResult>>() {
            @Override
            public void onResponse(Call<List<GitResult>> call, Response<List<GitResult>> response) {
                showFragments(response.body());
            }

            @Override
            public void onFailure(Call<List<GitResult>> call, Throwable t) {
//                ErrorLogger.logError(new Exception(t));
            }
        });
    }
    private void showFragments(List<GitResult> gitResults){
        Bundle repositoryBundle = new Bundle();

        TransportObj transportObj = new TransportObj(gitResults);
//        repositoryBundle.putParcelable("FRAG_KEY", transportObj);
        repositoryFragment.setArguments(repositoryBundle);

//        getSupportFragmentManager().beginTransaction().add(R.id.fragfram, fragmentFraggle).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fram_layout, repositoryFragment).commit();
    }
    public void openFragments(View view){
//        getSupportFragmentManager().beginTransaction().add(R.id.fragfram, fragmentFraggle).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fram_layout, secondFragment).commit();
    }
    public static class DataNoteImformation
    {
        public static String[] textArray = {"Lightshot"};
        public static String[] dateArray = {"2017-04-25"};
        public static String[] id = {"1"};

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
