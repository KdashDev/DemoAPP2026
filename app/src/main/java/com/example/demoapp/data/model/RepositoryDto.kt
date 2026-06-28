package com.example.demoapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepositoryDto(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String? = null,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("stargazers_count") val stars: Int,
    @SerialName("language") val language: String? = null,
    @SerialName("owner") val owner: OwnerDto
)

@Serializable
data class OwnerDto(
    @SerialName("login") val login: String,
    @SerialName("avatar_url") val avatarUrl: String
)

data class Repository(
    val id: Long,
    val name: String,
    val description: String,
    val url: String,
    val stars: Int,
    val language: String,
    val ownerName: String,
    val ownerAvatarUrl: String
)

fun RepositoryDto.toDomain() = Repository(
    id = id,
    name = name,
    description = description ?: "No description provided",
    url = htmlUrl,
    stars = stars,
    language = language ?: "Unknown",
    ownerName = owner.login,
    ownerAvatarUrl = owner.avatarUrl
)
