package com.sb.park.lol.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sb.park.designsystem.ApiResult
import com.sb.park.designsystem.onError
import com.sb.park.designsystem.onSuccess
import com.sb.park.lol.R
import com.sb.park.lol.utils.mainImage
import com.sb.park.lol.viewmodels.DictionaryViewModel
import com.sb.park.model.ChampionModel
import com.valentinilk.shimmer.shimmer

@Composable
fun DictionaryScreen(
    showSnackBar: (Throwable?) -> Unit,
    navController: NavController,
    viewModel: DictionaryViewModel = hiltViewModel()
) {
    val championUiState by viewModel.championFlow.collectAsStateWithLifecycle()

    when (championUiState) {
        is ApiResult.Loading -> ChampionShimmer()
        is ApiResult.Success -> ChampionList(
            championList = championUiState.onSuccess() ?: emptyList(),
            navController = navController
        )

        is ApiResult.Error -> showSnackBar(championUiState.onError())
    }
}

@Composable
fun ChampionList(
    championList: List<ChampionModel>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier.padding(20.dp),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(championList) { championModel ->
            ChampionItem(
                championModel = championModel,
                navController = navController,
            )
        }
    }
}

@Composable
fun ChampionItem(
    championModel: ChampionModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable { navController.navigate("detail/${championModel.id}") },
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = mainImage(championModel.id),
            contentDescription = championModel.name,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        Text(text = championModel.name)
    }
}

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
            ItemShimmer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun ItemShimmer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(3) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.7f)
                    .shimmer()
                    .background(
                        color = LightGray,
                        shape = RoundedCornerShape(4.dp),
                    )
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .shimmer()
                    .background(
                        color = LightGray,
                        shape = RoundedCornerShape(4.dp),
                    )
            )

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun ShimmerPreview() {
    ChampionShimmer()
}