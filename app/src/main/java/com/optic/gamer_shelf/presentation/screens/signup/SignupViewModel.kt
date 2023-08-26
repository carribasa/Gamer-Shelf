package com.optic.gamer_shelf.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {

    // USERNAME
    var username: MutableState<String> = mutableStateOf("")

    // EMAIL
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    // PASSWORD
    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    // CONFIRM PASSWORD
    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isSamePassword: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")

    // ENABLE BUTTON
    var isEnabledSignupButton = false

    fun enabledSignupButton() {
        isEnabledSignupButton =
            isEmailValid.value && isPasswordValid.value && isSamePassword.value
    }

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrMsg.value = "El email no es valido"
        }
        enabledSignupButton()
    }

    fun validatePasswordLength() {
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrMsg.value = "Al menos 6 caracteres"
        }
        enabledSignupButton()
    }

    fun validateSamePassword() {
        if (confirmPassword.value == password.value) {
            isSamePassword.value = true
            confirmPasswordErrMsg.value = ""
        } else {
            isSamePassword.value = false
            confirmPasswordErrMsg.value = "La contraseña no coincide"
        }
        enabledSignupButton()
    }
}