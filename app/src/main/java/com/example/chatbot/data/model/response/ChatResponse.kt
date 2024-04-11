package com.example.chatbot.data.model.response

import com.example.chatbot.data.model.Choice
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ChatResponse(
    @Json(name = "choices") val choices: List<Choice>
)
