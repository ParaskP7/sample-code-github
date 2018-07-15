package io.petros.github.domain.model.search

data class Repository(
    val id: Int,
    val ownerAvatar: String,
    val name: String,
    val description: String?,
    val numberOfForks: Int
)
