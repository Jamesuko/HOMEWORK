package com.example.admin.homework1;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this , R.array.colors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void confirmation(View view) {
        //Create an empty Inent and add the selected_sound variable to it
        Intent data = new Intent();
        String color = ((Spinner)(findViewById(R.id.spinner))).getSelectedItem().toString();
        data.putExtra("color",color);

        setResult(RESULT_OK, data);
        //Destroy this Activity and propagate the ActivityResult
        finish();
    }
}
