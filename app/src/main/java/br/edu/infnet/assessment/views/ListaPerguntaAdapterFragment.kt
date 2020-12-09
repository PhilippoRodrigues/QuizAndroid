package br.edu.infnet.assessment.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.assessment.R
import br.edu.infnet.assessment.adapters.PerguntaAdapter
import br.edu.infnet.assessment.models.Pergunta
import br.edu.infnet.assessment.viewModels.QuizViewModel
import kotlinx.android.synthetic.main.fragment_lista_pergunta_adapter.view.*
import kotlinx.android.synthetic.main.fragment_lista_de_perguntas_recycler.*


class ListaPerguntaAdapterFragment : Fragment() {

    private lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista_pergunta_adapter, container, false)

        quizViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

//        quizViewModel
//            .perguntas.observe(viewLifecycleOwner) { perguntas ->
//                val perguntasAdapter = PerguntaAdapter(perguntas)
//                recyclerViewListaPerguntas.adapter = perguntasAdapter
//                recyclerViewListaPerguntas.layoutManager = LinearLayoutManager(requireContext())
//            }

        return view
    }
}