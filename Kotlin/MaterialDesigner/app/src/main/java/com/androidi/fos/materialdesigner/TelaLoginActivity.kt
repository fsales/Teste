package com.androidi.fos.materialdesigner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_login.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        setSupportActionBar(toolbar)
        btn_login.setOnClickListener {
            validarForm()
        }
    }

    fun validarForm() {

        if (et_email.text.isEmpty()) {
            txtlayout_email.isErrorEnabled = true
            txtlayout_email.error = getString(R.string.msg_preencha_email)
        } else {
            txtlayout_email.isErrorEnabled = false
        }

        if (et_senha.text.isEmpty()) {
            txtlayout_senha.isErrorEnabled = true
            txtlayout_senha.error = getString(R.string.msg_preencha_senha)
        } else {
            txtlayout_senha.isErrorEnabled = false
        }

    }
}
