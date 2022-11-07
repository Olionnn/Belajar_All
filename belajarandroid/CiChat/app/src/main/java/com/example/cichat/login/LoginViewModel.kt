package com.example.cichat.login

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cichat.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//class loginViewModel(
//    private val repository: AuthRepository = AuthRepository()
//):ViewModel() {
//    val currentUser = repository.currentUser
//
//    val hasUser: Boolean
//        get() = repository.hasUser()
//
//    var loginUiState by mutableStateOf(LoginUiState())
//        private set
//
//    var loguotState by mutableStateOf(LoginUiState())
//        private set
//
//    fun onUserNameChange(userName: String){
//        loginUiState = loginUiState.copy(userName = userName)
//    }
//    fun onPasswordNameChange(password: String){
//        loginUiState = loginUiState.copy(password = password)
//    }
//    fun onUserNameChangeSignup(userName: String){
//        loginUiState = loginUiState.copy(userNameSignUp = userName)
//    }
//    fun onPasswordChangeSignup(password: String){
//        loginUiState = loginUiState.copy(passwordSignUp = password)
//    }
//    fun onConfirmPasswordChange(password: String){
//        loginUiState = loginUiState.copy(confirmPasswordSignUp = password)
//    }
//
//    private  fun validateLoginForm() =
//        loginUiState.userName.isNotBlank() &&
//                loginUiState.password.isNotBlank()
//
//    private fun validateSignupForm() =
//        loginUiState.userNameSignUp.isNotBlank() &&
//                loginUiState.passwordSignUp.isNotBlank() &&
//                loginUiState.confirmPasswordSignUp.isNotBlank()
//
//
//
//
//    fun createUser(context: Context) = viewModelScope.launch {
//        try {
//            if (!validateSignupForm()){
//                throw java.lang.IllegalArgumentException("email and passord can not be empty")
//            }
//            loginUiState = loginUiState.copy(isLoading = true)
//            if (loginUiState. passwordSignUp !=
//                loginUiState.confirmPasswordSignUp){
//                throw IllegalArgumentException(
//                    "Password do not match"
//                )
//            }
//            loginUiState = loginUiState.copy(signUpError = null)
//            repository.createUser(
//                loginUiState.userNameSignUp,
//                loginUiState.passwordSignUp
//            ){ isSuccessful ->
//                if (isSuccessful){
//                    Toast.makeText(
//                        context,
//                        "Success Login",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    loginUiState = loginUiState.copy(isSuccessLogin = true)
//                }else{
//                    Toast.makeText(
//                        context,
//                        "Failed Login",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    loginUiState = loginUiState.copy(isSuccessLogin = false)
//                }
//
//            }
//
//
//        }catch (e:Exception) {
//            loginUiState = loginUiState.copy(signUpError = e.localizedMessage)
//            e.printStackTrace()
//        }finally {
//            loginUiState = loginUiState.copy(isLoading = false)
//        }
//    }
//    fun loginUser(context: Context) = viewModelScope.launch {
//        try {
//            if (!validateLoginForm()){
//                throw IllegalArgumentException("email and passord can not be empty")
//            }
//            loginUiState = loginUiState.copy(isLoading = true)
//
//            loginUiState = loginUiState.copy(loginError = null)
//            repository.login(
//                loginUiState.userName,
//                loginUiState.password
//            ){ isSuccessful ->
//                if (isSuccessful){
//                    Toast.makeText(
//                        context,
//                        "Success Login",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    loginUiState = loginUiState.copy(isSuccessLogin = true)
//                }else{
//                    Toast.makeText(
//                        context,
//                        "Failed Login",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    loginUiState = loginUiState.copy(isSuccessLogin = false)
//                }
//
//            }
//
//
//        }catch (e:Exception) {
//            loginUiState = loginUiState.copy(loginError = e.localizedMessage)
//            e.printStackTrace()
//        }finally {
//            loginUiState = loginUiState.copy(isLoading = false)
//        }
//    }
//    fun LogOut() = viewModelScope.launch {
//        repository.logout()
//    }
//
//
//}

//data class LoginUiState(
//    val userName:String = "",
//    val password:String = "",
//    val userNameSignUp: String = "",
//    val passwordSignUp:String = "",
//    val confirmPasswordSignUp:String = "",
//    val isLoading:Boolean = false,
//    val isSuccessLogin:Boolean = false,
//    val signUpError:String? = null,
//    val loginError:String? = null,
//)

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _isLoggedIn = mutableStateOf(false)
    val isLoggedIn: State<Boolean> = _isLoggedIn

    private val _error = mutableStateOf("")
    val error: State<String> = _error

    private val _userEmail = mutableStateOf("")
    val userEmail: State<String> = _userEmail

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _confirmpassword = mutableStateOf("")
    val confirmpassword: State<String> = _confirmpassword

    // Setters
    fun setUserEmail(email: String) {
        _userEmail.value = email
    }

    fun setPassword(password: String) {
        _password.value = password
    }
    fun setConfirmPassword(confirmpassword: String) {
        _confirmpassword.value = confirmpassword
    }

    fun setError(error: String) {
        _error.value = error
    }

    init {
        _isLoggedIn.value = getCurrentUser() != null
    }

    fun createUserWithEmailAndPassword() = viewModelScope.launch {
        _error.value = ""
        Firebase.auth.createUserWithEmailAndPassword(userEmail.value, password.value)
            .addOnCompleteListener { task -> signInCompletedTask(task) }
    }

    fun signInWithEmailAndPassword() = viewModelScope.launch {
        try {
            _error.value = ""
            Firebase.auth.signInWithEmailAndPassword(userEmail.value, password.value)
                .addOnCompleteListener { task -> signInCompletedTask(task) }
        } catch (e: Exception) {
            _error.value = e.localizedMessage ?: "Unknown error"
            Log.d(TAG, "Sign in fail: $e")
        }
    }

    private fun signInCompletedTask(task: Task<AuthResult>) {
        if (task.isSuccessful) {
            // TODO success action and error message
            Log.d(TAG, "SignInWithEmail:success")
        } else {
            _error.value = task.exception?.localizedMessage ?: "Unknown error"
            // If sign in fails, display a message to the user.
            Log.w(TAG, "SignInWithEmail:failure", task.exception)
        }
        viewModelScope.launch {
            _isLoggedIn.value = getCurrentUser() != null
        }
    }

    private fun getCurrentUser() : FirebaseUser? {
        val user = Firebase.auth.currentUser
        Log.d(TAG, "user display name: ${user?.displayName}, email: ${user?.email}")
        return user
    }

    fun isValidEmailAndPassword() : Boolean {
        if (userEmail.value.isBlank() || password.value.isBlank()) {
            return false
        }
        if (password.value == confirmpassword.value){
        return true
        } else {
            _error.value = "Password not match"
            return false
        }

    }
    fun signOut() = viewModelScope.launch {
        Firebase.auth.signOut()
        _isLoggedIn.value = false
    }



}