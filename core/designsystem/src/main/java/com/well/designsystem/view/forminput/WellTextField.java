package com.well.designsystem.view.forminput;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.well.designsystem.R;
import com.well.designsystem.view.CustomEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class WellTextField extends CustomEditText {

    private OnStateChangedListener listener;
    private boolean enableErrorState = true;

    public WellTextField(@NonNull Context context) {
        super(context);
        this.init();
    }

    public WellTextField(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public WellTextField(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        onNormalState();
        this.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    onTypingState();
                } else {
                    //=>Check empty
                    if (isEmptyContent() && enableErrorState) {
                        onErrorState();
                    } else {
                        onNormalState();
                    }
                }
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
                    setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getContext(), R.drawable.ic_close), null);
                } else {
                    setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                }
            }
        });
    }

    public void setEnableErrorState(boolean enableErrorState) {
        this.enableErrorState = enableErrorState;
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

    public void onNormalState() {
        this.setBackgroundResource(R.drawable.shape_text_field_normal);
        this.setEnabled(true);
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (listener != null) {
            listener.onNormal();
        }
    }

    public void setValue(String value) {
        if (value != null && TextUtils.isEmpty(value.trim()) && enableErrorState) {
            onErrorState();
        } else {
            onNormalState();
            this.setText(value != null ? value.trim() : "");
        }
    }

    public void onTypingState() {
        this.setBackgroundResource(R.drawable.shape_text_field_focus);
        if (getText() != null && !TextUtils.isEmpty(getText().toString().trim())) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getContext(), R.drawable.ic_close), null);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        if (listener != null) {
            listener.onTyping();
        }
    }

    public void onErrorState() {
        this.setBackgroundResource(R.drawable.shape_text_field_error);
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getContext(), R.drawable.ic_error_empty), null);
        if (listener != null) {
            listener.onError();
        }
    }

    public void onDisableState() {
        this.setBackgroundResource(R.drawable.shape_text_field_normal);
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.setEnabled(false);
    }

    public boolean isContentValid() {
        if (getText() != null && !TextUtils.isEmpty(getText().toString().trim())) {
            return true;
        }
        if (enableErrorState) {
            onErrorState();
        }
        return false;
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
        this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Drawable drawableRight = getCompoundDrawables()[2];
            if (drawableRight != null) {
                //The x-axis coordinates of this click event, if > current control width - control right spacing - drawable actual display size
                if (event.getX() >= (getWidth() - getPaddingRight() - drawableRight.getIntrinsicWidth())) {
                    if (hasFocus()) {
                        clearContent();
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

}
