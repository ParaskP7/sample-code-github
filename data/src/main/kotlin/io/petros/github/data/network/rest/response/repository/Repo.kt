package io.petros.github.data.network.rest.response.repository

data class Repo(
    val id: Int,
    val name: String,
    val owner: Owner,
    val description: String?,
    val forks_count: Int,
    val subscribers_url: String
)
