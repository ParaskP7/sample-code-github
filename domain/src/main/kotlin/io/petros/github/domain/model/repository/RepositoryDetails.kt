package io.petros.github.domain.model.repository

import java.io.Serializable

data class RepositoryDetails(
    val id: Int,
    val subscribersCount: Int
) : Serializable
