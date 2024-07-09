package com.sb.park.designsystem.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerSpacer(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(5.dp),
) {
    Spacer(
        modifier = modifier
            .shimmer()
            .background(
                color = Color.LightGray,
                shape = shape
            )
    )
}