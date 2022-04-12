package com.example.week10_lecture;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startButtton;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_UI();
    }

    private void init_UI() {
        startButtton = (Button) findViewById(R.id.startButtton);
        progressDialog = new ProgressDialog(this);

        startButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call background task here
                DummyTask task = new DummyTask(progressDialog, MainActivity.this);
                task.execute();
            }
        });
    }
}