package com.longhrk.app.ui.model

data class LessonPart(
    val id: Int,
    val contentPart: String,
    val imageIcon: Int,
    var status: StatusPart,
    val lessons: List<Lesson>,
    var remaining: Int = lessons.size,
    val process: Float = if (lessons.size == remaining) 0f else (lessons.size / remaining / 10).toFloat()
)

enum class StatusPart {
    LEARNING, LEARNED, DISABLE
}