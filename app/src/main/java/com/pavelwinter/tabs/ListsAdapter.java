package com.pavelwinter.tabs;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by newuser on 08.03.2017.
 */

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.HolderClass> {

    private List<MockItemovDo> itemInfo;




    public ListsAdapter(List<MockItemovDo> itemInfo) {
        this.itemInfo = itemInfo;



         //sorts items by priority
        Collections.sort(this.itemInfo,new MockItemovDo.TuneOutput());



    }

    @Override
    public HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new HolderClass(view);
    }

    @Override
    public void onBindViewHolder(HolderClass holder, int position) {

        MockItemovDo mm=itemInfo.get(position);



        switch (mm.getPriority()){

            case 0:holder.cardView.setBackgroundColor(Color.RED);
                break;

            case 1:holder.cardView.setBackgroundColor(Color.YELLOW);
                break;

            case 2:holder.cardView.setBackgroundColor(Color.GREEN);
                break;
            default:holder.cardView.setBackgroundColor(Color.GRAY);
        }

        holder.tv_header.setText(mm.getHeader());
        holder.tv_descr.setText(mm.getDescribing());

    }

    @Override
    public int getItemCount() {
        return itemInfo.size();
    }

    public static class HolderClass extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView tv_header;
        TextView tv_descr;

        public HolderClass(View itemView) {
            super(itemView);

            cardView=(CardView)itemView.findViewById(R.id.card_view);
            tv_header=(TextView)itemView.findViewById(R.id.textViewHeader);
            tv_descr=(TextView)itemView.findViewById(R.id.textViewDescribe);

        }
    }

}
