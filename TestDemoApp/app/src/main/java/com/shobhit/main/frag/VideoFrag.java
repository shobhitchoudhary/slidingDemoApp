package com.shobhit.main.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shobhit.main.PojoClass;
import com.shobhit.main.R;
import com.shobhit.main.adap.ItemAdap;
import com.shobhit.main.utility.ItemDecorationRvItems;

import java.util.ArrayList;

/**
 * Created by hello on 20-Jul-17.
 */

public class VideoFrag extends Fragment
{
    private ArrayList<PojoClass> arrayListItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayListItem=new ArrayList<>();

        // first item
        PojoClass pojoClass1=new PojoClass();
        pojoClass1.setHeading(getResources().getString(R.string.emptiness_ft));
        pojoClass1.setSubheading(getResources().getString(R.string.loream_lpsum));
        pojoClass1.setHour(getResources().getString(R.string.time2));
        pojoClass1.setImage(R.drawable.everest);
        arrayListItem.add(pojoClass1);

        // second item
        PojoClass pojoClass2=new PojoClass();
        pojoClass2.setHeading(getResources().getString(R.string.i_am_falling));
        pojoClass2.setSubheading(getResources().getString(R.string.loream_lpsum));
        pojoClass2.setHour(getResources().getString(R.string.time3));
        pojoClass2.setImage(R.drawable.aclema);
        arrayListItem.add(pojoClass2);

        // Third item
        PojoClass pojoClass3=new PojoClass();
        pojoClass3.setHeading(getResources().getString(R.string.baby_fit_justin));
        pojoClass3.setSubheading(getResources().getString(R.string.loream_lpsum));
        pojoClass3.setHour(getResources().getString(R.string.time4));
        pojoClass3.setImage(R.drawable.occasion);
        arrayListItem.add(pojoClass3);

        // fouth item
        PojoClass pojoClass4=new PojoClass();
        pojoClass4.setHeading(getResources().getString(R.string.emptiness_ft));
        pojoClass4.setSubheading(getResources().getString(R.string.loream_lpsum));
        pojoClass4.setHour(getResources().getString(R.string.time2));
        pojoClass4.setImage(R.drawable.everest);
        arrayListItem.add(pojoClass4);

        // Fifth item
        PojoClass pojoClass5=new PojoClass();
        pojoClass5.setHeading(getResources().getString(R.string.i_am_falling));
        pojoClass5.setSubheading(getResources().getString(R.string.loream_lpsum));
        pojoClass5.setHour(getResources().getString(R.string.time3));
        pojoClass5.setImage(R.drawable.aclema);
        arrayListItem.add(pojoClass5);

        // Sixth item
        PojoClass pojoClass6=new PojoClass();
        pojoClass6.setHeading(getResources().getString(R.string.baby_fit_justin));
        pojoClass6.setSubheading(getResources().getString(R.string.loream_lpsum));
        pojoClass6.setHour(getResources().getString(R.string.time4));
        pojoClass6.setImage(R.drawable.occasion);
        arrayListItem.add(pojoClass6);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.frag_videos,container,false);
        RecyclerView rV_videos = (RecyclerView) view.findViewById(R.id.rV_videos);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        ItemAdap itemAdap=new ItemAdap(arrayListItem);
        rV_videos.setLayoutManager(linearLayoutManager);
        rV_videos.setAdapter(itemAdap);

        // add spacing
        int spanCount = 1; // 3 columns
        int spacing = 15; // 50px
        rV_videos.addItemDecoration(new ItemDecorationRvItems(spanCount, spacing, true));
        return view;
    }

}
