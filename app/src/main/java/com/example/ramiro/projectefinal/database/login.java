package com.example.ramiro.projectefinal.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ramiro.projectefinal.R;
import com.example.ramiro.projectefinal.activities.MainActivity;
import com.example.ramiro.projectefinal.database.MyDataBaseHelper;

public class login extends AppCompatActivity {




    private MyDataBaseHelper myDataBaseHelper;

    private EditText editText1,editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button l = (Button) findViewById(R.id.button_login);
        Button s = (Button) findViewById(R.id.button_signin);

        editText1 = (EditText) findViewById(R.id.editText_usuario);
        editText2 = (EditText) findViewById(R.id.editText_password);

        myDataBaseHelper = MyDataBaseHelper.getInstance(this);

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = editText1.getText().toString();
                String cont = editText2.getText().toString();
                String Contra = myDataBaseHelper.queryRow(us);
                if (Contra.equals(null)) {
                    Intent i = new Intent(login.this,login_fail.class);
                    startActivity(i);
                }
                else {
                    if (Contra != cont) {
                        Toast.makeText(getApplicationContext(),"CONTRASEÑA INCORRECTA",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent i = new Intent(login.this, MainActivity.class);
                        startActivity(i);
                    }

                }

            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,signin.class);
                startActivity(i);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDataBaseHelper.close();
    }
}
