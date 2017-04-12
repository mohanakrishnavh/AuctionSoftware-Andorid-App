package com.example.mohanakrishna.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper buyerhelper = new DatabaseHelper(this);
    DBHelper sellerhelper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginButtonClick(View v)
    {
            if (v.getId() == R.id.loginButton) {
                EditText loginemail = (EditText) findViewById(R.id.editText);
                EditText loginpassword = (EditText) findViewById(R.id.editText2);
                String loginemail_string = loginemail.getText().toString();
                String loginpassword_string = loginpassword.getText().toString();
                if ((loginemail_string.matches("")) || (loginemail_string.matches("")))
                {
                    Toast.makeText(this, "Please enter Email ID and Password of the Buyer", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String password = buyerhelper.searchPassword(loginemail_string);
                    if(loginpassword_string.equals(password))
                    {
                        Intent i = new Intent(LoginActivity.this,BuyerHome.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Email and password for the Buyer doesn't match.Please enter correct details", Toast.LENGTH_SHORT).show();
                    }
                }
            }

    }

    public void onSellerLoginClick(View v)
    {
        if (v.getId() == R.id.sellerLoginButton)
        {
            EditText loginemail = (EditText) findViewById(R.id.editText);
            EditText loginpassword = (EditText) findViewById(R.id.editText2);
            String loginemail_string = loginemail.getText().toString();
            String loginpassword_string = loginpassword.getText().toString();
            if ((loginemail_string.matches("")) || (loginemail_string.matches("")))
            {
                Toast.makeText(this, "Please enter the Email ID and Password of the Seller", Toast.LENGTH_SHORT).show();
            }
            else
            {
                String password = sellerhelper.searchPassword(loginemail_string);
                if(loginpassword_string.equals(password))
                {
                    Intent i = new Intent(LoginActivity.this,SellerHome.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Email and password for the Seller doesn't match.Please enter correct details", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }




    public void onRegisterBuyerButtonClick(View v)
    {
        if(v.getId()== R.id.registerBuyerButton)
        {
            Intent i = new Intent(LoginActivity.this,RegisterBuyer.class);
            startActivity(i);
        }

    }



    public void onRegisterSellerButtonClick(View v)
    {
        Intent j = new Intent(LoginActivity.this,RegisterSeller.class);
        startActivity(j);
    }
}
