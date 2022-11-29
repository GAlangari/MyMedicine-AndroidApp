package com.example.mymedicine;

import androidx.appcompat.app.AppCompatActivity;

import androidx.room.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class page2 extends AppCompatActivity {
    ImageButton back;
    ImageButton next;
    Button continiuo;
    EditText name, age;

    Spinner medicines;
    Spinner doses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        next=(ImageButton) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intentnext = new Intent(page2.this,page4.class);
                startActivity(intentnext);
            }
        });



        back=(ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intentback = new Intent(page2.this,MainActivity.class);
                startActivity(intentback);
            }
        });

        continiuo=(Button) findViewById(R.id.continiuo);
        continiuo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                boolean i = insert(v);
                if ( i == true ){

                    Intent intentcontiniuo = new Intent(page2.this,page4.class);
                    startActivity(intentcontiniuo);
                }
            }

        });

        medicines = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(page2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.medicines));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicines.setAdapter(adapter);

        doses = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(page2.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.doses));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doses.setAdapter(adapter2);
    }


    public boolean insert(View view) {

        My_Medicine_DB db = Room.databaseBuilder(this, My_Medicine_DB.class, "My_Medicine").allowMainThreadQueries().build();
        name = findViewById(R.id.editTextTextPersonName);
        age = findViewById(R.id.editTextDate);
        medicines = findViewById(R.id.spinner);
        doses = findViewById(R.id.spinner2);

        My_Medicine_DAO My_Medicine_dao = db.My_Medicine_dao();
        My_Medicine m = new My_Medicine();

        String Sname = name.getText().toString();
        String Sage = age.getText().toString();
        String med = medicines.getSelectedItem().toString();
        String dose = doses.getSelectedItem().toString();

        if ( Sname.isEmpty() || Sage.isEmpty()) {
            Message.message(getApplicationContext(),"Enter both name and age");
        } else {
            m.setName(Sname);
            m.setAge(Sage);
            m.setMedicine_name(med);
            m.setDose(dose);

            My_Medicine_dao.insertAll(m);
            Message.message(getApplicationContext(),"Insertion Successful");

            name.setText("");
            age.setText("");


            return true;

        }

        return false;
    }
}