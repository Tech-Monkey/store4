package com.example.sowmya.firebase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText email,password;
    Button signup,login,storeSignup;
    DatabaseReference mDatabase,db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.reg_email);
        password=(EditText)findViewById(R.id.reg_password);
        signup=(Button)findViewById(R.id.signup);
        login=(Button)findViewById(R.id.login);
        storeSignup=(Button)findViewById(R.id.store);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString().trim();
                final String Password = password.getText().toString();
                mDatabase= FirebaseDatabase.getInstance().getReference();
                    db = mDatabase.child("normal_users").child(Email);
                    db.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value = dataSnapshot.getValue(String.class);
                            if (Password.equals(value)) {
                                Intent intent = new Intent(MainActivity.this,UsersActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(MainActivity.this,"Wrong Details",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
            }
                });

            storeSignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this,StoreRegisterActivity.class);
                    startActivity(intent);
                }
            });
    }


    }




