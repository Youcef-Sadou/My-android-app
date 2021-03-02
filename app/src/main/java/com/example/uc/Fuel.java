package com.example.uc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Fuel extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);

        //Shared preferences
        value = findViewById(R.id.Value);
        String value2 = getPreferences(MODE_PRIVATE).getString("value","0");
        value.setText(value2);
        RadioButton kl_btn = findViewById(R.id.radioButton);
        RadioButton ml_btn = findViewById(R.id.radioButton2);
        RadioButton kg_btn  = findViewById(R.id.radioButton3);

        kl_btn.setOnClickListener(this::convert);
        ml_btn.setOnClickListener(this::convert2);
        kg_btn.setOnClickListener(this::convert3);


        //Spinner part
        spinner = findViewById(R.id.spinner3);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Spinner_items3,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }



    //converter functions
    float kl_to_ml(float kl){
        return (0.621f*kl);
    }

    float kl_to_kg(float kl){
        return 3.785f*kl;
    }

    float ml_to_kl(float ml){
        return ml/0.621f;
    }


    float kg_to_kl(float kg){
        return kg/3.785f;
    }


    void convert(View sender){

        TextView kl = findViewById(R.id.textView);
        TextView ml = findViewById(R.id.textView2);
        TextView kg = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = kl_to_ml(inputValue);
        final float outputValue2 = kl_to_kg(inputValue);

        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        kl.setText(inputStr);
        ml.setText(outputStr);
        kg.setText(outputStr2);


    }


    void convert2(View sender){

        TextView kl = findViewById(R.id.textView);
        TextView ml = findViewById(R.id.textView2);
        TextView kg = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = ml_to_kl(inputValue);
        final float outputValue2 = kl_to_kg(outputValue);

        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        kl.setText(outputStr);
        ml.setText(inputStr);
        kg.setText(outputStr2);



    }


    void convert3(View sender){

        TextView kl = findViewById(R.id.textView);
        TextView ml = findViewById(R.id.textView2);
        TextView kg = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = kg_to_kl(inputValue);
        final float outputValue2 = kl_to_ml(outputValue);

        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        kl.setText(outputStr);
        ml.setText(outputStr2);
        kg.setText(inputStr);



    }


    @Override
    //Code for the spinner
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
        if(text.equals("Temperature") || text.equals("Température")){
            Intent intent = new Intent(this, Temperature.class);
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