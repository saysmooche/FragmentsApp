package com.bb.fragmentsapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.fragmentsapp.ListAdapter;
import com.bb.fragmentsapp.Model.GitResult;
import com.bb.fragmentsapp.R;
import com.bb.fragmentsapp.TransportObj;
import com.bb.fragmentsapp.Util.ErrorLogger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondFragment extends Fragment {

    @BindView(R.id.recycle_view)
    RecyclerView gitRecyclerView;

    public SecondFragment() {
    }

    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        List<GitResult> results = ((TransportObj)getArguments().getParcelable("FRAG_KEY")).getGitResults();

//        ErrorLogger.logDebug("Results = " + results.size());

        com.bb.fragmentsapp.ListAdapter repositoryAdapter = new ListAdapter(results);
        gitRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        gitRecyclerView.setAdapter(repositoryAdapter);
    }
}
