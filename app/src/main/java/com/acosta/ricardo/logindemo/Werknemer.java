package com.acosta.ricardo.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class Werknemer extends AppCompatActivity {

    //LIST
    private RecyclerView mRecyclerView;


    private boolean showToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_werknemer);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_karweis);

        new FirebaseDatabaseHelper().readKarweis(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Karwei> karweis, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,Werknemer.this,karweis,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
