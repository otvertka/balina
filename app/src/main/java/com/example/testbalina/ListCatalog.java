package com.example.testbalina;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ListCatalog extends Fragment {

    private static final String TAG = "myLogs";

    private Shop shop;
    private RecyclerView mRecyclerView;

    public void setShopObject(Shop shop){
        this.shop = shop;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.posts_recycle_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Log.d(TAG, "onActivityCreated ListCatalog...");

        MainActivity act = (MainActivity ) getActivity();

        PostsAdapter mPostAdapter = new PostsAdapter(shop, act);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setAdapter(mPostAdapter);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
