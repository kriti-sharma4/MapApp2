package com.example.kritisharma.mapapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Kapil Sharma on 4/24/2018.
 */

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mctx;

    private MySingleton (Context context)
    {
        mctx=context;
        requestQueue=getRequestQueue();

    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static MySingleton getInstance (Context context)
    {
        if(mInstance==null)
        {
            mInstance=new MySingleton(context);
        }
        return mInstance;
    }
    public<T> void addToRequestQueue (Request<T> request)
    {
        requestQueue.add(request);

    }


}
