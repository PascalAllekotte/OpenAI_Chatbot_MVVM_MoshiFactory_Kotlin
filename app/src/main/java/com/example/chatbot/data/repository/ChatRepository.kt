package com.example.chatbot.data.repository

import com.example.chatbot.data.model.request.ChatRequest
import com.example.chatbot.data.model.response.ChatResponse
import com.example.chatbot.remote.client.OpAiClient
import de.syntax.androidabschluss.utils.OPENAI_API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatRepository {

    private val apiClient = OpAiClient.getInstance()

    fun createChatCompletion(
        chatRequest: ChatRequest,
        onSuccess: (ChatResponse?) -> Unit,
        onError: (String) -> Unit
    ) {
        apiClient.createChatCompletion(chatRequest, "application/json", "Bearer $OPENAI_API_KEY")
            .enqueue(object : Callback<ChatResponse> {
                override fun onResponse(
                    call: Call<ChatResponse>,
                    response: Response<ChatResponse>
                ) {
                    if (response.isSuccessful) {
                        onSuccess(response.body())
                    } else {
                        onError(
                            "API call successful but returned an error: ${
                                response.errorBody()?.string()
                            }"
                        )
                    }
                }

                override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                    onError("API call failed: ${t.message}")
                }
            })
    }
}