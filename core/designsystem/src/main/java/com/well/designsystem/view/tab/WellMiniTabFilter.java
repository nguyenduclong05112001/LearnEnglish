package com.well.designsystem.view.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.well.designsystem.R;
import com.well.designsystem.databinding.ViewMiniTabFilterBinding;

public class WellMiniTabFilter extends FrameLayout {

    private ViewMiniTabFilterBinding binding;
    private Context context;
    private TypedArray attributeArray;
    private String title;

    public WellMiniTabFilter(@NonNull Context context) {
        super(context);
        initView(null, context);
    }

    public WellMiniTabFilter(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs, context);
    }

    public WellMiniTabFilter(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs, context);
    }

    public WellMiniTabFilter(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(attrs, context);
    }

    private void initView(AttributeSet attrs, Context context) {
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.binding = ViewMiniTabFilterBinding.inflate(inflater, this, true);

        if (attrs == null) {
            return;
        }
        try {
            this.attributeArray = context.obtainStyledAttributes(attrs, R.styleable.WellTab);
            this.title = this.attributeArray.getString(R.styleable.WellTab_android_text);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.binding.tvFilter.setText(title);
    }

    public void setTitle(String title) {
        this.title = title;
        binding.tvFilter.setText(title);
    }
}
