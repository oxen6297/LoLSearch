package com.sb.park.lol.screen.dictionary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sb.park.designsystem.theme.LoLSearchTheme
import com.sb.park.designsystem.widget.ShimmerSpacer

@Composable
fun ChampionShimmer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) {
            ItemShimmer(modifier = modifier.weight(1f))
        }
    }
}

@Composable
fun ItemShimmer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(color = MaterialTheme.colorScheme.surface),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(3) {
            ShimmerSpacer(
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
            )
            ShimmerSpacer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )
            ShimmerSpacer(modifier = modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun ShimmerPreview() {
    LoLSearchTheme {
        ChampionShimmer()
    }
}