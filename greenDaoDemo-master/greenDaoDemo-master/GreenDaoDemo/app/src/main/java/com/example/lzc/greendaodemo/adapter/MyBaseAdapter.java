package com.example.lzc.greendaodemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 类描述：适配器基类
 * 创建人：zz
 * 创建时间： 2017/2/14 10:56
 */


public abstract class MyBaseAdapter<T> extends BaseAdapter{
    private List<T> datas;
    private LayoutInflater inflater;

    public MyBaseAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position,convertView,parent);
    }

    public abstract View getItemView(int position, View convertView, ViewGroup parent);

    /**
     * 数据源更新
     * @param dd
     */
    public void addAll(List<T> dd){
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    public void clear(){
        datas.clear();
        notifyDataSetChanged();
    }
}
