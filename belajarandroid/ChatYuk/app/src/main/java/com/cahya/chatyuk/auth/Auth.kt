package com.cahya.chatyuk.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AuthScreen() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "ChatYuk!!!",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(0.5f)
                    .shadow(20.dp, RoundedCornerShape(23.dp))
                    .clip(shape = RoundedCornerShape(size = 20.dp))
                    .background(MaterialTheme.colorScheme.onBackground)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .padding(vertical = 10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Login With Email",
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.primary,
                                background = MaterialTheme.colorScheme.surface,
                                textAlign = TextAlign.Center,

                            )
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Login With Email",
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.primary,
                                background = MaterialTheme.colorScheme.surface,
                                textAlign = TextAlign.Center,

                                )
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.secondaryContainer)
                    ) {
                        Text(
                            text = "Login With Email",
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.primary,
                                background = MaterialTheme.colorScheme.surface,
                                textAlign = TextAlign.Center,

                                )
                        )
                    }
                }

            }

        }

    }
}

@Preview(name = "AuthLogin", showSystemUi = true)
@Composable
fun AuthPreview() {
    AuthScreen()
}