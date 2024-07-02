package com.sb.park.lol.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sb.park.lol.viewmodels.DetailViewModel

@Composable
fun DetailScreen(
    showSnackBar: (Throwable?) -> Unit,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {

}