package com.well.designsystem.view.button;

import android.content.Context;
import android.util.AttributeSet;

import com.well.designsystem.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;

public class WellCheckBoxButton extends AppCompatCheckBox {
    public WellCheckBoxButton(@NonNull Context context) {
        super(context);
        this.init(context);
    }

    public WellCheckBoxButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context);
    }

    public WellCheckBoxButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context);
    }

    private void init(Context context) {
        this.setButtonDrawable(R.drawable.selector_checkbox);
    }
}
