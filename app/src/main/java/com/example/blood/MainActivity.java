package com.example.blood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public EditText name;
    public Spinner bloodGroups,division, district,P_S;
    private String div,dis;
    private String[] Division,District,Upzala;
    public EditText mobile;
    private int dd,mm,yy,a,b,c;


    public EditText RDate;
    TextView dateView;
    public Button submit,viewDoner,Sdate;

    DatabaseReference bloodData;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listViewDiner = (ListView) findViewById(R.id.listViewDoner);
        bloodData = FirebaseDatabase.getInstance().getReference("doner");

        name = (EditText) findViewById(R.id.name);
        bloodGroups = (Spinner) findViewById(R.id.bloodGroup);
        mobile =(EditText) findViewById(R.id.mobileNumber);
        P_S = (Spinner) findViewById(R.id.PolishStation);
        district = (Spinner) findViewById(R.id.district);
        division = findViewById(R.id.divisionId);
        dateView = findViewById(R.id.dateTextId);
        submit = (Button) findViewById(R.id.submit);
        viewDoner = (Button) findViewById(R.id.viewDoner);
        Sdate = findViewById(R.id.editTextDate);
        Division = getResources().getStringArray(R.array.Division);
        ArrayAdapter<String> divA = new ArrayAdapter<String>(this,R.layout.spinner,R.id.SpinnerTextId,Division);
        division.setAdapter(divA);
