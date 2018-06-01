package com.arkarzaw.simplehabit.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkarzaw.simplehabit.adapters.CateRcAdapter;
import com.arkarzaw.simplehabit.adapters.TopicRcAdapter;
import com.arkarzaw.simplehabit.datas.Models.ItemModel;
import com.arkarzaw.simplehabit.datas.Models.TopicModel;
import com.arkarzaw.simplehabit.R;

import java.util.ArrayList;

public class SeriesFragment extends Fragment {
    RecyclerView rcPlayList,rcHealthyMind,rcNewHabit,rcPopular,rcTopics;
    ArrayList<ItemModel> itemList;
    ArrayList<TopicModel> tpList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        rcPlayList = view.findViewById(R.id.rcPlayList);
        rcHealthyMind = view.findViewById(R.id.rcHealthyMind);
        rcPopular = view.findViewById(R.id.rcPopular);
        rcNewHabit = view.findViewById(R.id.rcNewHabit);
        rcTopics = view.findViewById(R.id.rcTopics);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        setPlayList();
        setNew();
        setHealthy();
        setPopular();
        setTopic();
        super.onActivityCreated(savedInstanceState);


    }

    private void setPopular() {
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.healthy1,"Deal with Depression","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy2,"Calm Nerves","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy3,"Kindness of Self","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy4,"Kindness of Self","5.19.20 mins"));
        rcPopular.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        CateRcAdapter adapter = new CateRcAdapter(getContext());
        rcPopular.setAdapter(adapter);
        rcPopular.setNestedScrollingEnabled(false);
    }

    private void setTopic() {
        tpList= new ArrayList<>();
        tpList.add(new TopicModel(R.drawable.topic1,"Basics","Learn meditation fundamentals"));
        tpList.add(new TopicModel(R.drawable.topic4,"Relax","Unwind and relieve stress"));
        tpList.add(new TopicModel(R.drawable.topic3,"Sleep","Reset effortlessly in deep sleep"));
        tpList.add(new TopicModel(R.drawable.topic4,"Well-being","inspire joy,abundance , and purpose"));
        tpList.add(new TopicModel(R.drawable.healthy1,"Basics","Learn meditation fundamentals"));
        tpList.add(new TopicModel(R.drawable.healthy2,"Relax","Unwind and relieve stress"));
        rcTopics.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        TopicRcAdapter adapter= new TopicRcAdapter(getContext(),R.layout.view_holder_topic,tpList);
        rcTopics.setAdapter(adapter);
        rcTopics.setNestedScrollingEnabled(false);
    }

    private void setHealthy() {
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.healthy1,"Deal with Depression","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy2,"Calm Nerves","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy3,"Kindness of Self","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy4,"Kindness of Self","5.19.20 mins"));
        rcHealthyMind.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        CateRcAdapter adapter = new CateRcAdapter(getContext());
        rcHealthyMind.setAdapter(adapter);
        rcHealthyMind.setNestedScrollingEnabled(false);
    }

    private void setNew() {
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.healthy1,"Deal with Depression","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy2,"Calm Nerves","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy3,"Kindness of Self","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy4,"Kindness of Self","5.19.20 mins"));
        rcNewHabit.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        CateRcAdapter adapter = new CateRcAdapter(getContext());
        rcNewHabit.setAdapter(adapter);
        rcNewHabit.setNestedScrollingEnabled(false);
    }

    private void setPlayList() {
        itemList = new ArrayList<>();
        itemList.add(new ItemModel(R.drawable.healthy1,"Deal with Depression","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy2,"Calm Nerves","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy3,"Kindness of Self","5.19.20 mins"));
        itemList.add(new ItemModel(R.drawable.healthy4,"Kindness of Self","5.19.20 mins"));
        rcPlayList.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        CateRcAdapter adapter = new CateRcAdapter(getContext());
        rcPlayList.setAdapter(adapter);
        rcPlayList.setNestedScrollingEnabled(false);
    }
}
