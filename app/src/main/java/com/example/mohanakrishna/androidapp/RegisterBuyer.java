package com.example.mohanakrishna.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Mohanakrishna on 23-Mar-17.
 */

public class RegisterBuyer extends Activity {

    DatabaseHelper buyerhelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerbuyeractivity);
    }


    public void onRegisterBuyer(View v)
    {
        if(v.getId()== R.id.registerBuyer)
        {
            EditText name = (EditText)findViewById(R.id.nameText1);
            EditText email = (EditText)findViewById(R.id.emailText1);
            EditText phone = (EditText)findViewById(R.id.phoneText1);
            EditText password = (EditText)findViewById(R.id.passwordText1);
            String name_string = name.getText().toString();
            String email_string = email.getText().toString();
            String phone_string = phone.getText().toString();
            String password_string = password.getText().toString();
            if((name_string.matches("")) || (email_string.matches("")) || (phone_string.matches("")) || ((password_string.matches(""))))
            {
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            }

            else
            {
                Contact c = new Contact();
                c.setName(name_string);
                c.setEmail(email_string);
                c.setPhone(phone_string);
                c.setPassword(password_string);
                buyerhelper.insertBuyer(c);

                Intent i = new Intent(RegisterBuyer.this,LoginActivity.class);
                Toast.makeText(this, "Buyer Successfully Registered", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        }

    }
}
