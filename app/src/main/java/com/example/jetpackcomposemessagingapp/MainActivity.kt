package com.example.jetpackcomposemessagingapp

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.animatedVectorResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposemessagingapp.models.Message
import com.example.jetpackcomposemessagingapp.ui.theme.JetpackComposeMessagingAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list = generateMessageList()
            MessagesListScreenView(
                title = "Messages",
                list = list,
                fabClick = {fabclicks()},
                itemClick = {message: Message -> messageClik(message = message) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeMessagingAppTheme {
        // A surface container using the 'background' color from the theme
    }
}

fun fabclicks(){
    Log.v("sample_ksdjds", "fabclicks ")
}

fun messageClik(message: Message){
    Log.v("sample_ksdjds", "messageClik - ${message.sender} ")
//    startActivity(
//        Intent(
//            this@MainActivity,
//            UserListActivity::class.java
//        )
//    )

}

fun generateMessageList(): MutableList<Message> {
    return (0..100).map {
        Message(
            sender = "Test sender $it",
            time = "10:00 AM",
            message = "Message body text Message body text Message body text Message body text Message body text "
        )
    }.toMutableList()
}

