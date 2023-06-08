package com.example.pts_sabdanabi.logsign;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pts_sabdanabi.News;
import com.example.pts_sabdanabi.MainActivity;
import com.example.pts_sabdanabi.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL = "EXTRA_EMAIL";
    public static final String EXTRA_Password = "EXTRA_Password";
    private static final String STATE_RESULT = "state_result";

    EditText emailLogin;
    EditText passwordLogin;
    Button Login;
    TextView create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailLogin = findViewById(R.id.emailLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        Login = findViewById(R.id.LoginButton);
        create = findViewById(R.id.create);


        News dataHolder = News.getInstance();
        ArrayList<String> dataListEmail = dataHolder.getDataListEmail();
        ArrayList<String> dataListPasswod = dataHolder.getDataListPassword();


        create.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, Register.class);
            startActivity(intent);
        });

        Login.setOnClickListener(view -> {


            boolean ada = false;
            if (emailLogin.getText().toString().equals("") && passwordLogin.getText().toString().equals("")){
                Toast.makeText(this, "Email dan Password Kosong", Toast.LENGTH_SHORT).show();
            } else if (passwordLogin.getText().toString().equals("")){
                Toast.makeText(this, "Password Kosong", Toast.LENGTH_SHORT).show();
            }else if (emailLogin.getText().toString().equals("")){
                Toast.makeText(this, "Email Kosong", Toast.LENGTH_SHORT).show();
            }else {
                for(int i =0 ; i < dataListEmail.size();i++){
                    if(emailLogin.getText().toString().equals(dataListEmail.get(i)) && passwordLogin.getText().toString().equals(dataListPasswod.get(i))) {
                        ada = true;
                    }

                }

                if(ada){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "Email atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}