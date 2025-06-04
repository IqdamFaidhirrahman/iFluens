package com.example.profileifluens.viewmodel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.profileifluens.model.UserProfile

class AccountViewModel : ViewModel() {

    // null sampai data di-load dari database
    var userProfile by mutableStateOf<UserProfile?>(null)
        private set

    fun loadProfile(profile: UserProfile) {
        userProfile = profile
    }

    fun updateName(newName: String) {
        userProfile = userProfile?.copy(name = newName)
    }

    fun updateGender(newGender: String) {
        userProfile = userProfile?.copy(gender = newGender)
    }

    fun updateBirthDate(newDate: String) {
        userProfile = userProfile?.copy(birthDate = newDate)
    }

    fun updatePhone(newPhone: String) {
        userProfile = userProfile?.copy(phone = newPhone)
    }

    fun updateEmail(newEmail: String) {
        userProfile = userProfile?.copy(email = newEmail)
    }

    fun updatePhoto(uri: Uri?) {
        userProfile = userProfile?.copy(photoUri = uri)
    }

    fun resetPhoto() {
        userProfile = userProfile?.copy(photoUri = null)
    }
}