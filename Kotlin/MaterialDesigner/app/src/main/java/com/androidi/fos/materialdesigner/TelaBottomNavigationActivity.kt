package com.androidi.fos.materialdesigner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast

class TelaBottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        setSupportActionBar(toolbar)

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.menu_lista ->
                    // Action when tab 1 selected
                    toast("lista")
                R.id.menu_carrinho ->
                    // Action when tab 2 selected
                    toast("carrinho")
                R.id.menu_about ->
                    toast("sobre")
                else ->
                    // Action when tab 3 selected
                    toast("Não existe")
            }
            true
        }



    }
}
