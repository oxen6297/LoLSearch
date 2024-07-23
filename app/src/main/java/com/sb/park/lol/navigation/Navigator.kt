package com.sb.park.lol.navigation

import androidx.navigation.NavController

fun NavController.navigateToChampionInfoScreen(championId: String) {
    this.navigate("${NavScreen.ChampionInfo.route}/${championId}")
}

fun NavController.navigateToItemInfoScreen(itemId: String) {
    this.navigate("${NavScreen.ItemInfo.route}/${itemId}")
}