package com.well.designsystem.view.forminput;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.RelativeLayout;

import com.well.designsystem.R;

import androidx.core.content.ContextCompat;

public class WellInputIconField extends RelativeLayout implements OnStateChangedListener {
    private WellIconField inputField;
    private OnActionListener onActionListener;

    public WellInputIconField(Context context) {
        super(context);
        initView(context);
    }

    public WellInputIconField(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initStyle(context, attrs);
    }

    public WellInputIconField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initStyle(context, attrs);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_input_icon, this);
        this.inputField = inflate.findViewById(R.id.tvInputField);
        inputField.setOnStateChangedListener(this);
    }

    private void initStyle(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray attributeArray = context.obtainStyledAttributes(attributeSet, R.styleable.WellInputIconField);
        int inputType = attributeArray.getInt(R.styleable.WellInputIconField_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL);
        int imeOption = attributeArray.getInt(R.styleable.WellInputIconField_android_imeOptions, EditorInfo.TYPE_TEXT_VARIATION_NORMAL);

        this.inputField.setInputType(inputType);
        this.inputField.setImeOptions(imeOption);
    }

    public void onNormalState() {
        this.inputField.onNormalState();
    }

    public void onTypingState() {
        this.inputField.onTypingState();
    }

    public void onDisableState() {
        this.inputField.onDisableState();
    }

    public void setValue(String value) {
        inputField.setValue(value);
    }

    public void setHintValue(String hint) {
        inputField.setHint(hint);
    }

    public void setHintColor(int color) {
        inputField.setHintTextColor(ContextCompat.getColor(getContext(), color));
    }

    public WellIconField getInputField() {
        return inputField;
    }

    public void setOnActionListener(OnActionListener onActionListener) {
        this.onActionListener = onActionListener;
        this.inputField.setOnActionListener(onActionListener);
    }

    @Override
    public void onTyping() {

    }

    @Override
    public void onNormal() {

    }

    @Override
    public void onError() {

    }
}
