package com.sb.park.lol.screen.dictionary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sb.park.designsystem.theme.LoLSearchTheme
import com.sb.park.designsystem.widget.ShimmerSpacer

@Composable
internal fun ItemShimmer(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(30) {
            ShimmerSpacer(
                modifier = modifier
                    .aspectRatio(1f)
                    .background(color = MaterialTheme.colorScheme.surface)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ShimmerPreview() {
    LoLSearchTheme {
        ItemShimmer()
    }
}