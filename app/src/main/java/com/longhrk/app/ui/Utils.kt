package com.longhrk.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp

object Utils {

    @Composable
    fun dimensOf(values: Int): Dp {
        return dimensionResource(id = values)
    }
}