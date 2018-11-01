package com.example.wuyou.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wuyou on 2018/10/31.
 */

public class CostListAdapter extends BaseAdapter{

    private List<CostBean> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CostListAdapter(Context context,List<CostBean> list){

        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewholder;
        if (view == null){
            viewholder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.list_item,null);
            viewholder.costTitle = (TextView) view.findViewById(R.id.tv_title);
            viewholder.costDate = (TextView) view.findViewById(R.id.tv_date);
            viewholder.costMoney = (TextView) view.findViewById(R.id.tv_money);
            view.setTag(viewholder);

        }else {

            viewholder = (ViewHolder) view.getTag();

        }


        CostBean costBean = mList.get(i);
        viewholder.costTitle.setText(costBean.costTitle);
        viewholder.costDate.setText(costBean.costDate);
        viewholder.costMoney.setText(costBean.costMoney);
        return view;

    }

    private static class ViewHolder {

        public TextView costTitle;
        public TextView costDate;
        public TextView costMoney;

    }

}
