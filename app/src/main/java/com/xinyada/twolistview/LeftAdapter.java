package com.xinyada.twolistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 123 on 2016/10/14.
 */
public class LeftAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Bean.AddressEntity> list;
    private Holder holder;


    public LeftAdapter(Context context, ArrayList<Bean.AddressEntity> leftlist) {
        this.context = context;
        this.list = leftlist;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(context, R.layout.left_listview, null);
            holder = new Holder(view);
            view.setTag(holder);

        } else {
            holder = (Holder) view.getTag();
        }
        holder.tvleft.setText(list.get(i).getName().toString());
        return view;
    }

    private static class Holder {
        TextView tvleft;

        public Holder(View view) {
            tvleft = (TextView) view.findViewById(R.id.tv_left);
        }
    }
}
