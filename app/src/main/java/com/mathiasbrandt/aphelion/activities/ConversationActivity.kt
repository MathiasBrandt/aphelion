package com.mathiasbrandt.aphelion.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mathiasbrandt.aphelion.R
import com.mathiasbrandt.aphelion.fragments.ConversationsListFragment
import com.mathiasbrandt.aphelion.replaceFragment

class ConversationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.title_conversations)

        replaceFragment(ConversationsListFragment(), R.id.fragment_container)
    }
}
