package com.mathiasbrandt.aphelion

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import java.time.Instant

inline fun FragmentManager.makeTransaction(func: FragmentTransaction.() -> FragmentTransaction, addToBackStack: Boolean) {
    val transaction = beginTransaction()
            .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            .func()

    if(addToBackStack) {
        transaction.addToBackStack(null)
    }

    transaction.commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, addToBackStack: Boolean = true) {
    supportFragmentManager.makeTransaction( { replace(frameId, fragment) }, addToBackStack)
}
