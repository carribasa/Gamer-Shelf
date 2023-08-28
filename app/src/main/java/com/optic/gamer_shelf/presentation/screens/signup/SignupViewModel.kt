package com.optic.gamer_shelf.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.optic.gamer_shelf.domain.model.Response
import com.optic.gamer_shelf.domain.model.User
import com.optic.gamer_shelf.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {

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

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow

    fun onSignup() {
        val user = User(
            userName = username.value,
            email = email.value,
            password = password.value
        )
        signup(user)
    }

    fun signup(user: User) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = authUseCases.signup(user)
        _signupFlow.value = result
    }

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