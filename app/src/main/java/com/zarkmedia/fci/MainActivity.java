package com.zarkmedia.fci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            editTextMobile = findViewById(R.id.editTextMobile);

            findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String mobile = editTextMobile.getText().toString().trim();

                    if(mobile.isEmpty() || mobile.length() < 10){
                        editTextMobile.setError("Enter a valid mobile");
                        editTextMobile.requestFocus();
                        return;
                    }

                    Intent intent = new Intent(MainActivity.this, ActivityVerifyPhone.class);
                    intent.putExtra("mobile", mobile);
                    startActivity(intent);
                }
            });
        }


}