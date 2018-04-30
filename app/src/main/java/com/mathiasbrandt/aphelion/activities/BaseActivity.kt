package com.mathiasbrandt.aphelion.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    fun startActivity(cls: Class<*>) {
        val intent = Intent(this, cls);
        startActivity(intent)
    }
}
