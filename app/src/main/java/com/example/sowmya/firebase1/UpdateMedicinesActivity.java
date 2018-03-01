package com.example.sowmya.firebase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateMedicinesActivity extends AppCompatActivity {
    EditText medname,quantity;
    Button plus,minus,update;
    DatabaseReference mDatabase,mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_medicines);
        update=(Button)findViewById(R.id.update);
        medname=(EditText)findViewById(R.id.editText);
        quantity=(EditText)findViewById(R.id.editText6);
        plus=(Button)findViewById(R.id.button2);
        minus=(Button)findViewById(R.id.button4);
        medname=(EditText)findViewById(R.id.editText);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Quantity=Integer.valueOf(quantity.getText().toString());
                Quantity+=1;
                quantity.setText(""+Quantity);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Quantity=Integer.valueOf(quantity.getText().toString());
                Quantity-=1;
                quantity.setText(""+Quantity);
            }

        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Quantity=quantity.getText().toString().trim();
                String Medname=medname.getText().toString().trim();
                String Email=getIntent().getStringExtra("email");

                mDatabase = FirebaseDatabase.getInstance().getReference().child("store_users");
                mdb=mDatabase.child(Email).child("Products").child(Medname);
                mdb.setValue(Quantity);

            }
        });




    }
}
