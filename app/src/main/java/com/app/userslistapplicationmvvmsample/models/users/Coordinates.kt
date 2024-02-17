package com.app.userslistapplicationmvvmsample.models.users


import com.app.userslistapplicationmvvmsample.utils.Nil
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    @SerialName("lat")
    var lat: Double? = Nil,
    @SerialName("lng")
    var lng: Double? = Nil
)