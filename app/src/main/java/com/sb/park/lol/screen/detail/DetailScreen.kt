package com.sb.park.lol.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.onError
import com.sb.park.designsystem.onSuccess
import com.sb.park.designsystem.theme.LoLTheme
import com.sb.park.designsystem.widget.MarginSpacer
import com.sb.park.lol.R
import com.sb.park.lol.utils.skinImage
import com.sb.park.lol.utils.spellImage
import com.sb.park.lol.utils.splashImage
import com.sb.park.lol.viewmodels.DetailViewModel
import com.sb.park.model.ChampionInfoModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun DetailScreen(
    showSnackBar: (Throwable?) -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val championUiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    when (championUiState) {
        is UiState.Loading -> DetailShimmer()
        is UiState.Success -> ChampionInfo(championUiState.onSuccess())
        is UiState.Error -> showSnackBar(championUiState.onError())
    }
}

@Composable
fun ChampionInfo(championInfoModel: ChampionInfoModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        ChampionImage(
            championId = championInfoModel.id,
            championName = championInfoModel.name
        )
        Title(
            championName = championInfoModel.name,
            tags = championInfoModel.tags.toImmutableList()
        )
        Lore(lore = championInfoModel.lore)
        MarginSpacer(marginValue = 10.dp)
        Spells(
            championId = championInfoModel.id,
            version = championInfoModel.version,
            spells = championInfoModel.spells.toImmutableList()
        )
        MarginSpacer(marginValue = 10.dp)
        Skins(
            championId = championInfoModel.id,
            skins = championInfoModel.skins.toImmutableList()
        )
    }
}

@Composable
fun ChampionImage(
    championId: String,
    championName: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier.fillMaxWidth(),
        model = splashImage(championId),
        contentDescription = championName,
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_launcher_foreground)
    )
}

@Composable
fun Title(
    championName: String,
    tags: ImmutableList<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = championName,
            style = LoLTheme.typography.titleLargeSB
        )
        tags.forEach { tag ->
            Box(
                modifier = modifier
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                    .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
            ) {
                Text(
                    text = tag,
                    style = LoLTheme.typography.titleSmallSB
                )
            }
        }
    }
}

@Composable
fun Lore(
    lore: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = lore,
            style = LoLTheme.typography.contentMedium
        )
    }
}

@Composable
fun Spells(
    championId: String,
    version: String,
    spells: ImmutableList<ChampionInfoModel.SpellModel>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 20.dp, end = 20.dp)
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        spells.forEachIndexed { index, spell ->
            SpellItem(
                version = version,
                championId = championId,
                index = index,
                spell = spell
            )
        }
    }
}

@Composable
fun SpellItem(
    version: String,
    championId: String,
    index: Int,
    spell: ChampionInfoModel.SpellModel,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AsyncImage(
            modifier = modifier.size(60.dp),
            model = spellImage(version, "${championId}${SpellEnum.getSpell(index)}"),
            contentDescription = spell.name,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = spell.name,
                    style = LoLTheme.typography.titleSmallSB,
                    color = MaterialTheme.colorScheme.surfaceTint
                )
                Box(
                    modifier = modifier
                        .background(
                            shape = RoundedCornerShape(5.dp),
                            color = MaterialTheme.colorScheme.surfaceDim
                        )
                        .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),
                ) {
                    Text(
                        text = SpellEnum.entries[index].name,
                        style = LoLTheme.typography.contentSmallSB
                    )
                }
            }
            Text(
                text = spell.description,
                style = LoLTheme.typography.contentSmall
            )
        }
    }
}

@Composable
fun Skins(
    championId: String,
    skins: ImmutableList<ChampionInfoModel.SkinModel>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier.padding(start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        items(
            items = skins,
            key = { skin -> skin.name }
        ) { skin ->
            SkinItem(
                championId = championId,
                skin = skin
            )
        }
    }
}

@Composable
fun SkinItem(
    championId: String,
    skin: ChampionInfoModel.SkinModel
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = skinImage(championId, skin.num),
            contentDescription = skin.name,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            error = painterResource(id = R.drawable.ic_launcher_foreground)
        )
        Text(
            text = skin.name,
            style = LoLTheme.typography.titleSmallSB
        )
    }
}