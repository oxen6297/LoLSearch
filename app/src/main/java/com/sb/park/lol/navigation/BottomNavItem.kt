package com.sb.park.lol.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sb.park.lol.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) {
    data object Champion : BottomNavItem(
        NavScreen.Champion.route,
        R.drawable.rune,
        R.string.champion
    )

    data object Item : BottomNavItem(
        NavScreen.Item.route,
        R.drawable.item,
        R.string.item
    )

    data object Rune : BottomNavItem(
        NavScreen.Rune.route,
        R.drawable.champion,
        R.string.rune
    )
}