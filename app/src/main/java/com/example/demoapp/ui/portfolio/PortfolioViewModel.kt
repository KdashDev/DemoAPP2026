package com.example.demoapp.ui.portfolio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoapp.data.repository.PortfolioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PortfolioViewModel @Inject constructor(
    private val repository: PortfolioRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PortfolioUiState())
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()

    init {
        handleIntent(PortfolioIntent.LoadRepositories)
    }

    fun handleIntent(intent: PortfolioIntent) {
        when (intent) {
            is PortfolioIntent.LoadRepositories -> loadRepos(forceRefresh = false)
            is PortfolioIntent.RefreshRepositories -> loadRepos(forceRefresh = true)
            is PortfolioIntent.OnRepoClicked -> { /* Handle navigation or browser intent */ }
        }
    }

    private fun loadRepos(forceRefresh: Boolean) {
        viewModelScope.launch {
            _uiState.update { it.copy(
                isLoading = !forceRefresh,
                isRefreshing = forceRefresh,
                error = null 
            ) }

            repository.getRepositories("octocat", forceRefresh).collect { result ->
                result.fold(
                    onSuccess = { repos ->
                        _uiState.update { it.copy(
                            isLoading = false,
                            isRefreshing = false,
                            repositories = repos
                        ) }
                    },
                    onFailure = { error ->
                        _uiState.update { it.copy(
                            isLoading = false,
                            isRefreshing = false,
                            error = error.message ?: "Unknown error"
                        ) }
                    }
                )
            }
        }
    }
}
