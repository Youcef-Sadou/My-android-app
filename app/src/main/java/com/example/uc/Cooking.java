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

public class Cooking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);



        //Shared preferences
        value = findViewById(R.id.Value);
        String value2 = getPreferences(MODE_PRIVATE).getString("value","0");
        value.setText(value2);
        RadioButton c_btn = findViewById(R.id.radioButton4);
        RadioButton tb_btn = findViewById(R.id.radioButton3);
        RadioButton ts_btn  = findViewById(R.id.radioButton2);
        RadioButton ml_btn  = findViewById(R.id.radioButton);

        ml_btn.setOnClickListener(this::convert);
        ts_btn.setOnClickListener(this::convert2);
        tb_btn.setOnClickListener(this::convert3);
         c_btn.setOnClickListener(this::convert4);

         //Spinner part
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Spinner_items,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);



    }





    //converter functions

    float c_to_ml(float c){
        return c*250f;
    }

    float c_to_tb(float c){
        return c*16.907f;
    }

    float c_to_ts(float c){
        return c*50.721f;
    }


    float ml_to_c(float ml){
        return ml/250f;
    }

    float tb_to_c(float tb){
        return tb/16.907f;
    }
    float ts_to_c(float ts){
        return ts/50.721f;
    }

    void convert(View sender){

        TextView ml = findViewById(R.id.textView);
        TextView ts = findViewById(R.id.textView2);
        TextView tb = findViewById(R.id.textView4);
        TextView c = findViewById(R.id.textView5);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);

        final float outputValue = ml_to_c(inputValue);
        final float outputValue2 = c_to_ts(outputValue);
        final float outputValue3 = c_to_tb(outputValue);


        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        final String outputStr3 = String.format("%.2f", outputValue3);
        ml.setText(inputStr);
        c.setText(outputStr);
        ts.setText(outputStr2);
        tb.setText(outputStr3);


    }

    void convert2(View sender){

        TextView ml = findViewById(R.id.textView);
        TextView ts = findViewById(R.id.textView2);
        TextView tb = findViewById(R.id.textView4);
        TextView c = findViewById(R.id.textView5);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);

        final float outputValue = ts_to_c(inputValue);
        final float outputValue2 = c_to_ml(outputValue);
        final float outputValue3 = c_to_tb(outputValue);


        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        final String outputStr3 = String.format("%.2f", outputValue3);
        ts.setText(inputStr);
        c.setText(outputStr);
        ml.setText(outputStr2);
        tb.setText(outputStr3);


    }






    void convert3(View sender){

        TextView ml = findViewById(R.id.textView);
        TextView ts = findViewById(R.id.textView2);
        TextView tb = findViewById(R.id.textView4);
        TextView c = findViewById(R.id.textView5);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);

        final float outputValue = tb_to_c(inputValue);
        final float outputValue2 = c_to_ml(outputValue);
        final float outputValue3 = c_to_ts(outputValue);


        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        final String outputStr3 = String.format("%.2f", outputValue3);
        tb.setText(inputStr);
        c.setText(outputStr);
        ml.setText(outputStr2);
        ts.setText(outputStr3);


    }



    void convert4(View sender){

        TextView ml = findViewById(R.id.textView);
        TextView ts = findViewById(R.id.textView2);
        TextView tb = findViewById(R.id.textView4);
        TextView c = findViewById(R.id.textView5);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);

        final float outputValue = c_to_ml(inputValue);
        final float outputValue2 = c_to_ts(inputValue);
        final float outputValue3 = c_to_tb(inputValue);


        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        final String outputStr3 = String.format("%.2f", outputValue3);
        c.setText(inputStr);
        ml.setText(outputStr);
        ts.setText(outputStr2);
        tb.setText(outputStr3);


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
        if(text.equals("Temperature")|| text.equals("Température")){
            Intent intent = new Intent(this, Temperature.class);
            startActivity(intent);

        }
        if(text.equals("Speed") || text.equals("Vitesse")){
            Intent intent = new Intent(this, Speed.class);
            startActivity(intent);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}