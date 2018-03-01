package com.example.sowmya.firebase1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main2Activity extends AppCompatActivity {
    Button signup;
    EditText name, mEmailField, mPasswordField;
    //DatabaseReference mDatabase;
    DatabaseReference mDatabase;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //  mDatabase=FirebaseDatabase.getInstance().getReference().child("Users");

        signup = (Button) findViewById(R.id.Signup);
        name = (EditText) findViewById(R.id.nameField);
        mEmailField = (EditText) findViewById(R.id.emailField);
        mPasswordField = (EditText) findViewById(R.id.passwordField);

//        mAuth=FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegister();
            }
        });


    }

    private void startRegister() {
        final String Name = name.getText().toString().trim();
        String Email = mEmailField.getText().toString().trim();
        final String Password = mPasswordField.getText().toString().trim();
        if (!TextUtils.isEmpty(Name) && !TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password)) {
            //          mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            //              @Override
            //              public void onComplete(@NonNull Task<AuthResult> task) {
            //                  if(task.isSuccessful()){
            //                      String user_id=mAuth.getCurrentUser().getUid();
            //                DatabaseReference current_user_db=mDatabase.child(user_id);
            //              current_user_db.child("Name").setValue(Name);
            //            current_user_db.child("Password").setValue("Default");
            //                      Toast.makeText(Main2Activity.this,"Success",Toast.LENGTH_LONG).show();
            //                }
            //                else
            //              {
            //                  Toast.makeText(Main2Activity.this,"Failed",Toast.LENGTH_LONG).show();


//                    }
            //              }
            //        });
            //  }
            mDatabase= FirebaseDatabase.getInstance().getReference().child("normal_users");
            mDatabase.child(Email).setValue(Password);
            Intent intent=new Intent(Main2Activity.this,UsersActivity.class);
            startActivity(intent);

        }
    }
}
