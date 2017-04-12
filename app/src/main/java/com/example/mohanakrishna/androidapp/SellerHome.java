package com.example.mohanakrishna.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mohanakrishna on 24-Mar-17.
 */

public class SellerHome extends Activity {

    int prevCount = 0;
//    String textBoxString[];
//    ArrayList<String> dyTxtData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sellerhomepage);
        ((EditText)(findViewById(R.id.No_of_TextBox))).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("textbox",s+"");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("after textbox",s+"");
                Log.d("after textbox prev",prevCount+"");
                LinearLayout linearLayout=(LinearLayout)findViewById(R.id.relseller);
                int count = 0;
                boolean flag = false;
                try {
                    for(int i =1;i<=(prevCount);i++){
                        EditText textBox = (EditText)(findViewById(i));
                        ((ViewGroup) textBox.getParent()).removeView(textBox);
                    }

                    count = Integer.parseInt(s + "");

                }
                catch (NumberFormatException e)
                {
                    flag = true;
                    count = 0;
                }
                for(int i=1;i<=count;i++)
                {
                    EditText editText= new EditText(getBaseContext());
                    editText.setId(i);
                    linearLayout.setOrientation(linearLayout.VERTICAL);
                    linearLayout.setTop(50);
                    editText.setTop(100);
                    editText.setWidth(50);
                    linearLayout.addView(editText);
                }
                //if(!flag)
                prevCount = count;
            }
        });


    }


    protected void onSubmit(View v)
    {
        if(v.getId() == R.id.submitProducts)
        {

        }
    }


}
