package com.sb.park.lol.navigation

import androidx.navigation.NavController

fun NavController.navigateToDetailScreen(championId: String) {
    this.navigate("${ScreenNav.DETAIL.route}/${championId}")
}