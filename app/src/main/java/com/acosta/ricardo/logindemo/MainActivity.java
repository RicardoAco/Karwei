package com.acosta.ricardo.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private CheckBox chk;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        chk = (CheckBox) findViewById(R.id.chk) ;
        Info.setText("attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                        Password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }

                else {
                    Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("admin"))){
            Toast.makeText(MainActivity.this,"Login Successful ",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("attempts remaining: " + String.valueOf(counter));
            Toast.makeText(MainActivity.this,"Password Incorrect",Toast.LENGTH_LONG).show();

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }

}
