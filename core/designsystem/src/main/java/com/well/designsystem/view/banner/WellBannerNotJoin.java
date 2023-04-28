package com.well.designsystem.view.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.well.designsystem.R;
import com.well.designsystem.databinding.ViewBannerNotJointBinding;

/**
 * Created by Minhlv on 4/20/2021.
 */
public class WellBannerNotJoin extends RelativeLayout {
    private ViewBannerNotJointBinding binding;

    public WellBannerNotJoin(Context context) {
        super(context);
    }

    public WellBannerNotJoin(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }

    public WellBannerNotJoin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context, attrs);
    }

    public WellBannerNotJoin(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        LayoutInflater systemService = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.binding = ViewBannerNotJointBinding.inflate(systemService, this, true);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WellBanner);
        String bannerTitle = typedArray.getString(R.styleable.WellBanner_bannerTitle);
        String bannerSubTitle = typedArray.getString(R.styleable.WellBanner_bannerSubsTitle);
        String bannerDescription = typedArray.getString(R.styleable.WellBanner_bannerDescription);
        Drawable itemBanner = typedArray.getDrawable(R.styleable.WellBanner_bannerIcon);

        this.binding.ivBanner.setImageDrawable(itemBanner);
        this.binding.tvPlanDes.setText(bannerDescription);
        this.binding.tvPlanTitle.setText(bannerTitle);
        this.binding.tvSubTitle.setText(bannerSubTitle);
    }
}
