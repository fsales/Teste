package com.androidi.fos.materialdesigner

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private val SECOND_ACTIVITY_REQUEST_CODE = 9999
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        btn_tela_login.setOnClickListener {
            startActivityForResult(
                    Intent(this@MainActivity, TelaLoginActivity::class.java), SECOND_ACTIVITY_REQUEST_CODE)
        }

        btn_tela_botao.setOnClickListener {
            startActivityForResult(
                    Intent(this@MainActivity, TelaBotoesActivity::class.java), SECOND_ACTIVITY_REQUEST_CODE)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }


}
