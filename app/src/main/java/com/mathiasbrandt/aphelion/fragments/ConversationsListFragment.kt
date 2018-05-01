package com.mathiasbrandt.aphelion.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mathiasbrandt.aphelion.R
import com.mathiasbrandt.aphelion.adapters.ConversationAdapter
import com.mathiasbrandt.aphelion.adapters.listeners.ConversationItemListener
import com.mathiasbrandt.aphelion.hostinterfaces.ConversationsListHost
import com.mathiasbrandt.aphelion.viewmodels.ConversationsViewModel
import kotlinx.android.synthetic.main.fragment_conversations_list.*

class ConversationsListFragment : Fragment() {
    lateinit var host: ConversationsListHost

    val conversationsListener = object : ConversationItemListener {
        override fun onConversationSelected(conversationId: Long) {
            host.showConversationDetails(conversationId)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_conversations_list, container, false)

        val viewmodel = ViewModelProviders.of(this).get(ConversationsViewModel::class.java)
        viewmodel.getConversations().observe(this, Observer { items ->
            items?.let {
                conversations.adapter = ConversationAdapter(it, conversationsListener)
            }
        })

        return layout
    }

    override fun onResume() {
        super.onResume()
        activity?.setTitle(R.string.title_conversations)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context !is ConversationsListHost) {
            throw RuntimeException(context.toString() + " does not implement host interface")
        } else {
            host = context
        }
    }
}
