package com.example.asynchorniseprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tname;
    Button tbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tname=findViewById(R.id.tname);
        tbtn=findViewById(R.id.tbtn);

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mytask mytask=new Mytask(MainActivity.this,tname,tbtn);
                mytask.execute();
                tbtn.setEnabled(false);
            }
        });
    }
}
