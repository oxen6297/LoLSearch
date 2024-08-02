package com.sb.park.lol.screen.dictionary.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.onError
import com.sb.park.designsystem.onSuccess
import com.sb.park.designsystem.theme.LoLTheme
import com.sb.park.designsystem.widget.TextChip
import com.sb.park.lol.R
import com.sb.park.lol.utils.itemImage
import com.sb.park.lol.viewmodels.ItemInfoViewModel
import com.sb.park.model.ItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun ItemInfoScreen(
    showSnackBar: (Throwable?) -> Unit,
    viewModel: ItemInfoViewModel = hiltViewModel()
) {
    val uiStateFlow by viewModel.uiStateFlow.collectAsStateWithLifecycle()
    val version by viewModel.versionFlow.collectAsStateWithLifecycle()

    when (uiStateFlow) {
        is UiState.Loading -> ItemInfoShimmer()
        is UiState.Success -> ItemInfoContent(
            version = version,
            itemModel = uiStateFlow.onSuccess()
        )

        is UiState.Error -> showSnackBar(uiStateFlow.onError())
    }
}

@Composable
private fun ItemInfoContent(
    version: String,
    itemModel: ItemModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        ItemImage(
            version = version,
            fileName = itemModel.image.fileName
        )
        TitleRow(
            itemName = itemModel.name,
            gold = itemModel.gold.total,
            tags = itemModel.tags.toImmutableList()
        )
        DescriptionBox(description = itemModel.plaintext)
    }
}

@Composable
private fun ItemImage(
    version: String,
    fileName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.DarkGray
                    )
                )
            )
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = modifier.size(80.dp),
            model = itemImage(version, fileName),
            contentDescription = fileName,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TitleRow(
    itemName: String,
    gold: String,
    tags: ImmutableList<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(start = 20.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = itemName,
            style = LoLTheme.typography.titleSmallSB
        )
        Text(
            text = gold,
            style = LoLTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.surfaceTint
        )
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            tags.forEach { tag ->
                TextChip(text = tag)
            }
        }
    }
}

@Composable
private fun DescriptionBox(
    description: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = description,
            style = LoLTheme.typography.contentMedium
        )
    }
}