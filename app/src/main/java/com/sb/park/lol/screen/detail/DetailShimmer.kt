package com.sb.park.lol.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sb.park.designsystem.theme.LoLSearchTheme
import com.sb.park.designsystem.widget.ShimmerSpacer

@Composable
fun DetailShimmer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        ImageShimmer()
        TitleShimmer()
        DescriptionShimmer()
        SkillShimmer()
    }
}

@Composable
fun ImageShimmer(modifier: Modifier = Modifier) {
    ShimmerSpacer(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.6f),
        shape = RectangleShape
    )
}

@Composable
fun TitleShimmer(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .wrapContentSize()
            .padding(start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShimmerSpacer(
            modifier = modifier
                .width(80.dp)
                .height(30.dp)
        )
        ShimmerSpacer(
            modifier = modifier
                .width(70.dp)
                .height(25.dp)
        )
        ShimmerSpacer(
            modifier = modifier
                .width(70.dp)
                .height(25.dp)
        )
    }
}

@Composable
fun DescriptionShimmer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ShimmerSpacer(
            modifier = modifier
                .width(180.dp)
                .height(30.dp)
        )
        repeat(3) {
            ShimmerSpacer(
                modifier = modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
        }
    }
}

@Composable
fun SkillShimmer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.padding(20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        ShimmerSpacer(
            modifier = modifier.fillMaxSize(),
            shape = RectangleShape
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailShimmerPreview() {
    LoLSearchTheme {
        DetailShimmer()
    }
}