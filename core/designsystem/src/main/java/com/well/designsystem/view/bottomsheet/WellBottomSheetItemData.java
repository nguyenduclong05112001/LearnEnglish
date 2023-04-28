package com.well.designsystem.view.bottomsheet;

import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;

public class WellBottomSheetItemData {
    private @DrawableRes
    int iconRes;
    private Drawable iconDrawable;
    private String itemTitle;
    private boolean isSelected;

    public WellBottomSheetItemData(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public WellBottomSheetItemData(Drawable iconDrawable, String itemTitle) {
        this.iconDrawable = iconDrawable;
        this.itemTitle = itemTitle;
    }

    public WellBottomSheetItemData(int iconRes, String itemTitle) {
        this.iconRes = iconRes;
        this.itemTitle = itemTitle;
    }

    public WellBottomSheetItemData(int iconRes, String itemTitle, boolean isSelected) {
        this.iconRes = iconRes;
        this.itemTitle = itemTitle;
        this.isSelected = isSelected;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }
}
