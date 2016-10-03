package com.example.dmolina.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    //Definicion de variables
    private EditText txtAdd;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        //Creacion de variables
        txtAdd = (EditText) findViewById(R.id.txtAdd);
        list = (ListView) findViewById(R.id.lvwList);
        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        list.setAdapter(adapter);

        //Seteo Boton
        Button show;

        show = (Button) findViewById(R.id.btnShowDialog);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(txtAdd.getText().toString());
                adapter.notifyDataSetChanged();
                showToast();
            }
        });

    }

    void showToast(){
        //Setear Toast
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);

        toast.setGravity(Gravity.TOP| Gravity.START, 250, 250);

        toast.show();
    }
}
