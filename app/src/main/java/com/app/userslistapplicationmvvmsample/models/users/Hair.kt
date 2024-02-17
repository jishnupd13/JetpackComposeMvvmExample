package com.app.userslistapplicationmvvmsample.models.users


import com.app.userslistapplicationmvvmsample.utils.Empty
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hair(
    @SerialName("color")
    var color: String? = Empty,
    @SerialName("type")
    var type: String? = Empty
)