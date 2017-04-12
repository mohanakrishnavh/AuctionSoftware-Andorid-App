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

public class RegisterSeller extends Activity {

    DBHelper sellerhelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerselleractivity);
    }

    public void onRegisterSeller(View v)
    {
        if(v.getId()== R.id.registerSeller)
        {
            EditText name = (EditText)findViewById(R.id.editText3);
            EditText email = (EditText)findViewById(R.id.emailText2);
            EditText phone = (EditText)findViewById(R.id.phoneText2);
            EditText password = (EditText)findViewById(R.id.passwordText2);
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
                sellerhelper.insertSeller(c);

                Intent i = new Intent(RegisterSeller.this,LoginActivity.class);
                Toast.makeText(this, "Seller Successfully Registered", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        }

    }
}
