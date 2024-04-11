package com.example.chatbot.ui
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.chatbot.databinding.FragmentChatBotBinding
import com.example.chatbot.utils.hideKeyBoard
import com.example.chatbot.utils.longToastShow
import com.example.chatbot.data.model.Message
import com.example.chatbot.viewmodel.ChatViewModel

class ChatBotFragment : Fragment() {

    private lateinit var binding: FragmentChatBotBinding

    private val viewModel: ChatViewModel by lazy {
        ViewModelProvider(this).get(ChatViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendButton.setOnClickListener {
            view.context.hideKeyBoard(it) // Versteckt die Tastatur

            val messageText = binding.messageInput.text.toString().trim()
            if (messageText.isNotEmpty()) {
                val message = Message(content = messageText, role = "user")
                viewModel.createChatCompletion(listOf(message), "gpt-3.5-turbo") // Modell entsprechend anpassen 3.5 ist billiger
                binding.messageInput.text = null


            } else {
                view.context.longToastShow("Bitte eingabe machen vorher!") // auch im utils für cleaneren code
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.chatResponse.observe(viewLifecycleOwner) { response ->
            response?.let {
                binding.responseText.text = it
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                view.context.longToastShow(it)
            }
        }
    }
}
