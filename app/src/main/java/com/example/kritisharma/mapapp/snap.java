package com.example.kritisharma.mapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class snap extends AppCompatActivity {

    Button btn;
    EditText et;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snap);
        btn=(Button) findViewById(R.id.show);
        et=(EditText) findViewById(R.id.ett);
        image=(ImageView) findViewById(R.id.image);
        image.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             image.setVisibility(View.VISIBLE);
                et.setText("");
            }
        });
    }
}
