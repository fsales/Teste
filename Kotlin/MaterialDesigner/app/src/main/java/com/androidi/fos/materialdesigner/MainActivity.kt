package com.androidi.fos.materialdesigner

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private val SECOND_ACTIVITY_REQUEST_CODE = 9999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // adicionando a navigation drawer
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.menu_login -> {
                    startActivityForResult(
                            Intent(this@MainActivity, TelaLoginActivity::class.java), SECOND_ACTIVITY_REQUEST_CODE)
                    true
                }
                R.id.menu_botao -> {
                    startActivityForResult(
                            Intent(this@MainActivity, TelaBotoesActivity::class.java), SECOND_ACTIVITY_REQUEST_CODE)
                    true
                }
                R.id.menu_recycler_view -> {
                    startActivityForResult(
                            Intent(this@MainActivity, TelaRecyclerViewActivity::class.java), SECOND_ACTIVITY_REQUEST_CODE)
                    true
                }

                R.id.menu_bottom_navigation -> {
                    startActivityForResult(
                            Intent(this@MainActivity, TelaBottomNavigationActivity::class.java), SECOND_ACTIVITY_REQUEST_CODE)
                    true
                }
                else -> false
            }

        }
    }


    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
            return
        }

        super.onBackPressed()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.search_menu -> {
                    toast("Buscar")
                    true
                }
                R.id.about_menu -> {
                    alert {
                        title = getString(R.string.titulo_alert_about)
                        customView {
                            linearLayout {
                                textView("Desenvolvido por:\nFábio Sales")
                                padding = dip(16)
                            }
                        }
                    }.show()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }


}
