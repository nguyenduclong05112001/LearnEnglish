package com.longhrk.app.ui.screen

import android.content.Context
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.longhrk.app.R
import com.longhrk.app.ui.components.HeaderApp
import com.longhrk.app.ui.fakeDatas.FakeListData.fakeDataList
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

    val listUnit = fakeDataList

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

        ItemLesson(
            modifier = Modifier.size(getPxToDp(R.dimen.px10, context)),
        )

//        LazyColumn(
//            modifier = Modifier.weight(1f),
//        ) {
//            listUnit.forEach {
//                gridItems(
//                    count = it.lessonParts.size,
//                    nColumns = 3,
//                    horizontalArrangement = Arrangement.SpaceAround
//                ) {
//                    ItemLesson(
//                        modifier = Modifier.size(context.resources.getDimension(R.dimen.px10).dp),
//                    )
//                }
//            }
//        }
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

@Preview(showBackground = true)
@Composable
fun PreviewComposeItem() {
    ItemLesson(modifier = Modifier.size(100.dp))
}

@Composable
fun ItemLesson(
    modifier: Modifier,
//    lesson: Lesson,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(50))
            .background(Color.Red)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
//            drawCircle(
//
//            )
        }
    }
}

fun getPxToDp(id: Int, context: Context): Dp {
    return context.resources.getDimension(id).dp
}