package com.app.userslistapplicationmvvmsample.models.users


import com.app.userslistapplicationmvvmsample.utils.Empty
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Crypto(
    @SerialName("coin")
    var coin: String? = Empty,
    @SerialName("network")
    var network: String? = Empty,
    @SerialName("wallet")
    var wallet: String? = Empty
)