package com.longhrk.app.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.longhrk.app.ui.components.HeaderApp
import com.longhrk.app.ui.extensions.drawCircularIndicator
import com.longhrk.app.ui.extensions.drawDeterminateCircularIndicator
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

        ItemLesson(modifier = Modifier.size((widthScreen / 3)))
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
    val localDensity = LocalDensity.current

    var widthComponent by remember {
        mutableStateOf(0.dp)
    }

    var progress: Float by remember { mutableStateOf(0f) }

    val trackWidth = (widthComponent * .05f)

    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(50))
            .onGloballyPositioned {
                widthComponent = with(localDensity) { it.size.width.toDp() }
            }
            .clickable {
                if (progress >= 1f) {
                    progress = 0f
                } else {
                    progress += 0.1f
                }
            }
    ) {
        GradientProgressIndicator(
            modifier = Modifier.fillMaxSize(),
            progress = progress,
            strokeWidth = trackWidth,
            gradientStart = Color.Yellow,
            gradientEnd = Color.Yellow,
            trackColor = Color.Gray,
        )

        Box(
            modifier = Modifier
                .size((widthComponent * .8f))
                .clip(shape = RoundedCornerShape(50))
                .background(element)
                .align(Alignment.Center)
        ) {

        }
    }
}

@Composable
fun GradientProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    gradientStart: Color,
    gradientEnd: Color,
    trackColor: Color,
    strokeWidth: Dp
) {
    val stroke = with(LocalDensity.current) {
        Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Butt)
    }
    Canvas(
        modifier
            .progressSemantics(progress)
    ) {
        val startAngle = 270f
        val sweep = progress * 360f
        drawDeterminateCircularIndicator(startAngle, 360f, trackColor, stroke)
        drawCircularIndicator(
            startAngle = startAngle,
            sweep = sweep,
            gradientStart = gradientStart,
            gradientEnd = gradientEnd,
            stroke = stroke
        )
    }
}