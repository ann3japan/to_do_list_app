package com.example.to_dolist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> toDoList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view_layout, toDoList);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
        editText = findViewById(R.id.id_edit_text);
    }
    public void addItemToList(View view) {
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        editText.setText("");
    }
}