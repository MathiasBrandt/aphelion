package com.mathiasbrandt.aphelion.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mathiasbrandt.aphelion.Constants
import com.mathiasbrandt.aphelion.R

class ConversationDetailsFragment: Fragment() {

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

    override fun onResume() {
        super.onResume()
        arguments?.let {
            activity?.setTitle(it.getLong(Constants.CONVERSATION_ID).toString())
        }
    }
}