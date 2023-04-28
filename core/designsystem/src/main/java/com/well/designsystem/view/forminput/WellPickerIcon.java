package com.well.designsystem.view.forminput;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.well.designsystem.R;
import com.well.designsystem.view.CustomTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WellPickerIcon extends CustomTextView implements WellPicker {

    private OnStateChangedListener listener;
    protected TypedArray attributeArray;
    protected Drawable itemRightIcon;

    public WellPickerIcon(@NonNull Context context) {
        super(context);
        this.init(context, null);
    }

    public WellPickerIcon(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }

    public WellPickerIcon(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context, attrs);
    }

    public String getValue() {
        return this.getText().toString();
    }

    public void setValue(String value) {
        this.setText(value);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void init(Context context, @Nullable AttributeSet attrs) {
        this.setOnTouchListener((v, event) -> {
//            onNormalState();
            return false;
        });

        if (attrs == null) {
            return;
        }
        try {
            this.attributeArray = context.obtainStyledAttributes(attrs, R.styleable.WellPickerIcon);
            this.itemRightIcon = attributeArray.getDrawable(R.styleable.WellPickerIcon_itemPickerIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();
    }

    private void initView() {
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, itemRightIcon, null);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean isEmptyContent() {
        return TextUtils.isEmpty(this.getText().toString().trim());
    }

    @Override
    public void onNormalState() {
        this.setBackgroundResource(R.drawable.selector_picker);
        if(listener != null) {
            this.listener.onNormal();
        }
    }

    @Override
    public void onErrorState() {
        this.setBackgroundResource(R.drawable.shape_text_field_error);
        if(listener != null) {
            this.listener.onError();
        }
    }
}
