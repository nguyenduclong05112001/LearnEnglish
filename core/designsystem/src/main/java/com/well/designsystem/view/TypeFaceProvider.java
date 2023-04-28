package com.well.designsystem.view;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by Minhlv on 5/28/2020.
 */
public class TypeFaceProvider {

    private static Hashtable<String, Typeface> sTypeFaces = new Hashtable<String, Typeface>(
            4);

    public static Typeface getTypeFace(Context context, String fileName) {
        Typeface tempTypeface = sTypeFaces.get(fileName);

        if (tempTypeface == null) {
            tempTypeface = Typeface.createFromAsset(context.getAssets(), fileName);
            sTypeFaces.put(fileName, tempTypeface);
        }
        return tempTypeface;
    }
}
