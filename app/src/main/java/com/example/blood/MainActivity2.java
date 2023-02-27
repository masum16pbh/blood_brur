package com.example.blood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

//    private ListView listView;
//    DatabaseReference databaseReference;
//    private List<Doner> donerList;
//    //private CustomAdapter adapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        databaseReference = FirebaseDatabase.getInstance().getReference("doner");
//        donerList = new ArrayList<>();
//       // adapter = new CustomAdapter(MainActivity2.this,donerList);
//        listView = findViewById(R.id.list2Id);
//    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                donerList.clear();
//                for (DataSnapshot dataSnapshot1: snapshot.getChildren()){
//                    Doner doner3 = dataSnapshot1.getValue(Doner.class);
//                    donerList.add(doner3);
//                }
//                listView.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
    DatabaseReference databaseReference;
    private List<Doner> donerListArray;
    private ListView listView2;
    MyAdapter adapterq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseReference = FirebaseDatabase.getInstance().getReference("doner");
        donerListArray = new ArrayList<>();
        listView2 = findViewById(R.id.list2Id);
        adapterq = new MyAdapter(MainActivity2.this,donerListArray);
        listView2.setAdapter(adapterq);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Doner doner = new Doner();
                doner = donerListArray.get(i);
                Intent intent2 = new Intent(MainActivity2.this,DitelsActivity.class);
                intent2.putExtra("Day", doner.getDd());
                intent2.putExtra("Month",doner.getMm());
                intent2.putExtra("Year", doner.getYy());
                intent2.putExtra("Name",doner.getName());
                intent2.putExtra("Blood",doner.getBlood());
                intent2.putExtra("Upozela",doner.getUpozela());
                intent2.putExtra("Zela",doner.getZela());
                intent2.putExtra("Phone",doner.getMobile());

                startActivity(intent2);
            }
        });
    }


    @Override
    protected void onStart() {

        adapterq = new MyAdapter(MainActivity2.this,donerListArray);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                donerListArray.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Doner doner = dataSnapshot.getValue(Doner.class);
                    donerListArray.add(doner);
                }
                listView2.setAdapter(adapterq);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        super.onStart();
    }
}