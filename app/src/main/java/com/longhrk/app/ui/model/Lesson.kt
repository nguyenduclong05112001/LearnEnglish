package com.longhrk.app.ui.model

data class Lesson(
    val id: Int,
    val type: TypeLesson,
    val isCompleted: Boolean,
)

enum class TypeLesson {
    READING,
    WRITING,
    SPEAKING,
    LISTENING
}