package com.well.designsystem.view.label;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.well.designsystem.R;
import com.well.designsystem.databinding.LabelBinding;
import com.well.designsystem.view.TypeFaceProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class WellLabel extends FrameLayout {

    private LabelBinding binding;

    public WellLabel(@NonNull Context context) {
        super(context);
        this.init(context, null);
    }

    public WellLabel(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }

    public WellLabel(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        binding = LabelBinding.inflate(LayoutInflater.from(context), this, true);
        if (attrs != null) {
            TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.WellLabel);
            String titleText = attributeArray.getString(R.styleable.WellLabel_textTitle);
            String actionText = attributeArray.getString(R.styleable.WellLabel_textAction);
            String desText = attributeArray.getString(R.styleable.WellLabel_textDes);
            binding.tvLabelTitle.setText(titleText);
            binding.tvLabelAction.setText(actionText);

            if (desText != null && !desText.isEmpty()) {
                binding.tvLabelDes.setText(desText);
                binding.tvLabelDes.setVisibility(VISIBLE);
            }
        }
    }

    public void setOnActionClickListener(OnClickListener onClickListener) {
        this.binding.tvLabelAction.setOnClickListener(onClickListener);
    }

    public void setTextAction(String textAction) {
        binding.tvLabelAction.setText(textAction);
    }

    public void setTextTitle(String textAction) {
        binding.tvLabelTitle.setText(textAction);
    }

    public void setTextDes(String textDes) {
        if (textDes != null && !textDes.isEmpty()) {
            binding.tvLabelDes.setText(textDes);
            binding.tvLabelDes.setVisibility(VISIBLE);
        } else {
            binding.tvLabelDes.setText(View.GONE);
        }
    }
}
