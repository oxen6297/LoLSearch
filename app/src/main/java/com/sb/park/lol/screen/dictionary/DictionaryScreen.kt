package com.sb.park.lol.screen.dictionary

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DictionaryScreen(
    showSnackBar: (Throwable?) -> Unit,
    navController: NavController
) {
    //TODO tab / horizontal pager with ItemScreen
    ChampionScreen(
        showSnackBar = showSnackBar,
        navController = navController
    )
}