package com.example.mymedicine;

import android.content.Context;
import android.widget.Toast;

public class Message {

    public static void message (Context c, String m) {

        Toast.makeText(c,m,Toast.LENGTH_LONG).show();

    }


}
