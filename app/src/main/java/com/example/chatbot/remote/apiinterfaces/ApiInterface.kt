package com.example.chatbot.remote.apiinterfaces

import com.example.chatbot.data.model.request.ChatRequest
import com.example.chatbot.data.model.response.ChatResponse
import de.syntax.androidabschluss.utils.OPENAI_API_KEY
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiInterface {

    @POST("chat/completions")
    fun createChatCompletion(
        @Body chatgp: ChatRequest,
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Authorization") authorization: String = "Bearer $OPENAI_API_KEY",


        ): Call<ChatResponse>
}