package com.xinyada.twolistview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 123 on 2016/10/14.
 */
public class RightAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> list;
    private View view;
    private Holder holder;

    public RightAdapter(Context context, ArrayList<String> leftlist) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(context, R.layout.right_listview, null);
            holder = new Holder(view);
            view.setTag(holder);

        } else {
            holder = (Holder) view.getTag();
        }
        holder.tv_right.setText(list.get(i).toString());
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   list.set(i,"ni ma bi");
                Toast.makeText(context, "点击了添加按钮", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private static class Holder {
        TextView tv_right_number;
        TextView tv_right;
        Button btn_add;

        public Holder(View view) {
            tv_right_number = (TextView) view.findViewById(R.id.tv_right_number);
            tv_right = (TextView) view.findViewById(R.id.tv_right);
            btn_add = (Button) view.findViewById(R.id.btn_add);
        }

    }
}
