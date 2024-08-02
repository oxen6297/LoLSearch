package com.sb.park.designsystem.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomGaugeBar(
    progress: Float,
    progressColor: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(25.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(13.dp)
            )
    ) {
        Box(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(fraction = progress)
                .background(
                    color = progressColor,
                    shape = RoundedCornerShape(13.dp)
                )
        )
    }
}