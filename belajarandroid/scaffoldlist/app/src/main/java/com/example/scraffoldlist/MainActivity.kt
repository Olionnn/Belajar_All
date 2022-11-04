package com.example.scardfold_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.example.scardfold_list.ui.theme.Scardfold_listTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffoldlayout()
        }
    }
}

@Composable
fun Scaffoldlayout() {
    val materialcolor = Color.Red
    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember{
        mutableStateOf("")
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "APPBAR-List", color = Color.White)
                },
                backgroundColor = materialcolor

            )
        },
        bottomBar = {
            BottomAppBar(backgroundColor = materialcolor, modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Blue)
                        .padding(10.dp)
                        .clickable { }
                    ) {
                        Text(text = "1", color = Color.White)
                    }
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Black)
                        .padding(10.dp)
                        .clickable { }
                    ) {
                        Text(text = "2", color = Color.White)
                    }
                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.Green)
                        .padding(10.dp)
                        .clickable { }
                    ) {
                        Text(text = "3", color = Color.White)
                    }
                }


            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Text(text = "+")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        drawerContent = {
            Text(text = "Drawer 1 ")
        },
        // content = { Text(text "aokwoakwokwao")}
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 30.dp
            )) {
//            TextField(value =textFieldState, label =)
        }
        Text(text = "DRWARAWijirwj")
        // Untuk Content / isi Dalam ScarFOld bisa menghapus {} / Mengunakan Fungtiom Content =
    }
}

