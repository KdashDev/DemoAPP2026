package com.example.demoapp.data.repository

import com.example.demoapp.data.model.Repository
import com.example.demoapp.data.model.toDomain
import com.example.demoapp.data.remote.GithubApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PortfolioRepository @Inject constructor(
    private val api: GithubApi
) {
    // Simple in-memory cache for this example
    private var cachedRepos: List<Repository>? = null

    fun getRepositories(username: String, forceRefresh: Boolean = false): Flow<Result<List<Repository>>> = flow {
        if (!forceRefresh && cachedRepos != null) {
            emit(Result.success(cachedRepos!!))
            return@flow
        }

        try {
            val remoteRepos = api.getUserRepos(username).map { it.toDomain() }
            cachedRepos = remoteRepos
            emit(Result.success(remoteRepos))
        } catch (e: Exception) {
            if (cachedRepos != null) {
                emit(Result.success(cachedRepos!!)) // Return stale data on error if available
            } else {
                emit(Result.failure(e))
            }
        }
    }
}
