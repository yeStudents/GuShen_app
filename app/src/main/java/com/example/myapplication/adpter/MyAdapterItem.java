package com.example.myapplication.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Gupian_Bean;

import java.util.List;


/**
 *2019-3-16
 */
public class MyAdapterItem extends RecyclerView.Adapter<MyAdapterItem.ViewHolder> {

    private List<Gupian_Bean> list = null;

    private Context context = null;

    private LayoutInflater inflater = null;

    public MyAdapterItem(List<Gupian_Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_show, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Gupian_Bean gupian_bean = list.get(position);
        viewHolder.tv_gupian_name.setText(gupian_bean.getGupian_name());
        viewHolder.tv_today_price.setText(gupian_bean.getToday_price());
        viewHolder.tv_yesterday_price.setText(gupian_bean.getYesterday_price());
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return list.size();

    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_gupian_name, tv_today_price, tv_yesterday_price;

        ViewHolder(View view) {
            super(view);
            tv_gupian_name = view.findViewById(R.id.tv_gupian_name);
            tv_today_price = view.findViewById(R.id.tv_today_price);
            tv_yesterday_price = view.findViewById(R.id.tv_yesterday_price);

        }
    }
}