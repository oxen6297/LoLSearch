package com.sb.park.lol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sb.park.designsystem.theme.LoLSearchTheme
import com.sb.park.lol.navigation.BottomNavItem
import com.sb.park.lol.navigation.BottomNavigation
import com.sb.park.lol.navigation.NavScreen
import com.sb.park.lol.screen.champion.ChampionInfoScreen
import com.sb.park.lol.screen.champion.ChampionScreen
import com.sb.park.lol.screen.item.ItemInfoScreen
import com.sb.park.lol.screen.item.ItemScreen
import com.sb.park.lol.screen.rune.RuneScreen
import com.sb.park.lol.utils.KeyFile
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.net.UnknownHostException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoLSearchTheme {
                val navController = rememberNavController()
                val coroutineScope = rememberCoroutineScope()
                val snackBarHostState = remember { SnackbarHostState() }
                val showErrorSnackBar: (throwable: Throwable?) -> Unit = { throwable ->
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(
                            when (throwable) {
                                is UnknownHostException -> getString(R.string.snack_bar_error_network)
                                else -> getString(R.string.snack_bar_error_unknown)
                            }
                        )
                    }
                }

                Scaffold(
                    containerColor = MaterialTheme.colorScheme.surface,
                    snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                    bottomBar = { BottomNavigation(navController = navController) }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItem.Champion.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = BottomNavItem.Champion.route) {
                            ChampionScreen(
                                showErrorSnackBar = showErrorSnackBar,
                                navController = navController
                            )
                        }
                        composable(route = BottomNavItem.Item.route) {
                            ItemScreen(
                                showErrorSnackBar = showErrorSnackBar,
                                navController = navController
                            )
                        }
                        composable(route = BottomNavItem.Rune.route) {
                            RuneScreen(
                                showErrorSnackBar = showErrorSnackBar,
                                navController = navController
                            )
                        }
                        composable(
                            route = "${NavScreen.ChampionInfo.route}/{${KeyFile.CHAMPION_ID}}",
                            arguments = listOf(
                                navArgument(KeyFile.CHAMPION_ID) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            ChampionInfoScreen(showErrorSnackBar = showErrorSnackBar)
                        }
                        composable(
                            route = "${NavScreen.ItemInfo.route}/{${KeyFile.ITEM_ID}}",
                            arguments = listOf(
                                navArgument(KeyFile.ITEM_ID) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            ItemInfoScreen(showErrorSnackBar = showErrorSnackBar)
                        }
                    }
                }
            }
        }
    }
}