package com.well.designsystem.view.forminput;

import android.content.Context;
import android.util.AttributeSet;

import com.well.designsystem.R;
import com.well.designsystem.view.CustomTextView;

import androidx.core.content.ContextCompat;

public class WellTextFieldLabel extends CustomTextView {

    public WellTextFieldLabel(Context context) {
        super(context);
        init();
    }

    public WellTextFieldLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WellTextFieldLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        onNormalState();
    }

    public void onNormalState() {
        this.setTextColor(ContextCompat.getColor(getContext(), R.color.ink_3));
    }

    public void onTypingState() {
        this.setTextColor(ContextCompat.getColor(getContext(), R.color.brand));
    }

    public void onErrorState() {
        this.setTextColor(ContextCompat.getColor(getContext(), R.color.bittersweet));
    }

    public void onDisableState() {
        this.setTextColor(ContextCompat.getColor(getContext(), R.color.ink_3));
    }
}
