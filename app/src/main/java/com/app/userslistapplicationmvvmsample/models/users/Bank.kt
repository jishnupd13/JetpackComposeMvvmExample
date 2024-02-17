package com.app.userslistapplicationmvvmsample.models.users


import com.app.userslistapplicationmvvmsample.utils.Empty
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    @SerialName("cardExpire")
    var cardExpire: String? = Empty,
    @SerialName("cardNumber")
    var cardNumber: String? = Empty,
    @SerialName("cardType")
    var cardType: String? = Empty,
    @SerialName("currency")
    var currency: String? = Empty,
    @SerialName("iban")
    var iban: String? = Empty
)