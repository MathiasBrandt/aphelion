package com.mathiasbrandt.aphelion.fragments

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mathiasbrandt.aphelion.Constants
import com.mathiasbrandt.aphelion.R
import com.mathiasbrandt.aphelion.models.Conversation
import com.mathiasbrandt.aphelion.viewmodels.ConversationDetailsViewModel

class ConversationDetailsFragment: Fragment() {
    lateinit var viewModel: ConversationDetailsViewModel
    lateinit var conversation: LiveData<Conversation>

    companion object {
        fun newInstance(conversationId: Long): ConversationDetailsFragment {
            val args = Bundle()
            args.putLong(Constants.CONVERSATION_ID, conversationId)

            val fragment = ConversationDetailsFragment()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_conversation_details, container, false)

        return layout
    }

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProviders.of(this).get(ConversationDetailsViewModel::class.java)

        arguments?.let {
            conversation = viewModel.getConversation(it.getLong(Constants.CONVERSATION_ID))
            conversation.observe(this, Observer {
                it?.let {
                    setTitle(it.participants)
                }
            })
        }
    }

    override fun onResume() {
        super.onResume()
    }

    private fun setTitle(title: String) {
        activity?.setTitle(title)
    }
}