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
        ScreenNav.DICTIONARY.route,
        R.drawable.dictionary,
        R.string.bottom_dictionary
    )

    data object Search : BottomNavItem(
        ScreenNav.SEARCH.route,
        R.drawable.search,
        R.string.bottom_search
    )

    data object Setting : BottomNavItem(
        ScreenNav.SETTING.route,
        R.drawable.settings,
        R.string.bottom_setting
    )
}