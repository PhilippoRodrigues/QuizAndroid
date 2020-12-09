package br.edu.infnet.assessment.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.assessment.R
import br.edu.infnet.assessment.adapters.PerguntaAdapter
import br.edu.infnet.assessment.viewModels.QuizViewModel
import kotlinx.android.synthetic.main.fragment_lista_de_perguntas_recycler.*

class ListaDePerguntasRecyclerFragment : Fragment() {

    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_de_perguntas_recycler, container, false)


                quizViewModel.perguntas.observe(viewLifecycleOwner) { perguntas ->
                val perguntasAdapter = PerguntaAdapter(perguntas)
                recyclerViewListaPerguntas.adapter = perguntasAdapter
                recyclerViewListaPerguntas.layoutManager = LinearLayoutManager(requireContext())
            }

        return view
    }
}