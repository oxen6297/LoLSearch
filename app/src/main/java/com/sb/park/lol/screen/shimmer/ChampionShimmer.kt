package com.sb.park.lol.screen.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sb.park.designsystem.theme.LoLSearchTheme
import com.sb.park.designsystem.widget.ShimmerSpacer

@Composable
internal fun ChampionShimmer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) {
            ChampionItemShimmer(modifier = modifier.weight(1f))
        }
    }
}

@Composable
private fun ChampionItemShimmer(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.background(color = MaterialTheme.colorScheme.surface),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(4) {
            ShimmerSpacer(
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
            )

            Spacer(modifier = modifier.height(10.dp))

            ShimmerSpacer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ShimmerPreview() {
    LoLSearchTheme {
        ChampionShimmer()
    }
}