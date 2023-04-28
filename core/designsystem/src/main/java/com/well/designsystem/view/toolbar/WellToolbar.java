package com.well.designsystem.view.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.well.designsystem.R;
import com.well.designsystem.view.CustomTextView;

public class WellToolbar extends RelativeLayout {
    //<editor-fold desc="Properties">
    final int STYLE_TITLE_2ICON = -1;
    final int STYLE_LOGO = 0;
    final int STYLE_TITLE = 1;
    final int STYLE_BACK_TITLE = 2;
    final int STYLE_BACK_TITLE_BUTTON = 3;
    final int STYLE_BACK_TITLE_ICON = 4;
    final int STYLE_BACK_TITLE_2ICON = 5;
    final int STYLE_BACK_TITLE_SELECT = 7;
    int toolbarStyle;
    private OnToolbarActionListener listener;
    private OnToolbarSelectListener selectListener;
    private Drawable iconAction1, iconAction2, logo;
    private boolean hideDidiver = false;
    private String textCta;
    private Toolbar toolbarView;
    private View dividerView;
    private CustomTextView tvTitleSelect;
    private Drawable backIcon;
    private MenuItem itemAction1, itemAction2;
    private boolean disableCta;
    //</editor-fold>

    public WellToolbar(Context context) {
        super(context);
        initView(context, null);
    }

