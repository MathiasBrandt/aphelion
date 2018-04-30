package com.mathiasbrandt.aphelion.activities

import android.os.Bundle
import android.view.View
import com.mathiasbrandt.aphelion.R
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        login_button.setOnClickListener(View.OnClickListener {
            startActivity(MainActivity::class.java)
        })
    }
}
