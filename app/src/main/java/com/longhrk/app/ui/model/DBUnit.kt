package com.longhrk.app.ui.model

import android.graphics.Color

data class DBUnit(
    val id: Int,
    val title: String,
    val contentUnit: String,
    var learning: Boolean,
    var colorUnit: Int,
    val lessonParts: List<LessonPart>,
    var remaining: Int = lessonParts.size
)