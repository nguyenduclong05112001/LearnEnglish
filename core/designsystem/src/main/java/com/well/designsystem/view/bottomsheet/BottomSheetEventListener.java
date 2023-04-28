package com.well.designsystem.view.bottomsheet;

import com.well.designsystem.view.item.WellListItem;

public abstract class BottomSheetEventListener {
    public void onItemClick(int position) {}

    public void onItemClick(int position, WellListItem itemView) {}

    public void onButtonPositiveClick() {}

    public void onButtonPositiveClick(int selectedItem) {}

    public void onButtonNegativeClick() {}

    public void onCloseClick() {}

    public void onCancel() {}

    public void onDismiss() {}
}
