package com.well.designsystem.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;

import com.well.designsystem.R;

import java.util.Arrays;
import java.util.List;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;

/**
 * Created by Minh Lv on 11/23/2017.
 */

public class CustomEditText extends AppCompatEditText {

    private List<String> fonts = Arrays.asList("fonts/GoogleSans-Regular.otf", "fonts/GoogleSans-Medium.otf", "fonts/GoogleSans-Bold.otf");

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        try {
            TypedArray attributeArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTextView);
            int typeface_index = attributeArray.getInt(R.styleable.CustomTextView_textFont, 0);
            boolean isSelected = attributeArray.getBoolean(R.styleable.CustomTextView_selected, false);

            Drawable drawableStart = null;
            Drawable drawableEnd = null;
            Drawable drawableBottom = null;
            Drawable drawableTop = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                drawableStart = attributeArray.getDrawable(R.styleable.CustomTextView_drawableStartCompat);
                drawableEnd = attributeArray.getDrawable(R.styleable.CustomTextView_drawableEndCompat);
                drawableBottom = attributeArray.getDrawable(R.styleable.CustomTextView_drawableBottomCompat);
                drawableTop = attributeArray.getDrawable(R.styleable.CustomTextView_drawableTopCompat);
            } else {
                final int drawableStartId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableStartCompat, -1);
                final int drawableEndId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableEndCompat, -1);
                final int drawableBottomId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableBottomCompat, -1);
                final int drawableTopId = attributeArray.getResourceId(R.styleable.CustomTextView_drawableTopCompat, -1);

                if (drawableStartId != -1)
                    drawableStart = AppCompatResources.getDrawable(context, drawableStartId);
                if (drawableEndId != -1)
                    drawableEnd = AppCompatResources.getDrawable(context, drawableEndId);
                if (drawableBottomId != -1)
                    drawableBottom = AppCompatResources.getDrawable(context, drawableBottomId);
                if (drawableTopId != -1)
                    drawableTop = AppCompatResources.getDrawable(context, drawableTopId);
            }

            // to support rtl
            setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart, drawableTop, drawableEnd, drawableBottom);

            setSelected(isSelected);
//            Typeface typeface = Typeface.createFromAsset(context.getAssets(), fonts.get(typeface_index));
            Typeface typeface = TypeFaceProvider.getTypeFace(context, fonts.get(typeface_index));
            super.setTypeface(typeface);

            attributeArray.recycle();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
