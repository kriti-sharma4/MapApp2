package com.example.kritisharma.mapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static android.R.attr.data;

public class show extends AppCompatActivity {

    String room="1";
    room_info r;
    int p,i1,i2,l,d;
    String Out2[];
    TextView et;
    ProgressBar pb;
   // ArrayList<room_info> list=new ArrayList<>();
    String url="https://kritisharma41097.000webhostapp.com/get.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        //Bundle extra=getIntent().getExtras();
        //room=extra.getString("room");
        pb=(ProgressBar) findViewById(R.id.pb);
        et=(TextView) findViewById(R.id.ET);
        pb.setVisibility(View.VISIBLE);
        StringRequest jsonObjectRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                       // Toast.makeText(show.this,response,Toast.LENGTH_SHORT).show();
                       Out2 = response.split(Pattern.quote("."));
                        int i=0;

                        while(i<Out2.length)
                        {
                            r=new room_info();
                            r.setRoom(Out2[i]);
                            i++;
                            r.setPir(Out2[i]);
                            i++;
                            r.setIr1(Out2[i]);
                            i++;
                            r.setIr2(Out2[i]);
                            i++;
                            r.setLight(Out2[i]);
                            i++;
                            r.setDoor(Out2[i]);
                            i++;
                            //list.add(r);
                        }
                       //* for(room_info r:list)
                        {//*
                            p=Integer.parseInt(r.getPir());
                            d=Integer.parseInt(r.getDoor());
                            i1=Integer.parseInt(r.getIr1());
                            i2=Integer.parseInt(r.getIr2());
                            l=Integer.parseInt(r.getLight());


                   float res= (float) ((((2*p)+i1+i2+(2*l)-(d*0.5))/6)*100);
                            pb.setVisibility(View.GONE);
                        et.setText(String.valueOf(res));


                        }

                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(show.this,error.toString(),Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                //       params.put("Content-Type", "application/json");
                params.put("room",room);
                return params;
            }
            public Map<String,String> getHeaders() throws AuthFailureError{
                Map<String,String> params =new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };
        MySingleton.getInstance(show.this).addToRequestQueue(jsonObjectRequest);


    }
}
