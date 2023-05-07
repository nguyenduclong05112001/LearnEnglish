package com.longhrk.app.ui.components

import android.widget.ImageView
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.longhrk.app.R
import com.longhrk.app.ui.extensions.IconExtension
import com.longhrk.app.ui.theme.FontStyle12
import com.longhrk.app.ui.theme.FontStyle16
import com.longhrk.app.ui.theme.element

@Composable
fun HeaderApp(
    modifier: Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AndroidView(modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 10.dp),
                factory = { context ->
                    ImageView(context).apply {
                        Glide.with(context).load(R.drawable.logo_app).into(this)
                    }
                })
            Column(
                modifier = Modifier.padding(0.dp), horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(id = R.string.connect4),
                    textAlign = TextAlign.Start,
                    style = FontStyle12
                )

                Text(
                    text = stringResource(id = R.string.app_name),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    style = FontStyle16
                )
            }
        }

        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ItemAchieve(
                modifier = Modifier.weight(1f),
                icon = IconExtension.Diamond,
                color = Color.Blue,
                number = "10"
            )

            ItemAchieve(
                modifier = Modifier.weight(1f),
                icon = Icons.Filled.Star,
                color = Color.Yellow,
                number = "10"
            )
        }

        Icon(
            modifier = Modifier.padding(horizontal = 10.dp),
            painter = painterResource(id = R.drawable.ic_more_vert),
            tint = element,
            contentDescription = null
        )
    }
}


@Composable
fun ItemAchieve(
    modifier: Modifier, icon: ImageVector, number: String, color: Color
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.padding(end = 5.dp),
            imageVector = icon,
            contentDescription = null,
            tint = color
        )

        Text(text = number, style = FontStyle12, color = color)
    }
}