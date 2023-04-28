package com.longhrk.app.ui.model

data class LessonUnit(
    val id: Int,
    val unitNumber: Int = 1,
    val title: String,
    val lessonParts: List<LessonPart>
)