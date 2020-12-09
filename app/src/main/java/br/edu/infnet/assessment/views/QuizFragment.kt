package br.edu.infnet.assessment.views

import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.edu.infnet.assessment.R
import br.edu.infnet.assessment.databinding.FragmentQuizBinding
import br.edu.infnet.assessment.models.Pergunta
import br.edu.infnet.assessment.viewModels.PontuacaoViewModel
import br.edu.infnet.assessment.viewModels.PontuacaoViewModelFactory
import br.edu.infnet.assessment.viewModels.QuizViewModel
import kotlinx.android.synthetic.main.fragment_pontuacao.*

class QuizFragment : Fragment() {

    lateinit var binding: FragmentQuizBinding
    private lateinit var viewModel: QuizViewModel

    private fun obterResposta(resposta: String) {
            if (resposta.equals(viewModel._perguntaAtual.value!!.alternativasDaPerguntaAtual[0])) {
                viewModel.atualizarPontuacaoTotal()
            }

        viewModel.perguntaIndex++

        if (viewModel.perguntaIndex < viewModel.qtdMaxPerguntas){
            viewModel.setObterPergunta()
            binding.invalidateAll()
        }
        else {
            obterPontuacao()
        }
    }

    private fun obterPontuacao() {
        val action =
            QuizFragmentDirections.actionQuizFragmentToPontuacaoFragment()
        action.pontuacao = viewModel.pontuacao.value ?:0
        if(viewModel.pontuacao.value!! >= 3){
            this.findNavController().navigate(action)
            Toast.makeText(activity, "Uau", Toast.LENGTH_SHORT).show()
        } else {
            this.findNavController().navigate(action)
            Toast.makeText(activity, "Tente outra vez", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)

        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        binding.quizViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    //Chama a função obterResposta para cada evento de clique entre as alternativas
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val alternativaA = view?.findViewById<TextView>(R.id.alternativaA)
        val alternativaB = view?.findViewById<TextView>(R.id.alternativaB)
        val alternativaC = view?.findViewById<TextView>(R.id.alternativaC)
        val alternativaD = view?.findViewById<TextView>(R.id.alternativaD)

        alternativaA?.setOnClickListener{
            obterResposta(alternativaA.text.toString())
        }

        alternativaB?.setOnClickListener{
            obterResposta(alternativaB.text.toString())
        }

        alternativaC?.setOnClickListener{
            obterResposta(alternativaC.text.toString())
        }

        alternativaD?.setOnClickListener{
            obterResposta(alternativaD.text.toString())
        }
    }
}