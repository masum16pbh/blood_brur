package com.example.blood;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;//Activity may
    public List<Doner> donerList;
    LayoutInflater inflater;

//    public MyAdapter( Context context, List<Doner>donerList) {
//        super(context,R.layout.simple_layout,donerList);
//        this.context = context;
//        this.donerList = donerList;
//    }

    //    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.simple_layout,parent,false);
//        Doner doner = donerList.get(position);
//        System.out.println(doner);
//        TextView name = view.findViewById(R.id.nameViewId);
//        TextView blood = view.findViewById(R.id.BloodViewId);
//        name.setText("Name "+doner.getName());
//        blood.setText("Blood "+doner.getBlood());
//
//        return view;
//    }
    public MyAdapter(Context context2, List<Doner> donerList1) {
        this.context = context2;
        this.donerList = donerList1;

    }

    @Override
    public int getCount() {
        return donerList.size();
    }

    @Override
    public Object getItem(int i) {
        return donerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.simple_layout, viewGroup, false);
        }
        Doner doner1 = (Doner) getItem(i);
        TextView name = view.findViewById(R.id.nameViewId);
        TextView blood = view.findViewById(R.id.BloodViewId);
        name.setText(doner1.getName());
        blood.setText("Blood groop : " + doner1.getBlood());

        return view;
    }
}
