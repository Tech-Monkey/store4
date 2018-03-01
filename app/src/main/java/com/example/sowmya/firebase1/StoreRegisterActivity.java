package com.example.sowmya.firebase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StoreRegisterActivity extends AppCompatActivity {
    EditText email,password,name_of_store;
    Button signup, locate;
    DatabaseReference mDatabase,mdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_register);
        email=(EditText)findViewById(R.id.editText2);
        password=(EditText)findViewById(R.id.editText3);
        locate=(Button)findViewById(R.id.map);
        name_of_store=(EditText)findViewById(R.id.editText4);
        signup=(Button)findViewById(R.id.button3);
        //location=(EditText)findViewById(R.id.location);
        //location1=(EditText)findViewById(R.id.location1);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(StoreRegisterActivity.this, MapsActivity.class);

                startActivity(i);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email=email.getText().toString();
                String Password=password.getText().toString();
                // String Location=location.getText().toString();
                // String Location1=location1.getText().toString();

                String Name=name_of_store.getText().toString();
                if (!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password)) {

                    mDatabase = FirebaseDatabase.getInstance().getReference().child("store_users");
                    mDatabase.child(Email).child("Password").setValue(Password);
                    String Location=getIntent().getStringExtra("latitude");
                    String Location1=getIntent().getStringExtra("longitude");
                    Toast.makeText(StoreRegisterActivity.this,Location,Toast.LENGTH_LONG).show();
                    mdb=mDatabase.child(Email).child("latitude");
                    mdb.setValue(Location);
                    mdb=mDatabase.child(Email).child("longitude");
                    mdb.setValue(Location1);
                    mdb=mDatabase.child(Email).child("Name");
                    mdb.setValue(Name);



                    Intent intent = new Intent(StoreRegisterActivity.this, UpdateMedicinesActivity.class);
                    intent.putExtra("email",Email);
                    startActivity(intent);
                    finish();


                }
            }
        });


    }
}
