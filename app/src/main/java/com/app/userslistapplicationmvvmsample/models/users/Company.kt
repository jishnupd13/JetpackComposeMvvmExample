package com.app.userslistapplicationmvvmsample.models.users


import com.app.userslistapplicationmvvmsample.utils.Empty
import com.app.userslistapplicationmvvmsample.utils.Nil
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    @SerialName("address")
    var address: Address? = Nil,
    @SerialName("department")
    var department: String? = Empty,
    @SerialName("name")
    var name: String? = Empty,
    @SerialName("title")
    var title: String? = Empty
)