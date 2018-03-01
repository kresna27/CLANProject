package com.clan.clan.Fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.clan.clan.Activities.VenueActivity;
import com.clan.clan.Adapter.WordListAdapter;
import com.clan.clan.R;

import java.util.LinkedList;

/**
 * Created by K on 2/21/2018.
 */

public class Tab1VenueList extends Fragment{
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<String> mWordList = new LinkedList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        for (int i = 0; i < 20; i++) {
            // Put initial data into the word list.
            mWordList.addLast("Word " + i);
            Log.d("WordList", mWordList.getLast());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view  = inflater.inflate(R.layout.fragment_tab1_coffeeshop,container,false);

        Button ButtonVenueTest = (Button) view.findViewById(R.id.ButtonTestVenue);
        ButtonVenueTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent venuetest = new Intent(getActivity(), VenueActivity.class);
                startActivity(venuetest);
            }
        });
        // Create recycler view.
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewCoffeeShop);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(getContext(), mWordList);
        // Connect the adapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);
        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}