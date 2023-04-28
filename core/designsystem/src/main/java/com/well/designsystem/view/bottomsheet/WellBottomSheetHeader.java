package com.well.designsystem.view.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.well.designsystem.R;
import com.well.designsystem.databinding.BottomSheetViewHeaderBinding;

import androidx.annotation.Nullable;

public class WellBottomSheetHeader extends LinearLayout {
    private BottomSheetViewHeaderBinding viewBinding;

    public WellBottomSheetHeader(Context context) {
        super(context);
        this.initView(context, null);
    }

    public WellBottomSheetHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initView(context, attrs);
    }

    public WellBottomSheetHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WellBottomSheetHeader);
        String bottomSheetTitle = typedArray.getString(R.styleable.WellBottomSheetHeader_bottomSheetTitle);
        boolean isShowGrabber = typedArray.getBoolean(R.styleable.WellBottomSheetHeader_bottomSheetShowGrabber, true);
        boolean isShowCloseButton = typedArray.getBoolean(R.styleable.WellBottomSheetHeader_bottomSheetShowCloseButton, false);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.viewBinding = BottomSheetViewHeaderBinding.inflate(inflater, this, true);
        if (TextUtils.isEmpty(bottomSheetTitle)) {
            this.viewBinding.viewTitle.setVisibility(GONE);
        } else {
            this.viewBinding.tvTitle.setText(bottomSheetTitle);
        }
        this.viewBinding.ivClose.setVisibility(isShowCloseButton ? VISIBLE : INVISIBLE);
        this.viewBinding.viewScrollGrabber.setVisibility(isShowGrabber ? VISIBLE : GONE);
        typedArray.recycle();
    }

    public void setTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            this.viewBinding.viewTitle.setVisibility(GONE);
        } else {
            this.viewBinding.viewTitle.setVisibility(VISIBLE);
            this.viewBinding.tvTitle.setText(title);
        }
    }

    public void setViewTitleVisible(boolean isVisible) {
        this.viewBinding.viewTitle.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public void setGrabberVisible(boolean isVisible) {
        this.viewBinding.viewScrollGrabber.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public void setCloseButtonIcon(Drawable icon) {
        this.viewBinding.ivClose.setImageDrawable(icon);
    }

    public boolean isCloseButtonVisible() {
        return this.viewBinding.ivClose.getVisibility() == VISIBLE;
    }

    public void setCloseButtonVisible(boolean isVisible) {
        this.viewBinding.ivClose.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }

    public void setCloseOnClickListener(OnClickListener listener) {
        this.viewBinding.ivClose.setOnClickListener(listener);
    }
}
