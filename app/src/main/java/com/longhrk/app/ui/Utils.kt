package com.longhrk.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

object Utils {

    @Composable
    fun dimensOf(values: Int): Dp {
        return dimensionResource(id = values)
    }

    @Composable
    fun dimensOfText(values: Int): TextUnit {
        val localDensity = LocalDensity.current
        return with(localDensity){ dimensionResource(id = values).toSp() }
    }
}