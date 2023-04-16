package com.dropbox.forester.android.feat.pokedex_tab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dropbox.forester.android.dig.Dig

@Composable
internal fun Tile(
    modifier: Modifier = Modifier,
    title: String,
    brush: Brush,
    painter: Painter,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .background(brush)
            .padding(16.dp)

    ) {
        Text(
            text = title,
            color = Dig.Colors.standard.text,
            style = Dig.Typography.h5,
            fontWeight = FontWeight.Black
        )

        Spacer(Modifier.weight(1f))

        Box(
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .scale(1f, .5f)
                    .offset(y = 100.dp)
                    .size(100.dp)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                Black.copy(alpha = .3f),
                                Color.Transparent
                            ),
                            radius = 80f
                        )
                    )
            )

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .offset(y = (-8).dp)
                    .size(100.dp)
            )
        }
    }
}