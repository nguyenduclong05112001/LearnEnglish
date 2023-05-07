package com.longhrk.app.ui.screen

import android.widget.ImageView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.longhrk.app.R
import com.longhrk.app.ui.Utils
import com.longhrk.app.ui.components.HeaderApp
import com.longhrk.app.ui.extensions.drawCircularIndicator
import com.longhrk.app.ui.extensions.drawDeterminateCircularIndicator
import com.longhrk.app.ui.fakeDatas.FakeListData
import com.longhrk.app.ui.model.DBUnit
import com.longhrk.app.ui.model.LessonPart
import com.longhrk.app.ui.model.StatusPart
import com.longhrk.app.ui.theme.background
import com.longhrk.app.ui.theme.element
import com.longhrk.app.ui.theme.fontApp

@Composable
fun HomeScreen() {
    val context = LocalContext.current

    val localDensity = LocalDensity.current

    var widthScreen by remember {
        mutableStateOf(0.dp)
    }

    val listUnit = FakeListData.datas

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
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Utils.dimensOf(values = R.dimen._15dp)),
        ) {
            listUnit.forEachIndexed { index, element ->
                item {
                    UnitTitle(
                        modifier = Modifier.fillMaxWidth(),
                        currentUnit = element
                    )

                    var paddingValue = (widthScreen / 5) * .9f

                    element.lessonParts.forEachIndexed { subIndex, subElement ->
                        Spacer(modifier = Modifier.size(Utils.dimensOf(values = R.dimen._10dp)))

                        Row {
                            if (index % 2 == 0 && subIndex > 0) {
                                Spacer(modifier = Modifier.padding(end = paddingValue))
                                paddingValue += ((widthScreen / 5) * .9f)
                            }

                            ItemLesson(
                                modifier = Modifier.size((widthScreen / 5)),
                                subElement
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun UnitTitle(
    modifier: Modifier,
    currentUnit: DBUnit
) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(10))
            .fillMaxWidth()
            .background(color = Color.Red),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier
                .weight(1f)
                .padding(all = Utils.dimensOf(values = R.dimen._10dp))
        ) {
            Text(
                text = currentUnit.title,
                fontSize = Utils.dimensOfText(values = R.dimen._16sp),
                fontWeight = FontWeight.Bold,
                fontFamily = fontApp
            )

            Text(
                text = currentUnit.contentUnit,
                fontSize = Utils.dimensOfText(values = R.dimen._10sp),
                fontWeight = FontWeight.Normal,
                fontFamily = fontApp,
                overflow = TextOverflow.Ellipsis
            )
        }

        Icon(
            modifier = Modifier.padding(all = Utils.dimensOf(values = R.dimen._10dp)),
            painter = painterResource(id = R.drawable.ic_more_vert),
            contentDescription = null
        )
    }
}

@Composable
fun ItemLesson(
    modifier: Modifier,
    currentPart: LessonPart,
) {
    val localDensity = LocalDensity.current

    var widthComponent by remember {
        mutableStateOf(0.dp)
    }

    var progress: Float by remember {
        mutableStateOf(currentPart.process)
    }

    val trackWidth = (widthComponent * .075f)

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
        if (currentPart.status == StatusPart.LEARNING) {
            ProgressIndicator(
                modifier = Modifier.fillMaxSize(),
                progress = progress,
                strokeWidth = trackWidth,
                gradientStart = Color.Yellow,
                gradientEnd = Color.Yellow,
                trackColor = Color.Gray,
            )
        }

        Box(
            modifier = Modifier
                .size((widthComponent * .7f))
                .clip(shape = RoundedCornerShape(50))
                .background(element)
                .align(Alignment.Center),
        ) {
            AndroidView(
                modifier = Modifier
                    .padding(widthComponent * .2f)
                    .fillMaxSize(),
                factory = { context ->
                    ImageView(context).apply {
                        Glide.with(context)
                            .load(currentPart.imageIcon)
                            .into(this)
                    }
                }
            )
        }
    }
}

@Composable
fun ProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Float,
    gradientStart: Color,
    gradientEnd: Color,
    trackColor: Color,
    strokeWidth: Dp
) {
    val stroke = with(LocalDensity.current) {
        Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Butt)
    }
    Canvas(
        modifier.progressSemantics(progress)
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