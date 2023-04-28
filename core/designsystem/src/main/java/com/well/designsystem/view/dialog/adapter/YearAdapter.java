package com.well.designsystem.view.dialog.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.well.designsystem.R;
import com.well.designsystem.databinding.ItemMonthYearPickerBinding;
import com.well.designsystem.view.dialog.model.YearDataItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class YearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<YearDataItem> listYear;
    private Context context;
    private OnItemSelectListener listener;

    @SuppressLint("SimpleDateFormat")
    public YearAdapter(Context context, List<YearDataItem> listYear) {
        this.context = context;
        this.listYear = listYear;
    }

    public void setOnItemSelectListener(OnItemSelectListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMonthYearPickerBinding binding = ItemMonthYearPickerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new YearViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        YearDataItem itemData = listYear.get(position);
        YearViewHolder viewHolder = (YearViewHolder) holder;
        viewHolder.bindView(position, itemData);
    }

    @Override
    public int getItemCount() {
        return this.listYear != null ? this.listYear.size() : 0;
    }

    public interface OnItemSelectListener {
        void onSelect(int position, YearDataItem yearDataItem);
    }

    class YearViewHolder extends RecyclerView.ViewHolder {
        private ItemMonthYearPickerBinding binding;

        public YearViewHolder(@NonNull ItemMonthYearPickerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindView(int position, YearDataItem dataItem) {
            this.binding.tvContent.setText(String.valueOf(dataItem.getYear()));
            switch (dataItem.getState()) {
                case NORMAL:
                    this.binding.viewRoot.setSelected(false);
                    this.binding.tvContent.setTextColor(ContextCompat.getColor(context, R.color.ink_3));
                    this.binding.viewRoot.setClickable(true);
                    break;
                case SELECTED:
                    this.binding.viewRoot.setSelected(true);
                    this.binding.tvContent.setTextColor(ContextCompat.getColor(context, R.color.pri_4));
                    this.binding.viewRoot.setClickable(true);
                    break;
            }

            this.binding.viewRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dataItem.getState() == YearDataItem.State.NORMAL) {
                        dataItem.setState(YearDataItem.State.SELECTED);
                        notifyItemChanged(position);
                    }
                    if (listener != null) {
                        listener.onSelect(position, dataItem);
                    }
                }
            });
        }
    }
}
