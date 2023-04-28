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

public class WellInputTextFieldWithLabel extends RelativeLayout implements OnStateChangedListener {

    private WellTextField inputField;
    private WellTextFieldLabel textTitle;
    private int titleVisibility;

    public WellInputTextFieldWithLabel(Context context) {
        super(context);
        initView(context);
    }

    public WellInputTextFieldWithLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initStyle(context, attrs);
    }

    public WellInputTextFieldWithLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initStyle(context, attrs);
    }

    public WellInputTextFieldWithLabel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
        initStyle(context, attrs);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_input_text_label, this);
        this.inputField = inflate.findViewById(R.id.tvInputLabel);
        this.textTitle = inflate.findViewById(R.id.tvTitle);
        inputField.setOnStateChangedListener(this);
    }

    private void initStyle(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray attributeArray = context.obtainStyledAttributes(attributeSet, R.styleable.WellInputTextField);
        String title = attributeArray.getString(R.styleable.WellInputTextField_title);
        this.titleVisibility = attributeArray.getInt(R.styleable.WellInputTextField_titleVisibility, VISIBLE);
        int inputType = attributeArray.getInt(R.styleable.WellInputTextField_android_inputType, EditorInfo.TYPE_TEXT_VARIATION_NORMAL);
        int imeOption = attributeArray.getInt(R.styleable.WellInputTextField_android_imeOptions, EditorInfo.TYPE_TEXT_VARIATION_NORMAL);
        boolean enableErrorState = attributeArray.getBoolean(R.styleable.WellInputTextField_enableErrorState, true);

        this.textTitle.setVisibility(titleVisibility);
        this.textTitle.setText(title);
        this.inputField.setInputType(inputType);
        this.inputField.setImeOptions(imeOption);
        this.inputField.setEnableErrorState(enableErrorState);
    }

    public void onNormalState() {
        this.inputField.onNormalState();
        this.textTitle.onNormalState();
        this.textTitle.setVisibility(titleVisibility);
    }

    public void onTypingState() {
        this.inputField.onTypingState();
        this.textTitle.onTypingState();
        this.textTitle.setVisibility(titleVisibility);
    }

    public void onErrorState() {
        this.inputField.onErrorState();
        this.textTitle.onErrorState();
        this.textTitle.setVisibility(titleVisibility);
    }

    public void onDisableState() {
        this.inputField.onDisableState();
        this.textTitle.onDisableState();
        this.textTitle.setVisibility(titleVisibility);
    }

    @Override
    public void onTyping() {
        this.textTitle.onTypingState();
    }

    @Override
    public void onNormal() {
        this.textTitle.onNormalState();
    }

    @Override
    public void onError() {
        this.textTitle.onErrorState();
    }

    public void setValue(String value) {
        inputField.setValue(value);
    }


    public void setHintValue(String hint) {
        inputField.setHint(hint);
    }

    public WellTextField getInputField() {
        return inputField;
    }

    public WellTextFieldLabel getTextTitle() {
        return textTitle;
    }
}
