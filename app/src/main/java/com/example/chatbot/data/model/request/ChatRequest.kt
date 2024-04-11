package com.example.chatbot.data.model.request

import com.example.chatbot.data.model.Message
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ChatRequest(
    @Json(name = "messages") val messages: List<Message>,
    @Json(name = "model") val model: String
)