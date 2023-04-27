package com.longhrk.app.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.longhrk.app.R
import com.longhrk.app.ui.components.HeaderApp
import com.longhrk.app.ui.extensions.gridItems
import com.longhrk.app.ui.model.Lesson
import com.longhrk.app.ui.model.LessonUnit
import com.longhrk.app.ui.theme.FontStyle12
import com.longhrk.app.ui.theme.FontStyle16
import com.longhrk.app.ui.theme.background
import com.longhrk.app.ui.theme.element

@Composable
fun HomeScreen() {
    val context = LocalContext.current

    val localDensity = LocalDensity.current

    var widthScreen by remember {
        mutableStateOf(0.dp)
    }

    val sizeItem = (widthScreen / 3)

    val listUnit = ArrayList<LessonUnit>().apply {
        add(
            LessonUnit(
                id = 1,
                title = "I feel good",
                lessons = ArrayList<Lesson>().apply {
                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )
                }
            )
        )

        add(
            LessonUnit(
                id = 1,
                title = "I feel good",
                lessons = ArrayList<Lesson>().apply {
                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )
                }
            )
        )

        add(
            LessonUnit(
                id = 1,
                title = "I feel good",
                lessons = ArrayList<Lesson>().apply {
                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )

                    Lesson(
                        id = 11,
                        image = R.drawable.logo_app,
                        status = true
                    )
                }
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                widthScreen = with(localDensity) { it.size.width.toDp() }
            }
            .background(color = background)
    ) {
        HeaderApp(
            modifier = Modifier
                .fillMaxWidth()
                .background(element.copy(0.1f))
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            listUnit.forEach {
                gridItems(
                    count = it.lessons.size,
                    nColumns = 2,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ItemLesson(
                        modifier = Modifier.size(sizeItem),
                    )
                }
            }
        }
    }
}


@Composable
fun UnitTitle(
    modifier: Modifier,
    title: String,
    unitCurrent: Int
) {
    Column(
        modifier = modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Unit$unitCurrent",
            color = element,
            maxLines = 1,
            fontWeight = FontWeight.Bold,
            style = FontStyle16
        )
        Text(
            text = title,
            color = element,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Normal,
            style = FontStyle12
        )
    }
}

@Composable
fun ItemLesson(
    modifier: Modifier,
//    lesson: Lesson,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {

    }
}