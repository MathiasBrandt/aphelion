package com.mathiasbrandt.aphelion.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mathiasbrandt.aphelion.R
import com.mathiasbrandt.aphelion.adapters.ConversationAdapter
import com.mathiasbrandt.aphelion.adapters.listeners.ConversationItemListener
import com.mathiasbrandt.aphelion.viewmodels.ConversationsViewModel
import kotlinx.android.synthetic.main.fragment_conversations.*

class ConversationsListFragment : Fragment() {
    val conversationsListener = object : ConversationItemListener {
        override fun onConversationSelected(conversationId: Long) {
            Toast.makeText(context, "Clicked " + conversationId, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_conversations, container, false)

        val viewmodel = ViewModelProviders.of(this).get(ConversationsViewModel::class.java)
        viewmodel.getConversations().observe(this, Observer {
            items -> items?.let {
                conversations.adapter = ConversationAdapter(it, conversationsListener)
            }
        })

        return layout
    }


}
