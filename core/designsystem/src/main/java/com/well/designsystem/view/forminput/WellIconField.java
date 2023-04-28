package com.well.designsystem.view.forminput;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.well.designsystem.R;
import com.well.designsystem.view.CustomEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class WellIconField extends CustomEditText {

    private OnStateChangedListener listener;
    private OnActionListener onActionListener;

    public WellIconField(@NonNull Context context) {
        super(context);
        this.init();
    }

    public WellIconField(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public WellIconField(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        onNormalState();
        this.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                onTypingState();
            } else {
                onNormalState();
            }
        });
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!hasFocus()) {
                    return;
                }

                if (!TextUtils.isEmpty(s.toString().trim())) {
                    setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_search), null, ContextCompat.getDrawable(getContext(), R.drawable.ic_close_full), null);
                } else {
                    setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_search), null, null, null);
                }
            }
        });
    }

    public boolean isEmptyContent() {
        return TextUtils.isEmpty(this.getText().toString().trim());
    }

    public void clearFocusWellText() {
        this.setFocusable(false);
        this.setFocusableInTouchMode(false);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.listener = listener;
    }

    public void setOnActionListener(OnActionListener listener) {
        this.onActionListener = listener;
    }

    public void onNormalState() {
        this.setBackgroundResource(R.drawable.shape_icon_field_normal);
        this.setEnabled(true);
        this.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_search), null, null, null);
        if (listener != null) {
            listener.onNormal();
        }
    }

    public void setValue(String value) {
        onNormalState();
        this.setText(value != null ? value.trim() : "");
    }

    public void onTypingState() {
        this.setBackgroundResource(R.drawable.shape_icon_field_normal);
        if (getText() != null && !TextUtils.isEmpty(getText().toString().trim())) {
            setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_search), null, ContextCompat.getDrawable(getContext(), R.drawable.ic_close_full), null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_search), null, null, null);
        }
        if (listener != null) {
            listener.onTyping();
        }
    }


    public void onDisableState() {
        this.setBackgroundResource(R.drawable.shape_icon_field_normal);
        this.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_search), null, null, null);
        this.setEnabled(false);
    }

    public String getContent() {
        if (getText() != null && !TextUtils.isEmpty(getText().toString().trim())) {
            return getText().toString().trim();
        }
        return "";
    }

    private void clearContent() {
        if (getText() != null && !TextUtils.isEmpty(getText().toString().trim())) {
            getText().clear();
        }
        this.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_search), null, null, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Drawable drawableRight = getCompoundDrawables()[2];
            if (drawableRight != null) {
                //The x-axis coordinates of this click event, if > current control width - control right spacing - drawable actual display size
                if (event.getX() >= (getWidth() - getPaddingRight() - drawableRight.getIntrinsicWidth())) {
                    if (hasFocus()) {
                        if(onActionListener != null) {
                            onActionListener.onActionEndClick();
                        }
                        clearContent();
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

}
