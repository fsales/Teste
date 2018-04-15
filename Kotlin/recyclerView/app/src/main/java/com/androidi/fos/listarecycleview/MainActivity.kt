package com.androidi.fos.listarecycleview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_item.view.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = NoteListaAdapter(notes(), this)

        //val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
        val layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

        recycler.layoutManager = layoutManager
    }

    private fun notes(): List<Note> {
        return listOf(
                Note("Leitura",
                        "Livro de Kotlin com Android"),
                Note("Pesquisa",
                        "Como posso melhorar o código dos meus projetos"),
                Note("Estudo",
                        "Como sincronizar minha App com um Web Service")
        )
    }
}

class NoteListaAdapter(private val notes: List<Note>, private val context: Context) : RecyclerView.Adapter<NoteListaAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.bindView(note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // infla o layout
        val view = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false)

        return ViewHolder(view) // retorna o ViewHorlder enviado a view do card
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    // classe aninhada interna
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Note) {
            val title = itemView.note_item_title
            val description = itemView.note_item_description

            title.text = note.title
            description.text = note.description
            //Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            var show: Any = makeText(itemView.context, "", LENGTH_LONG).show()

            itemView.setOnClickListener { show }
        }

    }
}


data class Note(val title: String? = "", val description: String? = "")