    public WellToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public WellToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        View viewRoot = LayoutInflater.from(context).inflate(R.layout.layout_toolbar, this);
        this.toolbarView = viewRoot.findViewById(R.id.toolbar_view);
        this.dividerView = viewRoot.findViewById(R.id.divider_toolbar_view);
        this.tvTitleSelect = viewRoot.findViewById(R.id.tvTitleSelect);
        this.initToolbar(context, attrs);
    }

    private void initToolbar(Context context, AttributeSet attrs) {
        this.setBackgroundColor(ContextCompat.getColor(context, R.color.white_5));
        if (attrs != null) {
            TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.WellToolbar);
            this.toolbarStyle = attributeArray.getInt(R.styleable.WellToolbar_toolbarViewStyle, STYLE_BACK_TITLE);
            String title = attributeArray.getString(R.styleable.WellToolbar_toolbarTitle);
            this.textCta = attributeArray.getString(R.styleable.WellToolbar_toolbarTextCta);
            this.iconAction1 = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarAction1);
            this.iconAction2 = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarAction2);
            this.logo = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarLogo);
            this.hideDidiver = attributeArray.getBoolean(R.styleable.WellToolbar_toolbarHideDivider, false);
            this.disableCta = attributeArray.getBoolean(R.styleable.WellToolbar_toolbarDisableCta, false);
            this.backIcon = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarBackIcon);

            if (toolbarStyle == STYLE_TITLE || toolbarStyle == STYLE_TITLE_2ICON) {
                this.toolbarView.setTitleTextAppearance(context, R.style.ToolbarTitle_Large);
            } else {
                this.toolbarView.setTitleTextAppearance(context, R.style.ToolbarTitle_Normal);
            }
            if (toolbarStyle != STYLE_LOGO && toolbarStyle != STYLE_BACK_TITLE_SELECT) {
                this.setTitle(title);
            } else if (toolbarStyle == STYLE_BACK_TITLE_SELECT) {
                this.toolbarView.setTitle("");
                this.tvTitleSelect.setVisibility(VISIBLE);
                this.tvTitleSelect.setText(title);
            } else {
                this.toolbarView.setLogo(logo);
            }
            this.dividerView.setVisibility(this.hideDidiver ? GONE : VISIBLE);
        }
    }

    public Toolbar getToolbar() {
        return this.toolbarView;
    }

    public void setOnToolbarActiontListener(OnToolbarActionListener listener) {
        this.listener = listener;
    }

    public void setSelectListener(OnToolbarSelectListener selectListener) {
        this.selectListener = selectListener;
        tvTitleSelect.setOnClickListener(v -> selectListener.onSelectClick());
    }

    public boolean onCreateOptionsMenu(AppCompatActivity context, Menu menu) {
        ActionBar supportActionBar = context.getSupportActionBar();
        if (hasBackButton() && supportActionBar != null) {
            if (backIcon == null) {
                backIcon = ContextCompat.getDrawable(context, R.drawable.ic_back);
            }
            supportActionBar.setHomeAsUpIndicator(backIcon);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        context.getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        itemAction1 = menu.findItem(R.id.action_1);
        itemAction2 = menu.findItem(R.id.action_2);
        if (this.toolbarStyle == STYLE_BACK_TITLE_2ICON || this.toolbarStyle == STYLE_TITLE_2ICON
                || this.toolbarStyle == STYLE_LOGO) {
            if (this.iconAction1 != null) {
                itemAction1.setIcon(this.iconAction1);
                itemAction1.setVisible(true);

            } else {
                itemAction1.setVisible(false);
            }
            if (this.iconAction2 != null) {
                itemAction2.setIcon(this.iconAction2);
                itemAction2.setVisible(true);
            } else {
                itemAction2.setVisible(false);
            }
        } else if (this.toolbarStyle == STYLE_BACK_TITLE_ICON && this.iconAction2 != null) {
            itemAction1.setVisible(false);
            itemAction2.setIcon(this.iconAction2);
        } else if ((this.toolbarStyle == STYLE_BACK_TITLE_BUTTON || this.toolbarStyle == STYLE_BACK_TITLE_SELECT) && !TextUtils.isEmpty(textCta)) {
            itemAction1.setVisible(false);
            itemAction2.setTitle(textCta);
            if (disableCta) {
                updateTitleCta(false);
            }
        } else {
            itemAction1.setVisible(false);
            itemAction2.setVisible(false);
        }
        return true;
    }

    public void updateTitleCta(boolean isEnable) {
        if (itemAction2 == null) {
            return;
        }
        SpannableString spanString = new SpannableString(itemAction2.getTitle().toString());
        spanString.setSpan(new ForegroundColorSpan(isEnable ? getResources().getColor(R.color.pri_4) : getResources().getColor(R.color.ink_2)), 0, spanString.length(), 0); //fix the color to white
        itemAction2.setTitle(spanString);
        itemAction2.setEnabled(isEnable);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_1) {
            if (listener != null) {
                listener.onToolbarAction1Click();
            }
            return true;
        } else if (itemId == R.id.action_2) {
            if (listener != null) {
                if (toolbarStyle == STYLE_BACK_TITLE_BUTTON) {
                    listener.onToolbarTextCtaClick();
                } else {
                    listener.onToolbarAction2Click();
                }
            }
            return true;
        }
        return false;
    }

    public boolean hasBackButton() {
        return this.toolbarStyle > STYLE_TITLE;
    }

    public void setVisibleAction2(boolean isVisible) {
        int size = this.toolbarView.getMenu().size();
        if (size >= 2) {
            MenuItem item = this.toolbarView.getMenu().getItem(1);
            if (item != null) {
                item.setVisible(isVisible);
            }
        }

    }

    public void setVisibleAction1(boolean isVisible) {
        int size = this.toolbarView.getMenu().size();
        if (size >= 1) {
            MenuItem item = this.toolbarView.getMenu().getItem(0);
            if (item != null) {
                item.setVisible(isVisible);
            }
        }
    }

    public void setVisibleDivider(boolean isVisible) {
        this.dividerView.setVisibility(isVisible ? VISIBLE : GONE);
    }

    public CharSequence getTitle() {
        return this.toolbarView.getTitle();
    }

    public void setTitle(String title) {
        this.toolbarView.setTitle(title);
    }

    public void setTitle(int title) {
        this.toolbarView.setTitle(title);
    }

    public void setIconAction1(Drawable iconAction1) {
        this.iconAction1 = iconAction1;
    }

    public void setIconAction2(Drawable iconAction2) {
        this.iconAction2 = iconAction2;
    }

    public MenuItem getItemAction1() {
        return itemAction1;
    }

    public MenuItem getItemAction2() {
        return itemAction2;
    }
}
