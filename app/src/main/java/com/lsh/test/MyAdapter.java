package com.lsh.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LSH on 2016/10/12.
 */

public class MyAdapter  extends BaseAdapter {

    private List<Cinema> mList;

    public MyAdapter(List<Cinema> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList!=null?mList.size():0;
    }

    @Override
    public Object getItem(int i) {
        return mList!=null?mList.get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_item, null);
            holder=new ViewHolder(view);
            view.setTag(holder);

        }
        else{
            holder= (ViewHolder) view.getTag();
        }

        Cinema cinema=mList.get(i);
        String name = cinema.getName();
        String address = cinema.getAddress();
        String grade = cinema.getGrade();
        String screenings = cinema.getScreenings();
        holder.tvName.setText(name);
        holder.tvAddress.setText(address);
        holder.tvGrade.setText(grade);
        holder.tvScreenings.setText(screenings);


        return view;
    }
    class ViewHolder {
        private TextView tvName,tvAddress,tvGrade,tvScreenings;

        public ViewHolder(View view){
            tvName= (TextView) view.findViewById(R.id.name);
            tvAddress= (TextView) view.findViewById(R.id.address);
            tvGrade= (TextView) view.findViewById(R.id.grade);
            tvScreenings= (TextView) view.findViewById(R.id.screenings);
        }
    }
}
