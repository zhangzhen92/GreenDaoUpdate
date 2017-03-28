package com.example.lzc.greendaodemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lzc.greendaodemo.R;
import com.example.lzc.greendaodemo.dao.User;

import java.util.List;

/**
 * 类描述：ListView适配器
 * 创建人：zz
 * 创建时间： 2017/2/15 15:18
 */


public class ListViewAdapter extends MyBaseAdapter<User>{
    public ListViewAdapter(List<User> datas, Context context) {
        super(datas, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = getInflater().inflate(R.layout.listview_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(!TextUtils.isEmpty(getItem(position).getName())){
            viewHolder.textUserName.setText(getItem(position).getName());
        }
        if(!TextUtils.isEmpty(getItem(position).getPassWord())){
            viewHolder.textPassWord.setText(getItem(position).getPassWord());
        }
        if(!TextUtils.isEmpty(getItem(position).getId()+"")){
            viewHolder.textViewId.setText(getItem(position).getId()+"");
        }
        return convertView;
    }

    class ViewHolder{
        private TextView textUserName;
        private TextView textPassWord;
        private TextView textViewId;
        public ViewHolder(View convertView){
          textUserName = ((TextView) convertView.findViewById(R.id.textview_username));
            textPassWord = ((TextView) convertView.findViewById(R.id.textview_password));
            textViewId = ((TextView) convertView.findViewById(R.id.textview_id));
        }
    }
}
