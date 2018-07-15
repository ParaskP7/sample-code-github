package io.petros.github.domain.model.repository

import java.io.Serializable

data class Repository(
    val id: Int,
    val ownerAvatar: String,
    val login: String,
    val name: String,
    val description: String?,
    val numberOfForks: Int,
    val subscribersUrl: String
) : Serializable
