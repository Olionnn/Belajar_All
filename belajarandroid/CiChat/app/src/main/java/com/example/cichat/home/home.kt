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
import com.example.cichat.HomeRoutes
import com.example.cichat.LoginRoutes
import com.example.cichat.login.loginViewModel
import kotlinx.coroutines.launch

@Composable
fun Home(
    loginViewModel: loginViewModel? = null,
    logout:() -> Unit,
) {
    val scope  = rememberCoroutineScope()
    val context =  LocalContext.current
    Text(text = "This Is Home")
    Button(modifier = Modifier.fillMaxWidth().padding(20.dp),onClick = { scope.launch { logout.invoke() }  }) {
        Text(text = "Logout")
    }
}