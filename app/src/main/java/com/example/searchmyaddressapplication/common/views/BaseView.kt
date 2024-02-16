package com.example.searchmyaddressapplication.common.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.searchmyaddressapplication.common.logic.BaseViewModel

@Composable
fun <T : Any> BaseView(viewModel: BaseViewModel<T>, content: @Composable (T) -> Unit) {
    val uiState by viewModel.uiState.collectAsState()

    content(uiState)
}