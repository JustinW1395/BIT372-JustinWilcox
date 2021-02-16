package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        Spinner spinner = findViewById(R.id.conversion_select);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversions,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        EditText lbsinput = findViewById(R.id.pound_input);
        TextView kgtxt = findViewById(R.id.kilogram_text);
        fbtn.setOnClickListener(v -> {
            if (lbsinput.getText().length() == 0)
                return;
            double kilogram = Converter.toKG(Double.parseDouble(lbsinput.getText().toString()));
            kgtxt.setText(String.format("%.2f kg", kilogram));
        });
    }
}