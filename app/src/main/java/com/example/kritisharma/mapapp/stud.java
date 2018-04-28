package com.example.kritisharma.mapapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class stud extends AppCompatActivity {

    Button bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud);
        bt1=(Button) findViewById(R.id.rm1);
        bt2=(Button) findViewById(R.id.rm2);
        bt3=(Button) findViewById(R.id.rm3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(stud.this,show.class);
               // intent.putExtra("room",1);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(stud.this,show.class);
                intent.putExtra("room",2);
                startActivity(intent);


            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(stud.this,show.class);
                intent.putExtra("room",3);
                startActivity(intent);


            }
        });
    }
}
