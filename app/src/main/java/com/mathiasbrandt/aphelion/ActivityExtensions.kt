package com.mathiasbrandt.aphelion

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import java.time.Instant

inline fun FragmentManager.makeTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction()
            .func()
            .commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.makeTransaction { replace(frameId, fragment) }
}
