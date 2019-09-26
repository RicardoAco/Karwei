package com.acosta.ricardo.logindemo;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NewKarweiActivity extends AppCompatActivity {

    private EditText mTitle_editTxt;
    private EditText mDescription_editTxt;
    private EditText mContact_editTxt;
    private EditText mWage_editTxt;
    private String mDevice_id;

    private Button mAdd_btn;
    private  Button mBack_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_karwei);

        mTitle_editTxt = (EditText) findViewById(R.id.title_editTxt);
        mDescription_editTxt = (EditText) findViewById(R.id.description_editTxt);
        mContact_editTxt = (EditText) findViewById(R.id.contact_editTxt);
        mWage_editTxt = (EditText) findViewById(R.id.wage_editTxt);

        //DEVICE ID OPROEPEN
        mDevice_id = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);

        mAdd_btn = (Button) findViewById(R.id.add_btn);
        mBack_btn = (Button) findViewById(R.id.back_btn);

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Karwei karwei = new Karwei();

                karwei.setTitle(mTitle_editTxt.getText().toString());
                karwei.setDescription(mDescription_editTxt.getText().toString());
                karwei.setContact(mContact_editTxt.getText().toString());
                karwei.setWage(mWage_editTxt.getText().toString());
                //ID MEEGEVEN AAN CLASS/CONSTRUCTOR
                karwei.setId(mDevice_id);

                new FirebaseDatabaseHelper().addKarwei(karwei, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Karwei> karweis, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewKarweiActivity.this, "Dit karwei is succesvol aangemaakt",Toast.LENGTH_LONG);

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); return;
            }
        });
    }
}
