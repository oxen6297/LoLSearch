package com.sb.park.lol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sb.park.designsystem.ApiResult
import com.sb.park.designsystem.theme.LoLSearchTheme
import com.sb.park.lol.navigation.BottomNavItem
import com.sb.park.lol.navigation.BottomNavigation
import com.sb.park.lol.screen.DictionaryScreen
import com.sb.park.lol.screen.SearchScreen
import com.sb.park.lol.screen.SettingScreen
import com.sb.park.lol.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.net.UnknownHostException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoLSearchTheme {
                installSplashScreen().setKeepOnScreenCondition {
                    viewModel.isLoading.value != ApiResult.Loading
                }

                val navController = rememberNavController()
                val snackBarHostState = remember { SnackbarHostState() }
                val coroutineScope = rememberCoroutineScope()
                val onShowSnackBar: (throwable: Throwable?) -> Unit = { throwable ->
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
                    bottomBar = { BottomNavigation(navController = navController) }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItem.Dictionary.route,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(BottomNavItem.Dictionary.route) {
                            DictionaryScreen(onShowSnackBar, navController)
                        }
                        composable(BottomNavItem.Search.route) {
                            SearchScreen()
                        }
                        composable(BottomNavItem.Setting.route) {
                            SettingScreen()
                        }
                    }
                }
            }
        }
    }
}