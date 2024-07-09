package com.sb.park.lol.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.onError
import com.sb.park.designsystem.onSuccess
import com.sb.park.designsystem.theme.LoLSearchTheme
import com.sb.park.designsystem.widget.ShimmerSpacer
import com.sb.park.lol.R
import com.sb.park.lol.utils.mainImage
import com.sb.park.lol.viewmodels.DetailViewModel
import com.sb.park.model.ChampionInfoModel

@Composable
fun DetailScreen(
    showSnackBar: (Throwable?) -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val championUiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    when (championUiState) {
        is UiState.Loading -> DetailShimmer()
        is UiState.Success -> ChampionInfo(championInfoModel = championUiState.onSuccess())
        is UiState.Error -> showSnackBar(championUiState.onError())
    }
}

@Composable
fun ChampionInfo(championInfoModel: ChampionInfoModel, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = mainImage(championInfoModel.id),
            contentDescription = championInfoModel.name,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        Text(text = championInfoModel.name)

        //TODO detail component
    }
}

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
    }
}

@Composable
fun ImageShimmer() {
    ShimmerSpacer(modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1.6f))
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
        ShimmerSpacer(modifier = Modifier
            .width(80.dp)
            .height(30.dp))
        ShimmerSpacer(modifier = Modifier
            .width(70.dp)
            .height(25.dp))
        ShimmerSpacer(modifier = Modifier
            .width(70.dp)
            .height(25.dp))
    }
}

@Composable
fun DescriptionShimmer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ShimmerSpacer(modifier = Modifier
            .width(180.dp)
            .height(30.dp))
        repeat(3) {
            ShimmerSpacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
        }
    }
}

@Preview
@Composable
fun DetailShimmerPreview() {
    LoLSearchTheme {
        DetailShimmer()
    }
}