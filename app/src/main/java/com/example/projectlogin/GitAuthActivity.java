package com.example.projectlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GitAuthActivity extends Activity {

    EditText intputemail;
    Button btnlogin;
    String email = "(aaaaa)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_auth);

        intputemail = findViewById(R.id.email);
        btnlogin = findViewById(R.id.button2);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = intputemail.getText().toString();
                if (email.matches(email)){
                    Toast.makeText(GitAuthActivity.this, "Masukkan email yang benerl", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}