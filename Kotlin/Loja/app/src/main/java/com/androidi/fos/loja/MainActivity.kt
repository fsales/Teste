package com.androidi.fos.loja

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //  val ll_main = findViewById(R.id.ll_main_layout) as LinearLayout


        for (i in 1..10) {
            // creating the button
            val button_dynamic = Button(this)
            // setting layout_width and layout_height using layout parameters

            button_dynamic.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            button_dynamic.text = "Dynamic Button"
            // add Button to LinearLayout

            button_dynamic.setOnClickListener { a ->
                val intent = Intent()
                intent.type = "image/*"
                intent.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
            }




            ll_main_layout.addView(button_dynamic)
        }
        // troca de tela - informa a tela atual e passa a nova tela
        //startActivity(Intent(this@MainActivity, MainActivity::class.java))
        //
    }
}
