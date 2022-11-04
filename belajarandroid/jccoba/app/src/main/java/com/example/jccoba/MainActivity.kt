package com.example.jccoba

import android.content.res.Configuration
import android.os.Bundle
import android.provider.Telephony.Sms.Conversations
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import com.example.jccoba.ui.theme.JccobaTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JccobaTheme {
                Conversation(SampleData.conversationSample)
            }


        }
    }
}

object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        Message(
            "Lexi",
            "Test...Test...Test..."
        ),
        Message(
            "Lexi",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        Message(
            "Lexi",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        Message(
            "Lexi",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Lexi",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        Message(
            "Lexi",
            "It's available from API 21+ :)"
        ),
        Message(
            "Lexi",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Lexi",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Lexi",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Lexi",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Lexi",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Lexi",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Lexi",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}

data class Message(
    val  author : String,
    val  body   : String
)


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn{
        items(messages) {
            message -> MessageCard(message)
        }
    }
}

@Preview(name = "Conversation View")
@Composable
fun PreviewConversation() {
    JccobaTheme {
        Conversation(SampleData.conversationSample)
    }
}


@Composable
fun MessageCard(msg: Message) {
    Row(modifier =  Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Context",
            modifier = Modifier
                .size(40.dp) // gambar menjadi 40 dp
                .clip(CircleShape) // ubah gambar menjadi lingkaran
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ){
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }



        }
    }
}


