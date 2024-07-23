package com.sb.park.lol.screen.dictionary.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sb.park.designsystem.UiState
import com.sb.park.designsystem.onError
import com.sb.park.lol.viewmodels.ItemInfoViewModel

@Composable
internal fun ItemInfoScreen(
    showSnackBar: (Throwable?) -> Unit,
    viewModel: ItemInfoViewModel = hiltViewModel()
) {
    val uiStateFlow by viewModel.uiStateFlow.collectAsStateWithLifecycle()

    when (uiStateFlow) {
        is UiState.Loading -> {}
        is UiState.Success -> {}
        is UiState.Error -> showSnackBar(uiStateFlow.onError())
    }
}