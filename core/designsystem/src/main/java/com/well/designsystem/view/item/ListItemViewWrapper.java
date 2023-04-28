package com.well.designsystem.view.item;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.well.designsystem.view.button.WellButton;
import com.well.designsystem.view.button.WellCheckBoxButton;
import com.well.designsystem.view.button.WellToggleButton;

public class ListItemViewWrapper {
    protected ImageView ivStartIcon;
    protected TextView tvTitle;
    protected TextView tvValueStyle1;
    protected TextView tvValueStyle2;

    protected TextView tvDescription;
    protected ImageView ivEndIcon;
    protected ImageView ivValueIcon;

    protected ProgressBar progressBar;
    protected TextView tvProgressValue;

    protected WellToggleButton btnToggle;
    protected WellCheckBoxButton btnCheckBox;
    protected WellButton btnButtonCta;

    public void wrapStartIcon(ImageView ivStartIcon) {
        this.ivStartIcon = ivStartIcon;
        this.ivStartIcon.setVisibility(View.VISIBLE);
    }

    public void wrapTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
        this.tvTitle.setVisibility(View.VISIBLE);
    }

    public void wrapTvValueStyle1(TextView tvValueStyle1) {
        this.tvValueStyle1 = tvValueStyle1;
        this.tvValueStyle1.setVisibility(View.VISIBLE);
    }

    public void wrapTvValueStyle2(TextView tvValueStyle2) {
        this.tvValueStyle2 = tvValueStyle2;
        this.tvValueStyle2.setVisibility(View.VISIBLE);
    }

    public void wrapTvDescription(TextView tvDescription) {
        this.tvDescription = tvDescription;
        this.tvDescription.setVisibility(View.VISIBLE);
    }

    public void wrapIvEndIcon(ImageView ivEndIcon) {
        this.ivEndIcon = ivEndIcon;
        this.ivEndIcon.setVisibility(View.VISIBLE);
    }

    public void wrapIvValueIcon(ImageView ivValueIcon) {
        this.ivValueIcon = ivValueIcon;
        this.ivValueIcon.setVisibility(View.VISIBLE);
    }

    public void wrapButtonToggle(WellToggleButton btnToggle) {
        this.btnToggle = btnToggle;
        this.btnToggle.setVisibility(View.VISIBLE);
    }

    public void wrapButtonCheckbox(WellCheckBoxButton btnCheckBox) {
        this.btnCheckBox = btnCheckBox;
        this.btnCheckBox.setVisibility(View.VISIBLE);
    }

    public void wrapButtonCta(WellButton btnButtonCta) {
        this.btnButtonCta = btnButtonCta;
        this.btnButtonCta.setVisibility(View.VISIBLE);
    }

    public void wrapProgressText(TextView tvProgressValue) {
        this.tvProgressValue = tvProgressValue;
        this.tvProgressValue.setVisibility(View.VISIBLE);
    }

    public void wrapProgress(ProgressBar progressBar) {
        this.progressBar = progressBar;
        this.progressBar.setVisibility(View.VISIBLE);
    }
}
