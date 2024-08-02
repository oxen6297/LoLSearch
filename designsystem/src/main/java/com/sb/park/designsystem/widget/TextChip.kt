package com.sb.park.designsystem.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sb.park.designsystem.theme.LoLTheme

@Composable
fun TextChip(
    text: String,
    modifier: Modifier = Modifier,
    chipColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    textStyle: TextStyle = LoLTheme.typography.titleSmallSB
) {
    Box(
        modifier = modifier
            .background(
                shape = RoundedCornerShape(10.dp),
                color = chipColor
            )
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}