package com.aserbao.aserbaoanimationsummart.sendgif.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aserbao.aserbaoanimationsummart.R;

import java.util.ArrayList;

/**
 * description:
 * Created by aserbao on 2017/6/10.
 */

public class GiftMsgAdapter extends RecyclerView.Adapter<GiftMsgAdapter.ViewHolder> {
    private final String TAG = getClass().getSimpleName();
    private Context context;
    private ArrayList<String> mDatas;

    public GiftMsgAdapter(Context context) {
        this.context = context;
        mDatas = new ArrayList<>();
    }

    public void add(String item){
        mDatas.add(item);
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gift_msg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mDatas.size() == 0) {
            holder.tvGiftMsg.setText("送了礼物+++++++");
        }else {
            String item = mDatas.get(position);
            holder.tvGiftMsg.setText("送了礼物" + item);
        }
    }

    @Override
    public int getItemCount() {
        if (mDatas.size() == 0 ) {
            return 5;
        }else {
            return mDatas.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder{
         private final TextView tvGiftMsg;
         public ViewHolder(View itemView) {
             super(itemView);
             tvGiftMsg = (TextView) itemView.findViewById(R.id.tv_gift_msg);
         }
     }
}
