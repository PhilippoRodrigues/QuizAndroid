package br.edu.infnet.assessment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.assessment.R
import br.edu.infnet.assessment.models.Pergunta
import kotlinx.android.synthetic.main.fragment_lista_pergunta_adapter.view.*

class PerguntaAdapter(private val perguntas : List<Pergunta>)
: RecyclerView.Adapter<PerguntaAdapter.PerguntaViewHolder>() {

    class PerguntaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewPergunta = view.textViewPerguntaAdapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerguntaViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.fragment_lista_pergunta_adapter,
                parent,
                false
            )

        val perguntaViewHolder = PerguntaViewHolder(view)
        return perguntaViewHolder
    }

    override fun onBindViewHolder(holder: PerguntaViewHolder, position: Int) {
        val pergunta = perguntas[position]
        holder.textViewPergunta.text = pergunta.pergunta
    }

    override fun getItemCount(): Int = perguntas.size
}