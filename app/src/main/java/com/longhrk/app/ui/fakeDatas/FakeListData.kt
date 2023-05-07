package com.longhrk.app.ui.fakeDatas

import android.graphics.Color
import com.longhrk.app.R
import com.longhrk.app.ui.model.*

class FakeListData {
    companion object {
        val datas = ArrayList<DBUnit>().apply {
            add(
                DBUnit(
                    id = 0,
                    title = "Unit 1",
                    contentUnit = "Conversation",
                    learning = true,
                    colorUnit = Color.RED,
                    lessonParts = getParts()
                )
            )
        }

        private fun getParts(): List<LessonPart> {
            val lessonParts = mutableListOf<LessonPart>()

            for (i in 0..10) {
                lessonParts.add(
                    LessonPart(
                        id = i,
                        contentPart = "content $i",
                        imageIcon = R.drawable.logo_app,
                        status = StatusPart.LEARNING,
                        lessons = getLessons()
                    )
                )
            }

            return lessonParts
        }

        private fun getLessons(): List<Lesson> {
            val lessons = mutableListOf<Lesson>()

            for (i in 0..10) {
                lessons.add(
                    Lesson(
                        id = i,
                        type = TypeLesson.READING,
                        isCompleted = true
                    )
                )
            }

            return lessons
        }

    }
}