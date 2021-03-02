package com.example.uc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Temperature extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        //Shared preferences
        value = findViewById(R.id.Value);
        String value2 = getPreferences(MODE_PRIVATE).getString("value","0");
        value.setText(value2);
        RadioButton celsius_btn = findViewById(R.id.radioButton);
        RadioButton fahrenheit_btn = findViewById(R.id.radioButton2);
        RadioButton kelvin_btn  = findViewById(R.id.radioButton3);

        celsius_btn.setOnClickListener(this::convert);
        fahrenheit_btn.setOnClickListener(this::convert2);
        kelvin_btn.setOnClickListener(this::convert3);
        //Spinner part
        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Spinner_items2,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


    }

    //converter functions
    float c_to_f(float c){
        return ((c*1.8f) + 32);
    }

    float c_to_k(float c){
        return c+  273.15f;
    }

    float f_to_c(float f){
        return (f-32)/1.8f;
    }


    float k_to_c(float k){
        return k-273.15f;
    }


    void convert(View sender){

        TextView celsius = findViewById(R.id.textView);
        TextView fahrenheit = findViewById(R.id.textView2);
        TextView kelvin = findViewById(R.id.textView4);

            final String inputStr = value.getText().toString();
            getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
            final float inputValue = Float.parseFloat(inputStr);
            final float outputValue = c_to_f(inputValue);
            final float outputValue2 = c_to_k(inputValue);

            @SuppressLint("DefaultLocale") final String outputStr = String.format("%.2f", outputValue);
            @SuppressLint("DefaultLocale") final String outputStr2 = String.format("%.2f", outputValue2);
            celsius.setText(inputStr);
            fahrenheit.setText(outputStr);
            kelvin.setText(outputStr2);

        
    }


    void convert2(View sender){

        TextView celsius = findViewById(R.id.textView);
        TextView fahrenheit = findViewById(R.id.textView2);
        TextView kelvin = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = f_to_c(inputValue);
        final float outputValue2 = c_to_k(outputValue);

        @SuppressLint("DefaultLocale") final String outputStr = String.format("%.2f", outputValue);
        @SuppressLint("DefaultLocale") final String outputStr2 = String.format("%.2f", outputValue2);
        fahrenheit.setText(inputStr);
        celsius.setText(outputStr);
        kelvin.setText(outputStr2);


    }



    void convert3(View sender){

        TextView celsius = findViewById(R.id.textView);
        TextView fahrenheit = findViewById(R.id.textView2);
        TextView kelvin = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = k_to_c(inputValue);
        final float outputValue2 = c_to_f(outputValue);

        @SuppressLint("DefaultLocale") final String outputStr = String.format("%.2f", outputValue);
        @SuppressLint("DefaultLocale") final String outputStr2 = String.format("%.2f", outputValue2);
        kelvin.setText(inputStr);
        celsius.setText(outputStr);
        fahrenheit.setText(outputStr2);


    }


    @Override
    //Code for the spinner
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        if(text.equals("Fuel") || text.equals("Carburant")){
            Intent intent = new Intent(this, Fuel.class);
            startActivity(intent);

        }
        if(text.equals("Speed") || text.equals("Vitesse")){
            Intent intent = new Intent(this, Speed.class);
            startActivity(intent);

        }
        if(text.equals("Cooking") || text.equals("Cuisine")){
            Intent intent = new Intent(this, Cooking.class);
            startActivity(intent);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}