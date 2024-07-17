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
        ScreenNav.Dictionary.route,
        R.drawable.dictionary,
        R.string.bottom_dictionary
    )

    data object Search : BottomNavItem(
        ScreenNav.Search.route,
        R.drawable.search,
        R.string.bottom_search
    )

    data object Setting : BottomNavItem(
        ScreenNav.MyPage.route,
        R.drawable.my_page,
        R.string.bottom_my_page
    )
}