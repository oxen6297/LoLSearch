package com.sb.park.lol.screen.dictionary

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sb.park.lol.viewmodels.DictionaryViewModel

@Composable
internal fun ItemScreen(
    showSnackBar: (Throwable?) -> Unit,
    navController: NavController,
    viewModel: DictionaryViewModel = hiltViewModel()
) {

}