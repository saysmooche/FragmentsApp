package com.bb.fragmentsapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bb.fragmentsapp.Model.GitResult;
import com.bb.fragmentsapp.R;
import com.bb.fragmentsapp.TransportObj;
import com.bb.fragmentsapp.Util.Constants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.ButterKnife;



public class FragmentFraggle extends Fragment {

    List<GitResult> gitList;

    public FragmentFraggle() {

    }

    public static FragmentFraggle newInstance(String param1, String param2) {
        FragmentFraggle fragment = new FragmentFraggle();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fraggle, container, false);
    }

    public void onCreated(@NonNull View view, Bundle savedInstanceState, Fragment getContext)
    {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        gitList = ((TransportObj)getArguments().getParcelable(Constants.FRAG_KEY)).getGitResults();
        setUpViews(getContext);
    }

    private void setUpViews(Fragment getContext){
//        @Glide.with(getContext))
//                .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
//                .load(gitList.get(0).getOwner()getAvatarUrl())
//                .into(userImageView);

    }
    List<GitResult> results = ((TransportObj)getArguments().getParcelable("FRAG_KEY")).getGitResults();

}
