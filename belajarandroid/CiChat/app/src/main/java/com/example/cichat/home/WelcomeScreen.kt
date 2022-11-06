package com.example.cichat.home


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.cichat.login.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun Home(
    loginViewModel: LoginViewModel? = null,
//    logout():
) {
    val scope  = rememberCoroutineScope()
    val context =  LocalContext.current
    Text(text = "This Is Home")
//    Button(modifier = Modifier.fillMaxWidth().padding(20.dp),onClick = {  scope.launch { loginViewModel?.LogOut() }  }) {
        Text(text = "Logout")
    }
//}