package com.sb.park.lol.screen.dictionary

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.onError
import com.sb.park.designsystem.onSuccess
import com.sb.park.designsystem.theme.LoLTheme
import com.sb.park.designsystem.widget.TopBar
import com.sb.park.lol.R
import com.sb.park.lol.navigation.navigateToDetailScreen
import com.sb.park.lol.utils.skinImage
import com.sb.park.lol.utils.toImmutableList
import com.sb.park.lol.viewmodels.DictionaryViewModel
import com.sb.park.model.ChampionModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun DictionaryScreen(
    showSnackBar: (Throwable?) -> Unit,
    navController: NavController,
    viewModel: DictionaryViewModel = hiltViewModel()
) {
    val championUiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    when (championUiState) {
        is UiState.Loading -> ChampionShimmer()
        is UiState.Success -> {
            ChampionList(
                championList = championUiState.onSuccess().toImmutableList(),
                navController = navController
            )
        }

        is UiState.Error -> showSnackBar(championUiState.onError())
    }
}

@Composable
fun ChampionList(
    championList: ImmutableList<ChampionModel>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column {
        TopBar(
            title = stringResource(id = R.string.champion_list),
            style = LoLTheme.typography.titleLargeSB
        )
        LazyVerticalGrid(
            modifier = modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(
                items = championList,
                key = { championModel -> championModel.id }
            ) { championModel ->
                ChampionItem(
                    championModel = championModel,
                    navController = navController,
                )
            }
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
        modifier = modifier.clickable { navController.navigateToDetailScreen(championModel.id) },
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = skinImage(championModel.id, 0),
            contentDescription = championModel.name,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        Text(
            text = championModel.name,
            style = LoLTheme.typography.contentMediumSB
        )
    }
}