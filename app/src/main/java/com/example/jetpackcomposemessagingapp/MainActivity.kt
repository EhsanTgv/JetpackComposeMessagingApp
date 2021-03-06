package com.example.jetpackcomposemessagingapp

import android.os.Bundle
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
            JetpackComposeMessagingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MessagesListScreenView("Messages", {}, {})
                }
            }
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

@Composable
fun MessagesListScreenView(
    title: String,
    fabClick: () -> Unit,
    itemClick: (message: Message) -> Unit
) {
    Scaffold(
        topBar = { MessageListTopBar(title = title) },
        floatingActionButton = { FloatingButton(fabClick = fabClick) }) {
    }
}

@Composable
fun MessageListTopBar(title: String) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
                modifier = Modifier.padding(start = 10.dp, end = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_options_menu),
                contentDescription = "",
                modifier = Modifier.padding(start = 10.dp, end = 8.dp)
            )
        },
        backgroundColor = Color.White
    )
}

@Composable
fun FloatingButton(fabClick: () -> Unit) {
    FloatingActionButton(onClick = { fabClick() }) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "")
    }
}

@Composable
fun MessageView(
    message: Message,
    itemClick: (message: Message) -> Unit
) {
    Row(modifier = Modifier.padding(16.dp)) {
        SenderIcon()
        Column(modifier = Modifier.padding(start = 8.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Sender(sender = message.sender, modifier = Modifier.weight(1f))
                MessageTime(time = message.time)
            }
            ShortMessage(shortMessage = message.message)
        }
    }
}

@Composable
fun SenderIcon() {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(30.dp)
            .background(Color.DarkGray)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "",
            tint = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun Sender(sender: String, modifier: Modifier = Modifier) {
    Text(
        text = sender,
        style = TextStyle(color = Color.Black, fontSize = 18.sp),
        modifier = modifier,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun MessageTime(time: String) {
    Text(
        text = time,
        style = TextStyle(
            color = Color.Gray,
            fontSize = 12.sp
        ),
        maxLines = 1
    )
}

@Composable
fun ShortMessage(shortMessage: String, modifier: Modifier = Modifier) {
    Text(
        text = shortMessage,
        style = TextStyle(
            color = Color.DarkGray,
            fontSize = 14.sp
        ),
        modifier = modifier,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

