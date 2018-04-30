package com.mathiasbrandt.aphelion.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mathiasbrandt.aphelion.R
import com.mathiasbrandt.aphelion.fragments.ConversationsFragment
import com.mathiasbrandt.aphelion.replaceFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(ConversationsFragment(), R.id.fragment_container)
    }
}
