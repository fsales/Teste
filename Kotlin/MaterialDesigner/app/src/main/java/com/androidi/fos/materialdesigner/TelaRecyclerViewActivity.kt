package com.androidi.fos.materialdesigner

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS
import kotlinx.android.synthetic.main.activity_tela_recycler_view.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaRecyclerViewActivity : AppCompatActivity(), Callback {

    private var adapter: RecyclerAdapter? = null
    private val list = arrayListOf<Article>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_recycler_view)
        setSupportActionBar(toolbar)
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(list)
        recyclerView.adapter = adapter

       // PkRSS.with(this).load("http://www.valor.com.br/brasil/rss").skipCache().callback(this).async()
        PkRSS.with(this).load("http://www.androidpro.com.br/feed/").skipCache().callback(this).async()

    }

    override fun onPreload() {
print("teste")
    }

    override fun onLoaded(newArticles: List<Article>) {
        list.clear()
        list.addAll(newArticles)
        adapter?.notifyDataSetChanged();
    }

    override fun onLoadFailed() {

    }
}
