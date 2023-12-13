package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SigninActivity extends AppCompatActivity {


    private EditText inputUsername, inputPassword;
    Button btnsignin, btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.signin);

        inputUsername = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);

        btnsignin = findViewById(R.id.button_signin);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidasi();
            }
        });
        btnsignup = findViewById(R.id.button_signup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);
            }

        });
    }
    private void checkValidasi(){
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();

        if (username.isEmpty()){
            showError(inputUsername, "Your Username can't be empty.");
        }
        else if(username.length() < 8) {
            showError(inputUsername, "Your Username must be at least 8 characters.");
        }
        if(password.isEmpty()){
            showError(inputPassword, "Password can't be empty.");
        }
        else if(password.length() < 8){
            showError(inputPassword, "Password must be at least 8 characters");
        }
        else if(!containsSymbol(password)){
            showError(inputPassword, "Password must contains at least 1 symbol");
        }
        else if(!containsCapitalLetter(password)){
            showError(inputPassword, "Password must contains at least 1 capital letter");
        }
        else{
            Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SigninActivity.this, HomepageActivity.class);
            startActivity(intent);
        }
    }
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
    private boolean containsSymbol(String password) {
        Pattern pattern = Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    private boolean containsCapitalLetter(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    private boolean containsNumber(String password) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
