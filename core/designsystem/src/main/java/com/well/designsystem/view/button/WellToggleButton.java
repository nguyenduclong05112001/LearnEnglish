package com.well.designsystem.view.button;

import android.content.Context;
import android.util.AttributeSet;

import com.well.designsystem.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatToggleButton;

public class WellToggleButton extends AppCompatToggleButton {
    public WellToggleButton(@NonNull Context context) {
        super(context);
        this.init(context);
    }

    public WellToggleButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public WellToggleButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context);
    }

    private void init(Context context) {
        this.setBackgroundResource(R.drawable.selector_toggle_button);
        this.setTextOff("");
        this.setTextOn("");
        this.setText("");
    }

}
