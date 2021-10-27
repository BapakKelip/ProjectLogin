package com.example.projectlogin;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends Activity {

    TextView peng;
    EditText inputemail,password1,password2;
    String email,pass1,pass2;
    Button btndaftar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        peng =(TextView)findViewById(R.id.btnsudah);
        peng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        inputemail = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
        btndaftar = findViewById(R.id.button3);
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

    }

    private void register() {

        email = inputemail.getText().toString();
        pass1 = password1.getText().toString();
        pass2 = password2.getText().toString();

        mAuth.createUserWithEmailAndPassword(email,pass2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterActivity.this, "Registrasi Berhasil", Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Registrasi Gagal", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
