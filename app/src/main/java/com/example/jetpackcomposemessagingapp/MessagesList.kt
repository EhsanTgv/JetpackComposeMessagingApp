package com.example.jetpackcomposemessagingapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposemessagingapp.models.Message

@Composable
fun MessagesList(
    list: MutableList<Message>,
    itemClick: (message: Message) -> Unit
) {
    LazyColumn {
        items(list.size) { item ->
            MessageView(message = list[item], itemClick = itemClick)
        }
    }
}

@Preview
@Composable
fun messagesListPreview() {
    val list = generateMessageList()
    MessagesList(list = list, itemClick = {})
}