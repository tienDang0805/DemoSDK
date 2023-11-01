package com.examplesdk.libraryexample;

import android.content.Context;
import android.widget.Toast;

public class MathUtils {
    public static void simpleToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
