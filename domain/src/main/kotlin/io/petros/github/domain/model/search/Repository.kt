package io.petros.github.domain.model.search

import java.io.Serializable

data class Repository(
    val id: Int,
    val ownerAvatar: String,
    val name: String,
    val description: String?,
    val numberOfForks: Int,
    val subscribersUrl: String
) : Serializable
