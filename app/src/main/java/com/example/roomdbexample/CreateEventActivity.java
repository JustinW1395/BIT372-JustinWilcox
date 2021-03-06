package com.example.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        Spinner eventType = findViewById(R.id.event_image_type);
        ArrayAdapter<CharSequence> types =
                ArrayAdapter.createFromResource(this, R.array.event_type, android.R.layout.simple_spinner_item);
        eventType.setAdapter(types);


        Button createBtn = findViewById(R.id.create_btn);
        EditText title = findViewById(R.id.event_title_edit);
        EditText date = findViewById(R.id.event_date);

        createBtn.setOnClickListener((view) -> {
            String titleStr = title.getText().toString();
            String dateStr = date.getText().toString();
            String typeKey = eventType.getSelectedItem().toString().toLowerCase();
            if (TextUtils.isEmpty(titleStr) || TextUtils.isEmpty(dateStr) || TextUtils.isEmpty(typeKey)) {
                Log.i("DEBUG", "EMPTY VALUES");
                return;
            }
            title.setText("");
            date.setText("");
            Toast.makeText(this, "Event Created", Toast.LENGTH_LONG).show();
            onBackPressed();
        });
    }
}