package com.mathiasbrandt.aphelion.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.mathiasbrandt.aphelion.models.Conversation
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

class DataManager {
    private val conversations = listOf<Conversation>(
            Conversation(0, "Mathias", "You: Hi! How are you?", LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()),
            Conversation(1, "Anita", "Anita: When will you arrive tonight?", LocalDateTime.now().minusDays(3).minusHours(2).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()),
            Conversation(2, "Kristian", "You: Har du booket øvelokale til i morgen?", LocalDateTime.now().minusHours(3).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))

    fun getConversations(): List<Conversation> {
//        val data = MutableLiveData<List<Conversation>>()
//        data.value = conversations
//        return data
        return conversations
    }

    fun getConversation(conversationId: Long): Conversation? {
        return conversations.find { it.id == conversationId }
    }
}
