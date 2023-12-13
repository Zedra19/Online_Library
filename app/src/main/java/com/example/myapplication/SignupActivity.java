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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    private EditText inputUsername, inputFullname, inputEmail, inputAddress, inputPhoneNumber, inputPassword;
    Button btnregister, btnsignin;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.signup);

        inputUsername = findViewById(R.id.username);
        inputFullname = findViewById(R.id.fullname);
        inputEmail = findViewById(R.id.email);
        inputAddress = findViewById(R.id.address);
        inputPhoneNumber = findViewById(R.id.phonenumber);
        inputPassword = findViewById(R.id.password);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnregister = findViewById(R.id.button_signup);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkValidasi()){
                    mDatabase.child("User").child(inputUsername.getText().toString()).child("Email").setValue(inputEmail.getText().toString());
                    mDatabase.child("User").child(inputUsername.getText().toString()).child("Fullname").setValue(inputFullname.getText().toString());
                    mDatabase.child("User").child(inputUsername.getText().toString()).child("Password").setValue(inputPassword.getText().toString());
                    mDatabase.child("User").child(inputUsername.getText().toString()).child("Phone Number").setValue(inputPhoneNumber.getText().toString());
                    mDatabase.child("User").child(inputUsername.getText().toString()).child("Address").setValue(inputAddress.getText().toString());
                    Intent intent = new Intent(SignupActivity.this, HomepageActivity.class);
                    startActivity(intent);
                }
            }
        });
        btnsignin = findViewById(R.id.button_signin);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkValidasi(){
        String username = inputUsername.getText().toString();
        String fullname = inputFullname.getText().toString();
        String email = inputEmail.getText().toString();
        String address = inputAddress.getText().toString();
        String phonenumber = inputPhoneNumber.getText().toString();
        String password = inputPassword.getText().toString();
        boolean flag = false;

        if (username.isEmpty()){
            showError(inputUsername, "Your Username can't be empty.");
        }
        else if(username.length() < 8){
            showError(inputUsername, "Your Username must be at least 8 characters.");
        }
        if(fullname.isEmpty()){
            showError(inputFullname, "Your Full name can't be empty.");
        }
        if(email.isEmpty()){
            showError(inputEmail, "Your Email can't be empty.");
        }
        else if(!email.contains("@")){
            showError(inputEmail, "Email is not valid.");
        }
        if(address.isEmpty()){
            showError(inputAddress, "Address can't be empty.");
        }
        if(phonenumber.isEmpty()){
            showError(inputPhoneNumber, "Phone number can't be empty.");
        }
        else if(!containsNumber(phonenumber)){
            showError(inputPhoneNumber, "Phone number can only contains number.");
        }
        else if(phonenumber.length() > 13 || phonenumber.length() < 10){
            showError(inputPhoneNumber, "Phone number is not valid.");
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
            flag = true;
        }
        return flag;
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

