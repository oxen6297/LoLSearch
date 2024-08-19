package com.sb.park.lol.screen.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.onError
import com.sb.park.designsystem.onSuccess
import com.sb.park.designsystem.theme.LoLTheme
import com.sb.park.lol.R
import com.sb.park.lol.navigation.navigateToItemInfoScreen
import com.sb.park.lol.screen.shimmer.ItemShimmer
import com.sb.park.lol.utils.clickableSingle
import com.sb.park.lol.utils.itemImage
import com.sb.park.lol.viewmodels.DictionaryViewModel
import com.sb.park.model.ItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun ItemScreen(
    showErrorSnackBar: (Throwable?) -> Unit,
    navController: NavController,
    viewModel: DictionaryViewModel = hiltViewModel()
) {
    val uiStateFlow by viewModel.itemUiStateFlow.collectAsStateWithLifecycle()
    val version by viewModel.versionFlow.collectAsStateWithLifecycle()

    when (uiStateFlow) {
        is UiState.Loading -> ItemShimmer()
        is UiState.Success -> {
            ItemsContent(
                version = version,
                itemList = uiStateFlow.onSuccess().toImmutableList(),
                navController = navController
            )
        }

        is UiState.Error -> showErrorSnackBar(uiStateFlow.onError())
    }
}

@Composable
private fun ItemsContent(
    version: String,
    itemList: ImmutableList<ItemModel>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
        columns = GridCells.Fixed(4),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(
            items = itemList,
            key = { itemModel -> itemModel.name }
        ) { itemModel ->
            ItemsItem(
                version = version,
                itemModel = itemModel,
                navController = navController,
            )
        }
    }
}

@Composable
private fun ItemsItem(
    version: String,
    itemModel: ItemModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickableSingle { navController.navigateToItemInfoScreen(itemModel.name) },
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = modifier.size(65.dp),
            model = itemImage(version, itemModel.image.fileName),
            contentDescription = itemModel.name,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        Text(
            text = itemModel.name,
            style = LoLTheme.typography.contentSmall
        )
    }
}