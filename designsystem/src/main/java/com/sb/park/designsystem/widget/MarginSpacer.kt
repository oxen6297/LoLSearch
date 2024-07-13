package com.sb.park.designsystem.widget

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun MarginSpacer(marginValue: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.size(marginValue))
}