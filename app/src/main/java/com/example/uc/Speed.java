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

public class Speed extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Spinner spinner;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        //Shared preferences
        value = findViewById(R.id.Value);
        String value2 = getPreferences(MODE_PRIVATE).getString("value","0");
        value.setText(value2);
        RadioButton ms_btn = findViewById(R.id.radioButton);
        RadioButton kh_btn = findViewById(R.id.radioButton2);
        RadioButton mh_btn  = findViewById(R.id.radioButton3);

        ms_btn.setOnClickListener(this::convert);
        kh_btn.setOnClickListener(this::convert2);
        mh_btn.setOnClickListener(this::convert3);


        //Spinner part
        spinner = findViewById(R.id.spinner4);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Spinner_items4,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }


    //converter functions

    float ms_to_kh(float ms){
        return (3.6f*ms);
    }

    float ms_to_mh(float ms){
        return 2.237f*ms;
    }

    float kh_to_ms(float kh){
        return kh/3.6f;
    }


    float mh_to_ms(float mh){
        return mh/2.237f;
    }


    void convert(View sender){

        TextView ms = findViewById(R.id.textView);
        TextView kh = findViewById(R.id.textView2);
        TextView mh = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = ms_to_kh(inputValue);
        final float outputValue2 = ms_to_mh(inputValue);

        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        ms.setText(inputStr);
        kh.setText(outputStr);
        mh.setText(outputStr2);


    }


    void convert2(View sender){

        TextView ms = findViewById(R.id.textView);
        TextView kh = findViewById(R.id.textView2);
        TextView mh = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = kh_to_ms(inputValue);
        final float outputValue2 = ms_to_mh(outputValue);

        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        ms.setText(outputStr);
        kh.setText(inputStr);
        mh.setText(outputStr2);



    }


    void convert3(View sender){

        TextView ms = findViewById(R.id.textView);
        TextView kh = findViewById(R.id.textView2);
        TextView mh = findViewById(R.id.textView4);

        final String inputStr = value.getText().toString();
        getPreferences(MODE_PRIVATE).edit().putString("value",inputStr).apply();    // NEW CODE
        final float inputValue = Float.parseFloat(inputStr);
        final float outputValue = mh_to_ms(inputValue);
        final float outputValue2 = ms_to_kh(outputValue);

        final String outputStr = String.format("%.2f", outputValue);
        final String outputStr2 = String.format("%.2f", outputValue2);
        ms.setText(outputStr);
        kh.setText(outputStr2);
        mh.setText(inputStr);



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
        if(text.equals("Temperature") || text.equals("Température")){
            Intent intent = new Intent(this, Temperature.class);
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