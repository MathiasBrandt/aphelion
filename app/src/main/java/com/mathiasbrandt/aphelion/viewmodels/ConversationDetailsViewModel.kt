package com.mathiasbrandt.aphelion.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mathiasbrandt.aphelion.AphelionApplication
import com.mathiasbrandt.aphelion.data.DataManager
import com.mathiasbrandt.aphelion.models.Conversation
import javax.inject.Inject

class ConversationDetailsViewModel: ViewModel() {
    @Inject lateinit var dataManager: DataManager

    init {
        AphelionApplication.appComponent.inject(this)
    }

    fun getConversation(conversationId: Long): LiveData<Conversation> {
        val result = MutableLiveData<Conversation>()
        result.value = dataManager.getConversation(conversationId)
        return result
    }
}