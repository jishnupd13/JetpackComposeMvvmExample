package com.app.userslistapplicationmvvmsample.models.users


import com.app.userslistapplicationmvvmsample.utils.Empty
import com.app.userslistapplicationmvvmsample.utils.Nil
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    @SerialName("address")
    var address: String? = Empty,
    @SerialName("city")
    var city: String? = Empty,
    @SerialName("coordinates")
    var coordinates: Coordinates? = Nil,
    @SerialName("postalCode")
    var postalCode: String? = Empty,
    @SerialName("state")
    var state: String? = Empty
)