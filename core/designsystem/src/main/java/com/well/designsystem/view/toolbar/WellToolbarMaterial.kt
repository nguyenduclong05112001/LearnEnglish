package com.well.designsystem.view.toolbar

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.well.designsystem.R
import com.well.designsystem.databinding.LayoutToolbarMaterialBinding

class WellToolbarMaterial : FrameLayout {
    private lateinit var binding: LayoutToolbarMaterialBinding
    private lateinit var itemAction1: MenuItem
    private lateinit var itemAction2: MenuItem
    private lateinit var itemAction3: MenuItem
    private var iconAction1: Drawable? = null
    private var iconAction2: Drawable? = null
    private var iconAction3: Drawable? = null
    var listener: OnToolbarActionListener? = null


    constructor(context: Context) : super(context) {
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        this.binding = LayoutToolbarMaterialBinding.inflate(inflater, this, true)
        initToolbar(context, attrs)
    }

    @SuppressLint("CustomViewStyleable")
    private fun initToolbar(context: Context, attrs: AttributeSet?) {
        setBackgroundColor(ContextCompat.getColor(context, R.color.white_5))
        if (attrs != null) {
            val attributeArray = context.obtainStyledAttributes(attrs, R.styleable.WellToolbar)
//            this.toolbarStyle =
//                attributeArray.getInt(R.styleable.WellToolbar_toolbarViewStyle, STYLE_BACK_TITLE)
            val title = attributeArray.getString(R.styleable.WellToolbar_toolbarTitle)
//            this.textCta = attributeArray.getString(R.styleable.WellToolbar_toolbarTextCta)
            iconAction1 = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarAction1)
            iconAction2 = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarAction2)
            iconAction3 = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarAction3)
//            this.logo = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarLogo)
//            this.hideDidiver =
//                attributeArray.getBoolean(R.styleable.WellToolbar_toolbarHideDivider, false)
//            this.disableCta =
//                attributeArray.getBoolean(R.styleable.WellToolbar_toolbarDisableCta, false)
//            this.backIcon = attributeArray.getDrawable(R.styleable.WellToolbar_toolbarBackIcon)
//            if (toolbarStyle == STYLE_TITLE || toolbarStyle == STYLE_TITLE_2ICON) {
//                this.toolbarView.setTitleTextAppearance(context, R.style.ToolbarTitle_Large)
//            } else {
//                this.toolbarView.setTitleTextAppearance(context, R.style.ToolbarTitle_Normal)
//            }
//            if (toolbarStyle != STYLE_LOGO && toolbarStyle != STYLE_BACK_TITLE_SELECT) {
//                this.setTitle(title)
//            } else if (toolbarStyle == STYLE_BACK_TITLE_SELECT) {
//                this.toolbarView.setTitle("")
//                this.tvTitleSelect.setVisibility(VISIBLE)
//                this.tvTitleSelect.setText(title)
//            } else {
//                this.toolbarView.setLogo(logo)
//            }
//            this.dividerView.setVisibility(if (this.hideDidiver) GONE else VISIBLE)
            attributeArray.recycle()
        }
    }

    fun onCreateOptionsMenu(context: AppCompatActivity, menu: Menu): Boolean {
        val supportActionBar = context.supportActionBar
        context.menuInflater.inflate(R.menu.menu_toolbar, menu)
        itemAction1 = menu.findItem(R.id.action_1)
        itemAction2 = menu.findItem(R.id.action_2)
        itemAction3 = menu.findItem(R.id.action_3)

        if (iconAction1 != null) {
            itemAction1.icon = iconAction1
        } else {
            itemAction1.isVisible = false
        }

        if (iconAction2 != null) {
            itemAction2.icon = iconAction2
        } else {
            itemAction2.isVisible = false
        }

        if (iconAction3 != null) {
            itemAction3.icon = iconAction3
        } else {
            itemAction3.isVisible = false
        }

//        if (this.toolbarStyle == STYLE_BACK_TITLE_2ICON || this.toolbarStyle == STYLE_TITLE_2ICON || this.toolbarStyle == STYLE_LOGO) {
//            if (this.iconAction1 != null) {
//                itemAction1.setIcon(this.iconAction1)
//            } else {
//                itemAction1.setVisible(false)
//            }
//            if (this.iconAction2 != null) {
//                itemAction2.setIcon(this.iconAction2)
//            } else {
//                itemAction2.setVisible(false)
//            }
//        } else if (this.toolbarStyle == STYLE_BACK_TITLE_ICON && this.iconAction2 != null) {
//            itemAction1.setVisible(false)
//            itemAction2.setIcon(this.iconAction2)
//        } else if ((this.toolbarStyle == STYLE_BACK_TITLE_BUTTON || this.toolbarStyle == STYLE_BACK_TITLE_SELECT) && !TextUtils.isEmpty(
//                textCta
//            )
//        ) {
//            itemAction1.setVisible(false)
//            itemAction2.setTitle(textCta)
//            if (disableCta) {
//                updateTitleCta(false)
//            }
//        } else {
//            itemAction1.setVisible(false)
//            itemAction2.setVisible(false)
//        }
        return true
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (listener == null) return false
        val itemId = item.itemId
        if (itemId == R.id.action_1) {
            listener!!.onToolbarAction1Click()
            return true
        } else if (itemId == R.id.action_2) {
            listener!!.onToolbarAction2Click()
            return true
        } else if (itemId == R.id.action_3) {
            listener!!.onToolbarAction3Click()
            return true
        }
        return false
    }

    fun getToolbar(): Toolbar {
        return binding.topAppBar
    }
}