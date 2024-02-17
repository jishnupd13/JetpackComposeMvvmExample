package com.app.userslistapplicationmvvmsample.models.users


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersModel(
    @SerialName("limit")
    var limit: Int?,
    @SerialName("skip")
    var skip: Int?,
    @SerialName("total")
    var total: Int?,
    @SerialName("users")
    var users: List<User>?
)