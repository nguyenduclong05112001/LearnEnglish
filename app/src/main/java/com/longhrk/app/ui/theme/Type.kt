package com.longhrk.app.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import javax.annotation.meta.When

val fontApp = FontFamily.Default
private val fontFamily = FontFamily.Default

val FontStyle8 = TextStyle(
    fontSize = 8.sp,
    fontFamily = fontFamily,
)

val FontStyle12 = TextStyle(
    fontSize = 12.sp,
    fontFamily = fontFamily,
)

val FontStyle16 = TextStyle(
    fontSize = 16.sp,
    fontFamily = fontFamily,
)

val FontStyle24 = TextStyle(
    fontSize = 24.sp,
    fontFamily = fontFamily,
)

val FontStyle32 = TextStyle(
    fontSize = 32.sp,
    fontFamily = fontFamily,
)

val FontStyle48 = TextStyle(
    fontSize = 48.sp,
    fontFamily = fontFamily,
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)