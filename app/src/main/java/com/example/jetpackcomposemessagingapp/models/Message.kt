package com.example.jetpackcomposemessagingapp.models

data class Message(
    val time: String,
    val message: String,
    val sender: String,
    val senderImage: String? = null
)

data class ChatMessage(
    val message: String,
    val senderImage: String
)
