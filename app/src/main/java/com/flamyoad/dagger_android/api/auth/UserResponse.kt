package com.flamyoad.dagger_android.api.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?,
    val address: UserResponseAddress?,
    val phone: String?,
    val website: String?,
    val company: UserResponseCompany?
)

@JsonClass(generateAdapter = true)
data class UserResponseAddress(
    val street: String?,
    val suite: String?,
    val city: String?,
    val zipcode: String?,
    val geo: UserResponseGeo?,
)

@JsonClass(generateAdapter = true)
data class UserResponseGeo(
    val lat: String?,
    val lng: String?
)

@JsonClass(generateAdapter = true)
data class UserResponseCompany(
    val name: String?,
    val catchPhrase: String?,
    val bs: String?
)