division.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            District = getResources().getStringArray(R.array.empty);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
        }
        else if(position == 1){
            District = getResources().getStringArray(R.array.রংপুর);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position ==1){
                        Upzala = getResources().getStringArray(R.array.পঞ্চগড়);
                    }
                    else if (position ==2) {
                        Upzala = getResources().getStringArray(R.array.দিনাজপুর);
                    }else if (position ==3) {
                        Upzala = getResources().getStringArray(R.array.লালমনিরহাট);
                    }else if (position ==4) {
                        Upzala = getResources().getStringArray(R.array.নীলফামারী);
                    }else if (position ==5) {
                        Upzala = getResources().getStringArray(R.array.গাইবান্ধা);
                    }else if (position ==6) {
                        Upzala = getResources().getStringArray(R.array.ঠাকুরগাঁও);
                    }else if (position ==7) {
                        Upzala = getResources().getStringArray(R.array.রংপুর_);
                    }else if (position ==8) {
                        Upzala = getResources().getStringArray(R.array.কুড়িগ্রাম);
                    }
                    else {
                        Upzala = getResources().getStringArray(R.array.empty);
                    }

                    ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                    P_S.setAdapter(upazalaA);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if (position == 2) {
            District = getResources().getStringArray(R.array.খুলনা);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position ==1){
                        Upzala = getResources().getStringArray(R.array.যশোর);
                    }
                    else if (position ==2) {
                        Upzala = getResources().getStringArray(R.array.সাতক্ষীরা);
                    }
                    else if (position ==3) {
                        Upzala = getResources().getStringArray(R.array.মেহেরপুর);
                    }
                    else if (position ==4) {
                        Upzala = getResources().getStringArray(R.array.নড়াইল);
                    }
                    else if (position ==5) {
                        Upzala = getResources().getStringArray(R.array.চুয়াডাঙ্গা);
                    }
                    else if (position ==6) {
                        Upzala = getResources().getStringArray(R.array.কুমিল্লা);
                    }
                    else if (position ==7) {
                        Upzala = getResources().getStringArray(R.array.মাগুরা);
                    }
                    else if (position ==8) {
                        Upzala = getResources().getStringArray(R.array.খুলনা_);
                    }
                    else if (position ==9) {
                        Upzala = getResources().getStringArray(R.array.বাগেরহাট);
                    }
                    else if (position ==10) {
                        Upzala = getResources().getStringArray(R.array.ঝিনাইদহ);
                    }
                    else {
                        Upzala = getResources().getStringArray(R.array.empty);
                    }

                    ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                    P_S.setAdapter(upazalaA);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if (position == 3) {
            District = getResources().getStringArray(R.array.রাজশাহী);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position ==1){
                            Upzala = getResources().getStringArray(R.array.সিরাজগঞ্জ);
                        }
                        else if (position ==2) {
                            Upzala = getResources().getStringArray(R.array.নাটোর);
                        }
                        else if (position ==3) {
                            Upzala = getResources().getStringArray(R.array.পাবনা);
                        }
                        else if (position ==4) {
                            Upzala = getResources().getStringArray(R.array.বগুড়া);
                        }
                        else if (position ==5) {
                            Upzala = getResources().getStringArray(R.array.রাজশাহী_);
                        }
                        else if (position ==6) {
                            Upzala = getResources().getStringArray(R.array.জয়পুরহাট);
                        }
                        else if (position ==7) {
                            Upzala = getResources().getStringArray(R.array.চাঁপাইনবাবগঞ্জ);
                        }
                        else if (position ==8) {
                            Upzala = getResources().getStringArray(R.array.নওগাঁ);
                        }
                        else {
                            Upzala = getResources().getStringArray(R.array.empty);
                        }
                        ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                        P_S.setAdapter(upazalaA);

                    }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if (position == 4) {
            District = getResources().getStringArray(R.array.ঢাকা);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if (position ==1){
                            Upzala = getResources().getStringArray(R.array.নরসিংদী);
                        }
                        else if (position ==2) {
                            Upzala = getResources().getStringArray(R.array.গাজীপুর);
                        }
                        else if (position ==3) {
                            Upzala = getResources().getStringArray(R.array.শরীয়তপুর);
                        }
                        else if (position ==4) {
                            Upzala = getResources().getStringArray(R.array.নারায়ণগঞ্জ);
                        }
                        else if (position ==5) {
                            Upzala = getResources().getStringArray(R.array.টাঙ্গাইল);
                        }
                        else if (position ==6) {
                            Upzala = getResources().getStringArray(R.array.কিশোরগঞ্জ);
                        }
                        else if (position ==7) {
                            Upzala = getResources().getStringArray(R.array.মানিকগঞ্জ);
                        }
                        else if (position ==8) {
                            Upzala = getResources().getStringArray(R.array.ঢাকা_);
                        }
                        else if (position ==9) {
                            Upzala = getResources().getStringArray(R.array.মুন্সিগঞ্জ);
                        }
                        else if (position ==10) {
                            Upzala = getResources().getStringArray(R.array.রাজবাড়ী);
                        }
                        else if (position ==11) {
                            Upzala = getResources().getStringArray(R.array.মাদারীপুর);
                        }
                        else if (position ==12) {
                            Upzala = getResources().getStringArray(R.array.গোপালগঞ্জ);
                        }
                        else if (position ==13) {
                            Upzala = getResources().getStringArray(R.array.ফরিদপুর);
                        }
                        else {
                            Upzala = getResources().getStringArray(R.array.empty);
                        }

                        ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                        P_S.setAdapter(upazalaA);
                    }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if (position == 5) {
            District = getResources().getStringArray(R.array.বরিশাল);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position ==1){
                        Upzala = getResources().getStringArray(R.array.ঝালকাঠি);
                    }
                    else if (position ==2) {
                        Upzala = getResources().getStringArray(R.array.পটুয়াখালী);
                    }
                    else if (position ==3) {
                        Upzala = getResources().getStringArray(R.array.পিরোজপুর);
                    }
                    else if (position ==4) {
                        Upzala = getResources().getStringArray(R.array.বরিশাল_);
                    }
                    else if (position ==5) {
                        Upzala = getResources().getStringArray(R.array.ভোলা);
                    }
                    else if (position ==6) {
                        Upzala = getResources().getStringArray(R.array.বরগুনা);
                    }
                    else {
                        Upzala = getResources().getStringArray(R.array.empty);
                    }


                    ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                    P_S.setAdapter(upazalaA);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if (position == 6) {
            District = getResources().getStringArray(R.array.চট্টগ্রাম);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position ==1){
                        Upzala = getResources().getStringArray(R.array.কুমিল্লা);
                    }
                    else if (position ==2) {
                        Upzala = getResources().getStringArray(R.array.ফেনী);
                    }
                    else if (position ==3) {
                        Upzala = getResources().getStringArray(R.array.ব্রাহ্মণবাড়িয়া);
                    }
                    else if (position ==4) {
                        Upzala = getResources().getStringArray(R.array.রাঙ্গামাটি);
                    }
                    else if (position ==5) {
                        Upzala = getResources().getStringArray(R.array.নোয়াখালী);
                    }
                    else if (position ==6) {
                        Upzala = getResources().getStringArray(R.array.চাঁদপুর);
                    }
                    else if (position ==7) {
                        Upzala = getResources().getStringArray(R.array.লক্ষ্মীপুর);
                    }
                    else if (position ==8) {
                        Upzala = getResources().getStringArray(R.array.চট্টগ্রাম_);
                    }
                    else if (position ==9) {
                        Upzala = getResources().getStringArray(R.array.কক্সবাজার);
                    }
                    else if (position ==10) {
                        Upzala = getResources().getStringArray(R.array.খাগড়াছড়ি);
                    }
                    else if (position ==11) {
                        Upzala = getResources().getStringArray(R.array.বান্দরবান);
                    }
                    else {
                        Upzala = getResources().getStringArray(R.array.empty);
                    }

                    ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                    P_S.setAdapter(upazalaA);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if (position == 7) {
            District = getResources().getStringArray(R.array.সিলেট);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position ==1){
                        Upzala = getResources().getStringArray(R.array.সিলেট_);
                    }
                    else if (position ==2) {
                        Upzala = getResources().getStringArray(R.array.মৌলভীবাজার);
                    }
                    else if (position ==3) {
                        Upzala = getResources().getStringArray(R.array.হবিগঞ্জ);
                    }
                    else if (position ==4) {
                        Upzala = getResources().getStringArray(R.array.সুনামগঞ্জ);
                    }
                    else {
                        Upzala = getResources().getStringArray(R.array.empty);
                    }

                    ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                    P_S.setAdapter(upazalaA);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
        else if (position == 8) {
            District = getResources().getStringArray(R.array.ময়মনসিংহ);
            ArrayAdapter<String> disA = new ArrayAdapter<String>(MainActivity.this, R.layout.spinner, R.id.SpinnerTextId, District);
            district.setAdapter(disA);
            district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position ==1){
                        Upzala = getResources().getStringArray(R.array.শেরপুর);
                    }
                    else if (position ==2) {
                        Upzala = getResources().getStringArray(R.array.ময়মনসিংহ_);
                    }
                    else if (position ==3) {
                        Upzala = getResources().getStringArray(R.array.জামালপুর);
                    }
                    else if (position ==4) {
                        Upzala = getResources().getStringArray(R.array.নেত্রকোণা);
                    }
                    else {
                        Upzala = getResources().getStringArray(R.array.empty);
                    }
                    ArrayAdapter<String> upazalaA = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,R.id.SpinnerTextId,Upzala);
                    P_S.setAdapter(upazalaA);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});




        Sdate.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         DatePicker datep = new DatePicker(MainActivity.this);
                                         dd = datep.getDayOfMonth();
                                         mm = datep.getMonth();
                                         yy = datep.getYear();

                                         DatePickerDialog date = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                                             @Override
                                             public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                                                 a = dd;
                                                 b = mm+1;
                                                 c = yy;
                                                dateView.setText(a+"/"+b+"/"+c);


                                             }
                                         },yy,mm,dd);

                                         date.show();
                                     }
                                 });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();

            }
        });

        viewDoner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    /*@Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        bloodData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                MainActivity2.clear();
                for (DataSnapshot donerSnapshot : snapshot.getChildren()){
                    Doner doner = donerSnapshot.getValue(Doner.class);
                    MainActivity2.add(doner);
                }
                DonerList adapter = new DonerList(MainActivity.this,MainActivity2.class);
                MainActivity2.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/

    private void addUser(){
        String Uname = name.getText().toString().trim();
        String blood = bloodGroups.getSelectedItem().toString();
        String mobileNo = mobile.getText().toString().trim();
        String Thana = P_S.getSelectedItem().toString();
        String zela = district.getSelectedItem().toString().trim();



        if(!TextUtils.isEmpty(mobileNo)){
            String id = bloodData.push().getKey();
            Doner doner = new Doner(mobileNo,Uname,blood,Thana,zela,a,b,c);
            bloodData.child(mobileNo).setValue(doner);
            Toast.makeText(MainActivity.this,"Doner add Successfullu",Toast.LENGTH_LONG).show();
            //entry from clear.
            name.setText("");
            mobile.setText("");
            district.setPrompt("Selext ");
            dateView.setText("");

                   }
        else{
            Toast.makeText(MainActivity.this,"Mobile No does not empty",Toast.LENGTH_LONG).show();
        }
    }

}