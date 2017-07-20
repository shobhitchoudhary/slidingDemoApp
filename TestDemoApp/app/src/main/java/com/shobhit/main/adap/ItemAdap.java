package com.shobhit.main.adap;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shobhit.main.PojoClass;
import com.shobhit.main.R;

import java.util.ArrayList;

/**
 * Created by hello on 20-Jul-17.
 */

public class ItemAdap extends RecyclerView.Adapter<ItemAdap.MyViewHolder>
{
    private ArrayList<PojoClass> arrayListItem;

    public ItemAdap(ArrayList<PojoClass> arrayListItem) {
        this.arrayListItem = arrayListItem;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_rv_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.iV_item_image.setImageResource(arrayListItem.get(position).getImage());
        holder.tV_header.setText(arrayListItem.get(position).getHeading());
        holder.tV_time.setText(arrayListItem.get(position).getHour());
    }

    @Override
    public int getItemCount() {
        return arrayListItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView iV_item_image;
        TextView tV_header,tV_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            iV_item_image= (ImageView) itemView.findViewById(R.id.iV_item_image);
            tV_header= (TextView) itemView.findViewById(R.id.tV_header);
            tV_time= (TextView) itemView.findViewById(R.id.tV_time);
        }
    }
}
