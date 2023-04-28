package com.well.designsystem.view.forminput;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.well.designsystem.R;

public class WellPickerIconWithLabel extends RelativeLayout implements OnStateChangedListener {

    private WellPickerIcon inputField;
    private WellTextFieldLabel textTitle;
    protected Drawable itemRightIcon;
    private OnListenerClick onListenerClick;

    public WellPickerIconWithLabel(Context context) {
        super(context);
        initView(context);
    }

    public WellPickerIconWithLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initStyle(context, attrs);
    }

    public WellPickerIconWithLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initStyle(context, attrs);
    }

    public WellPickerIconWithLabel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
        initStyle(context, attrs);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_picker_icon_label, this);
        this.inputField = inflate.findViewById(R.id.tvInputLabel);
        this.textTitle = inflate.findViewById(R.id.tvTitle);
        inputField.setOnStateChangedListener(this);
        inputField.setOnClickListener(v -> {
            if (onListenerClick != null) {
                onListenerClick.onClick();
            }
        });
    }

    public void setOnListenerClick(OnListenerClick onListenerClick) {
        this.onListenerClick = onListenerClick;
    }

    public String getValue() {
        return inputField.getText().toString();
    }

    public boolean isEmptyContent() {
        return TextUtils.isEmpty(this.inputField.getText().toString().trim());
    }

    private void initStyle(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray attributeArray = context.obtainStyledAttributes(attributeSet, R.styleable.WellPickerIconWithLabel);
        String title = attributeArray.getString(R.styleable.WellPickerIconWithLabel_title1);
        String hint = attributeArray.getString(R.styleable.WellPickerIconWithLabel_hint1);
        this.itemRightIcon = attributeArray.getDrawable(R.styleable.WellPickerIconWithLabel_itemPickerIcon1);

        this.textTitle.setText(title);
        inputField.setHint(hint);
        inputField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, itemRightIcon, null);
    }

    public void onNormalState() {
        this.inputField.onNormalState();
        this.textTitle.onNormalState();
    }

    public void onErrorState() {
        this.inputField.onErrorState();
        this.textTitle.onErrorState();
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

    public interface OnListenerClick {
        void onClick();
    }

    public WellPickerIcon getInputField() {
        return inputField;
    }

    public WellTextFieldLabel getTextTitle() {
        return textTitle;
    }
}
