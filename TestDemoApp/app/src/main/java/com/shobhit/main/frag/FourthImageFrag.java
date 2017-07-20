package com.shobhit.main.frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shobhit.main.R;

/**
 * Created by hello on 20-Jul-17.
 */

public class FourthImageFrag extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frag_images,container,false);
        ImageView iV_view_image = (ImageView) view.findViewById(R.id.iV_view_image);
        iV_view_image.setImageResource(R.drawable.girovo_shop);
        return view;
    }
}