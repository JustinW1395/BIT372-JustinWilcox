package com.example.unitcoverter;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.unitcoverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView convertTo;
    private EditText convertFrom;
    private Button Convert;
    private Title thetitle = new Title("Select Conversion");
    private ActivityMainBinding binding;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setTitle(thetitle);


        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.conversions, android.R.layout.simple_spinner_item);
        Spinner spinner = findViewById(R.id.conversion_select);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        convertFrom = findViewById(R.id.converter_input);
        convertTo = findViewById(R.id.converter_text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.conversion_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();
        convertFrom.setText("");
        convertTo.setText("");
        Log.i("info", selected);
        switch(selected) {
            case "fahrenheit to celsius":
                thetitle.setTitle("Fahrenheit to Celcius");
                Convert = findViewById(R.id.convert_btn);
                Convert.setOnClickListener(v -> {
                    if(convertFrom.getText().length() == 0)
                        return;
                    double celcius = Converter.toCelcius(Double.parseDouble(convertFrom.getText().toString()));
                    convertTo.setText(String.format("%.2f ºC", celcius));
                });
                break;
            case "pounds to kilograms":
                thetitle.setTitle("Pounds to Kilograms");
                Convert = findViewById(R.id.convert_btn);
                Convert.setOnClickListener(v -> {
                    if(convertFrom.getText().length() == 0)
                        return;
                    double kilograms = Converter.toKG(Double.parseDouble(convertFrom.getText().toString()));
                    convertTo.setText(String.format("%.2f kg", kilograms));
                });
                break;
            case "miles to kilometers":
                thetitle.setTitle("Miles to Kilometers");
                Convert = findViewById(R.id.convert_btn);
                Convert.setOnClickListener(v -> {
                    if(convertFrom.getText().length() == 0)
                        return;
                    double kilometers = Converter.toKilom(Double.parseDouble(convertFrom.getText().toString()));
                    convertTo.setText(String.format("%.2f km", kilometers));
                });
                break;
            case "feet to meters":
                thetitle.setTitle("Feet to Meters");
                Convert = findViewById(R.id.convert_btn);
                Convert.setOnClickListener(v -> {
                    if(convertFrom.getText().length() == 0)
                        return;
                    double meters = Converter.toMet(Double.parseDouble(convertFrom.getText().toString()));
                    convertTo.setText(String.format("%.2f m", meters));
                });
                break;
            default:
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}