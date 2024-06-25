package com.sb.park.lol.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sb.park.lol.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) {
    data object Dictionary : BottomNavItem(
        "dictionary",
        R.drawable.dictionary,
        R.string.bottom_dictionary
    )

    data object Search : BottomNavItem(
        "search",
        R.drawable.search,
        R.string.bottom_search
    )

    data object Setting : BottomNavItem(
        "setting",
        R.drawable.settings,
        R.string.bottom_setting
    )
}