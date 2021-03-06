package com.example.jetpackcomposemessagingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposemessagingapp.models.Message

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
fun FloatingButton(fabClick: () -> Unit) {
    FloatingActionButton(onClick = { fabClick() }) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "")
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

//@Preview
//@Composable
//fun messagesListScreenPreview(){
//    val list = generateMessageList()
//    MessagesListScreenView(title = "Messages",list = list,fabClick = {fabclicks()},
//        itemClick = { message: Message -> messageClik(message = message) })
//}