package com.app.userslistapplicationmvvmsample.models.users


import com.app.userslistapplicationmvvmsample.utils.Nil
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("address")
    var address: Address? = Nil,
    @SerialName("age")
    var age: Int? = Nil,
    @SerialName("bank")
    var bank: Bank? = Nil,
    @SerialName("birthDate")
    var birthDate: String? =  Nil,
    @SerialName("bloodGroup")
    var bloodGroup: String? = Nil,
    @SerialName("company")
    var company: Company? = Nil,
    @SerialName("crypto")
    var crypto: Crypto? = Nil,
    @SerialName("domain")
    var domain: String? = Nil,
    @SerialName("ein")
    var ein: String? =  Nil,
    @SerialName("email")
    var email: String? = Nil,
    @SerialName("eyeColor")
    var eyeColor: String? = Nil,
    @SerialName("firstName")
    var firstName: String? = Nil,
    @SerialName("gender")
    var gender: String? = Nil,
    @SerialName("hair")
    var hair: Hair? = Nil,
    @SerialName("height")
    var height: Int? = Nil,
    @SerialName("id")
    var id: Int? = Nil,
    @SerialName("image")
    var image: String? = Nil,
    @SerialName("ip")
    var ip: String? = Nil,
    @SerialName("lastName")
    var lastName: String? = Nil,
    @SerialName("macAddress")
    var macAddress: String? = Nil,
    @SerialName("maidenName")
    var maidenName: String? = Nil,
    @SerialName("password")
    var password: String? =  Nil,
    @SerialName("phone")
    var phone: String? = Nil,
    @SerialName("ssn")
    var ssn: String? = Nil,
    @SerialName("university")
    var university: String? = Nil,
    @SerialName("userAgent")
    var userAgent: String? = Nil,
    @SerialName("username")
    var username: String? = Nil,
    @SerialName("weight")
    var weight: Double? = Nil
)