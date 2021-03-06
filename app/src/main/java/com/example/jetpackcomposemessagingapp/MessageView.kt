package com.example.jetpackcomposemessagingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposemessagingapp.models.Message

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

@Preview
@Composable
fun MessageViewPreview() {
    val message = Message(
        sender = "Test sender",
        time = "10:00 AM",
        message = "Hello there, how are you?"
    )
    MessageView(message = message, itemClick = {})
}