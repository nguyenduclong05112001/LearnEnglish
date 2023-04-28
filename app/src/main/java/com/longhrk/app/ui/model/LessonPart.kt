package com.longhrk.app.ui.model

data class LessonPart(
    val id: Int,
    val image: Int,
    val lessons: List<Lesson>,
    val status: Boolean
)