package com.example.pts_sabdanabi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText email;
    EditText password;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
                email = findViewById(R.id.emailRegister);
        password = findViewById(R.id.passwordRegister);
        Login = findViewById(R.id.RegisterButton);







        Login.setOnClickListener(view -> {
            if (email.getText().toString().equals("") && password.getText().toString().equals("")){
                Toast.makeText(this, "Email dan Password Kosong", Toast.LENGTH_SHORT).show();
            } else if (password.getText().toString().equals("")){
                Toast.makeText(this, "Password Kosong", Toast.LENGTH_SHORT).show();
            }else if (email.getText().toString().equals("")){
                Toast.makeText(this, "Email Kosong", Toast.LENGTH_SHORT).show();
            }else {

                DataHolder dataHolder = DataHolder.getInstance();
                dataHolder.addToDataListEmail(email.getText().toString());
                dataHolder.addToDataListPassword(password.getText().toString());
                Intent intent = new Intent(Register.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}