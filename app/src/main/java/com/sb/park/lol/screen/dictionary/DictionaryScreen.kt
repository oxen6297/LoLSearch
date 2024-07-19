package com.sb.park.lol.screen.dictionary

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sb.park.designsystem.theme.LoLTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun DictionaryScreen(
    showSnackBar: (Throwable?) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        pageCount = { DictionaryTabs.entries.size },
        initialPage = DictionaryTabs.Champion.ordinal,
    )

    Column(modifier = modifier.fillMaxSize()) {
        DictionaryTabRow(pagerState = pagerState)
        HorizontalPager(state = pagerState) { page ->
            when (page) {
                DictionaryTabs.Champion.ordinal -> {
                    ChampionScreen(
                        showSnackBar = showSnackBar,
                        navController = navController
                    )
                }

                DictionaryTabs.Item.ordinal -> {

                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DictionaryTabRow(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage) {
        DictionaryTabs.entries.forEachIndexed { index, tab ->
            Tab(
                modifier = modifier
                    .background(color = MaterialTheme.colorScheme.primary)
                    .wrapContentHeight(),
                selected = pagerState.currentPage == index,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                text = {
                    Text(
                        text = tab.tabName,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = LoLTheme.typography.contentSmall
                    )
                }
            )
        }
    }
}