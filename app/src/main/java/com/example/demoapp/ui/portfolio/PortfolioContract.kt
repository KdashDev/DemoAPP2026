package com.example.demoapp.ui.portfolio

import com.example.demoapp.data.model.Repository

data class PortfolioUiState(
    val isLoading: Boolean = false,
    val repositories: List<Repository> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)

sealed interface PortfolioIntent {
    data object LoadRepositories : PortfolioIntent
    data object RefreshRepositories : PortfolioIntent
    data class OnRepoClicked(val url: String) : PortfolioIntent
}
