package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class DitelsActivity extends AppCompatActivity {
    int cmm,cdd,cyy,day,month,year;
    String name,blood,upozela,zela,phone;
    EditText Mobile;
    TextView bistarito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detals);
        DatePicker date = new DatePicker(this);
        cdd = date.getDayOfMonth();
        cmm = date.getMonth()+1;
        cyy = date.getYear();
        Mobile = findViewById(R.id.mobileViewId);
        bistarito = findViewById(R.id.dnameViewId);

        Intent i = getIntent();
        day = i.getIntExtra("Day",1);
        month = i.getIntExtra("Month",1);
        year = i.getIntExtra("Year",2020);
        name = i.getStringExtra("Name");
        blood = i.getStringExtra("Blood");
        upozela = i.getStringExtra("Upozela");
        zela = i.getStringExtra("Zela");
        phone = i.getStringExtra("Phone");
        bistarito.setText(name+"\n"+blood+"\n"+upozela+", "+zela+"\nLast donation date "+day+"/"+month+"/"+year+"\nToday "+cdd+"/"+cmm+"/"+cyy);

        day = (cyy-year)*360+(cmm-month)*30+cdd-day;
        if(day>105) Mobile.setText("Mob: "+phone);
        else {
            Mobile.setText("তিনি আর "+(106-day) +" দিন পরে রক্ত দান করতে পারবেন");
        }
    }
}