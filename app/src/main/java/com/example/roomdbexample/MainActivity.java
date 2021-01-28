package com.example.roomdbexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.roomdbexample.Roomdb.Event;
import com.example.roomdbexample.Roomdb.EventDao;
import com.example.roomdbexample.Roomdb.Eventdb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private ListView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, CreateEventActivity.class);
        eventList = findViewById(R.id.event_list);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_app_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(this, CreateEventActivity.class);
        View actionBar = findViewById(R.id.add_event_btn1);
        actionBar.setOnClickListener((view) -> startActivity(intent));
        eventList = findViewById(R.id.event_list);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Eventdb db = Room.databaseBuilder(getApplicationContext(),
                Eventdb.class, Eventdb.DATABASE_NAME).allowMainThreadQueries().build();
        EventDao dao = db.eventDao();
        ArrayAdapter<Event> adapter = new EventListAdapter(getApplicationContext(), dao.getAllEvent());
        eventList.setAdapter(adapter);
    }
}