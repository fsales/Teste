package com.androidi.fos.materialdesigner

import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var featuredImage: ImageView
    var title: TextView
    var desc: TextView
    var btnLink: Button

    init {


        this.featuredImage = itemView.featureImage
        this.title = itemView.titulo
        this.desc = itemView.desc
        this.btnLink = itemView.btn_link
    }
}