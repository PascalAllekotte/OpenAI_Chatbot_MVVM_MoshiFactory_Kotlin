package com.example.chatbot.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.chatbot.data.model.request.ChatRequest
import com.example.chatbot.data.model.Message
import com.example.chatbot.data.repository.ChatRepository

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val chatRepository = ChatRepository()

    val chatResponse = MutableLiveData<String?>()
    val errorMessage = MutableLiveData<String?>()
    val isLoading = MutableLiveData<Boolean>()

    fun createChatCompletion(messages: List<Message>, model: String) {
        isLoading.postValue(true)
        val request = ChatRequest(messages, model)
        chatRepository.createChatCompletion(request, { response ->
            isLoading.postValue(false)
            chatResponse.postValue(response?.choices?.firstOrNull()?.message?.content)
        }, { error ->
            isLoading.postValue(false)
            errorMessage.postValue(error)
        })
    }
}
