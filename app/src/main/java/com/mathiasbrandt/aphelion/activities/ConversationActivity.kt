package com.mathiasbrandt.aphelion.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mathiasbrandt.aphelion.R
import com.mathiasbrandt.aphelion.fragments.ConversationDetailsFragment
import com.mathiasbrandt.aphelion.fragments.ConversationsListFragment
import com.mathiasbrandt.aphelion.hostinterfaces.ConversationsListHost
import com.mathiasbrandt.aphelion.replaceFragment

class ConversationActivity : AppCompatActivity(), ConversationsListHost {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation)

        replaceFragment(ConversationsListFragment(), R.id.fragment_container, false)
    }

    override fun showConversationDetails(conversationId: Long) {
        replaceFragment(ConversationDetailsFragment.Companion.newInstance(conversationId), R.id.fragment_container)
    }
}
