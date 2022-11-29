package com.example.mymedicine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class page4 extends AppCompatActivity {

    ImageButton back;
    Button add;
    Button home;
    TextView personal, medicine;
    ImageButton search;
    String name, personalInfo,medInfo;
    EditText Sname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        Sname = findViewById(R.id.editTextn);
        search = findViewById(R.id.imageButton);
        search.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                name = Sname.getText().toString();
                retreive(v);
            }
        });


        back=(ImageButton) findViewById(R.id.back4);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intentback = new Intent(page4.this,page2.class);
                startActivity(intentback);
            }
        });


        add=(Button) findViewById(R.id.add1);
        add.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intentcontinue = new Intent(page4.this,page2.class);
                startActivity(intentcontinue);
            }
        });


        home=(Button) findViewById(R.id.home1);
        home.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intentcontinue = new Intent(page4.this,MainActivity.class);
                startActivity(intentcontinue);
            }
        });
    }
    public void retreive (View v){
        My_Medicine_DB db = Room.databaseBuilder(this,My_Medicine_DB.class,"My_Medicine")
                .allowMainThreadQueries().build();
        My_Medicine_DAO My_Medicine_dao = db.My_Medicine_dao();
        List<My_Medicine> meds =My_Medicine_dao.getAll();

        personal = findViewById(R.id.textView12);

        personalInfo ="";
        for(My_Medicine med: meds){
            String n = med.getName();
            if(n.equals(name)){
                personalInfo = "Name: "+ n +"\n"+"Age: " + med.getAge();
                break;
            }
        }
        personal.setText(personalInfo);

        medicine = findViewById(R.id.textView13);
        medInfo="";
        for(My_Medicine med: meds){
            String n =med.getName();
            if(n.equals(name)){
                medInfo = medInfo + "\n"+"Medicine Name: "+med.getMedicine_name()+"\nDose/Day:"+med.getDose()+"\n";
            }
        }
        medicine.setText(medInfo);
    }
}