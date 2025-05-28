package com.example.profileifluens.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {
    var name = mutableStateOf("Riyan Fauzi")
    var gender = mutableStateOf("Pria")
    var birthDate = mutableStateOf("10/03/2000")
    var phone = mutableStateOf("0858192836189")
    var email = mutableStateOf("riyanxx@gmail.com")
}