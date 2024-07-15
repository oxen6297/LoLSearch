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
import com.sb.park.lol.navigation.ScreenNav
import com.sb.park.lol.screen.detail.DetailScreen
import com.sb.park.lol.screen.dictionary.DictionaryScreen
import com.sb.park.lol.screen.match.MatchScreen
import com.sb.park.lol.screen.setting.SettingScreen
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
                        startDestination = BottomNavItem.Dictionary.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = BottomNavItem.Dictionary.route) {
                            DictionaryScreen(showErrorSnackBar, navController)
                        }
                        composable(route = BottomNavItem.Search.route) {
                            MatchScreen()
                        }
                        composable(route = BottomNavItem.Setting.route) {
                            SettingScreen()
                        }
                        composable(
                            route = "${ScreenNav.DETAIL.route}/{${KeyFile.CHAMPION_ID}}",
                            arguments = listOf(
                                navArgument(KeyFile.CHAMPION_ID) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            DetailScreen(showErrorSnackBar)
                        }
                    }
                }
            }
        }
    }
}