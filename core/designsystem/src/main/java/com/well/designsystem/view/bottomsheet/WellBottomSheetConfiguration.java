package com.well.designsystem.view.bottomsheet;

import android.graphics.drawable.Drawable;

import java.util.List;

public class WellBottomSheetConfiguration {
    public static final int STYLE_LIST_ITEM = 1;
    public static final int STYLE_TEXT_CONTENT = 2;

    public static final int LIST_ITEM_STYLE_LINEAR = 1;
    public static final int LIST_ITEM_STYLE_GRID = 2;

    private List<WellBottomSheetItemData> listData;
    private String title;
    private String buttonPositiveText;
    private String buttonNegativeText;
    private String content;
    private boolean isCloseable = true;
    private boolean isCloseButtonVisible = false;
    private Drawable closeIcon;
    private int bottomSheetStyle = STYLE_LIST_ITEM;
    private int listItemStyle = LIST_ITEM_STYLE_LINEAR;

    public WellBottomSheetConfiguration(String title) {
        this.title = title;
    }

    public WellBottomSheetConfiguration(String title, String content) {
        this.title = title;
        this.content = content;
        this.bottomSheetStyle = STYLE_TEXT_CONTENT;
    }

    public WellBottomSheetConfiguration(List<WellBottomSheetItemData> listData) {
        this.listData = listData;
        this.bottomSheetStyle = STYLE_LIST_ITEM;
    }

    public WellBottomSheetConfiguration(List<WellBottomSheetItemData> listData, String title) {
        this.listData = listData;
        this.title = title;
        this.bottomSheetStyle = STYLE_LIST_ITEM;
    }

    public WellBottomSheetConfiguration(List<WellBottomSheetItemData> listData, String title, String buttonPositiveText) {
        this.listData = listData;
        this.title = title;
        this.buttonPositiveText = buttonPositiveText;
        this.bottomSheetStyle = STYLE_LIST_ITEM;
    }

    public boolean isCloseable() {
        return this.isCloseable;
    }

    public WellBottomSheetConfiguration setCloseable(boolean closeable) {
        isCloseable = closeable;
        return this;
    }

    public int getBottomSheetStyle() {
        return this.bottomSheetStyle;
    }

    public WellBottomSheetConfiguration setBottomSheetStyle(int bottomSheetStyle) {
        this.bottomSheetStyle = bottomSheetStyle;
        return this;
    }

    public int getListItemStyle() {
        return this.listItemStyle;
    }

    public WellBottomSheetConfiguration setListItemStyle(int listItemStyle) {
        this.listItemStyle = listItemStyle;
        return this;
    }

    public String getContent() {
        return this.content;
    }

    public WellBottomSheetConfiguration setContent(String content) {
        this.content = content;
        return this;
    }

    public List<WellBottomSheetItemData> getListData() {
        return this.listData;
    }

    public WellBottomSheetConfiguration setListData(List<WellBottomSheetItemData> listData) {
        this.listData = listData;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public WellBottomSheetConfiguration setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getButtonPositiveText() {
        return this.buttonPositiveText;
    }

    public WellBottomSheetConfiguration setButtonPositiveText(String buttonPositiveText) {
        this.buttonPositiveText = buttonPositiveText;
        return this;
    }

    public String getButtonNegativeText() {
        return this.buttonNegativeText;
    }

    public WellBottomSheetConfiguration setButtonNegativeText(String buttonNegativeText) {
        this.buttonNegativeText = buttonNegativeText;
        return this;
    }

    public Drawable getCloseIcon() {
        return this.closeIcon;
    }

    public WellBottomSheetConfiguration setCloseIcon(Drawable closeIcon) {
        this.closeIcon = closeIcon;
        return this;
    }

    public boolean isCloseButtonVisible() {
        return this.isCloseButtonVisible;
    }

    public WellBottomSheetConfiguration setCloseButtonVisible(boolean closeButtonVisible) {
        this.isCloseButtonVisible = closeButtonVisible;
        return this;
    }
}
