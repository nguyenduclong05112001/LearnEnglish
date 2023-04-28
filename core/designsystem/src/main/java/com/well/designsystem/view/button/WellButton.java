package com.well.designsystem.view.button;

import android.content.Context;
import android.util.AttributeSet;

import com.well.designsystem.view.CustomTextView;

import androidx.core.content.ContextCompat;

public class WellButton extends CustomTextView {
    public WellButton(Context context) {
        super(context);
    }

    public WellButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WellButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void enable() {
        this.setEnabled(true);
    }

    public void disable() {
        this.setEnabled(false);
    }

    public void setTextColorButton(int colorId) {
        this.setTextColor(ContextCompat.getColor(getContext(), colorId));
    }

    public void setStartIcon(int resource) {
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), resource), null, null, null);
    }
}
