package com.shahira.myuacademy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahira.myuacademy.dataclasses.UserAccounts
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val auth: FirebaseAuth
): ViewModel() {

    private val _isAdminLogin = MutableStateFlow(false)
    var isAdminLogin: StateFlow<Boolean> = _isAdminLogin

    sealed class AuthState {
        object Idle : AuthState()
        object Loading : AuthState()
        data class Success(val user: String) : AuthState()
        data class Error(val message: String) : AuthState()
    }


    private val _authState = MutableStateFlow<AuthState>(
        if (auth.currentUser != null) AuthState
            .Success(auth.currentUser!!.uid)
        else AuthState.Idle
    )
    val authState: StateFlow<AuthState> = _authState

    val isLoggedIn: Boolean
        get() = authState.value is AuthState.Success

    //getting current user
    val currentUser = auth.currentUser?.let { firebaseUser ->
        UserAccounts(
            uid = firebaseUser.uid,
            name = firebaseUser.displayName ?: "",
            email = firebaseUser.email ?: "",
            adminKey = 0
        )
    }

    //login
    fun login(email: String, password: String) {
        _isAdminLogin.value = false
        _authState.value = AuthState.Loading

        viewModelScope.launch {
            try {
                val result = auth.signInWithEmailAndPassword(email, password).await()

                result.user?.let {
                    _authState.value = AuthState.Success(it.uid)
                } ?: run {
                    _authState.value = AuthState.Error("User not found")
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Login Failed")
            }
        }
    }

    // admin login
    fun adminLogin(email: String, password: String, adminKey: Int) {
        _authState.value = AuthState.Loading
        viewModelScope.launch {
            try {
                val result = auth.signInWithEmailAndPassword(email, password).await()
                result.user?.let {
                    if (adminKey == 1234) {
                        _isAdminLogin.value = true
                        _authState.value = AuthState.Success(it.uid)
                    } else {
                        _authState.value = AuthState.Error("Invalid admin key")
                    }
                } ?: run {
                    _authState.value = AuthState.Error("User not found")
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Login Failed")

            }
        }
    }

    fun signUp(name: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                _authState.value = AuthState.Loading
                auth.createUserWithEmailAndPassword(email, password).await()
                _authState.value = AuthState.Success("Sign Up Successful")
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Sign Up Failed")

            }
        }
    }

    fun signOut() {
        auth.signOut()
        _isAdminLogin.value = false
        _authState.value = AuthState.Idle
    }
}