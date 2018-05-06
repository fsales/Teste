package com.androidi.fos.materialdesigner

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pkmmte.pkrss.Article

class RecyclerAdapter(private val list: List<Article>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = list[position]

        holder.title.text = article.title
        holder.desc.text = article.author
        DownloadImageTask(holder.featuredImage).execute(article.enclosure.url)
        holder.btnLink.setOnClickListener {
            holder.itemView.context.startActivity(Intent(Intent.ACTION_VIEW, article.source))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}