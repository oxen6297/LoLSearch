package com.sb.park.lol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sb.park.lol.navigation.BottomNavItem
import com.sb.park.lol.navigation.BottomNavigation
import com.sb.park.lol.screen.DictionaryScreen
import com.sb.park.lol.screen.SearchScreen
import com.sb.park.lol.screen.SettingScreen
import com.sb.park.lol.ui.theme.LoLSearchTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoLSearchTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigation(navController = navController) }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItem.Dictionary.route,
                        Modifier.padding(it)
                    ) {
                        composable(BottomNavItem.Dictionary.route) {
                            DictionaryScreen()
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

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        LoLSearchTheme {

        }
    }
}