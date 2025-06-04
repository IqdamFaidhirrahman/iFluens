package com.example.profileifluens.model

import android.net.Uri

data class UserProfile(

    val name: String,
    val gender: String,
    val birthDate: String,
    val phone: String,
    val email: String,
    val photoUri: Uri? = null
)