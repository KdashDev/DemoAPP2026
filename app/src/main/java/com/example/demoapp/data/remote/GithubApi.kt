package com.example.demoapp.data.remote

import com.example.demoapp.data.model.RepositoryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") username: String
    ): List<RepositoryDto>

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }
}
