package br.edu.infnet.assessment.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.edu.infnet.assessment.R
import br.edu.infnet.assessment.databinding.FragmentQuizBinding
import br.edu.infnet.assessment.models.Pergunta
import br.edu.infnet.assessment.viewModels.QuizViewModel

class QuizFragment : Fragment() {

    lateinit var binding: FragmentQuizBinding
    private lateinit var viewModel: QuizViewModel

//    private var perguntaIndex = 0
//    lateinit var perguntaAtual: Pergunta
//    lateinit var alternativas: ArrayList<String>
//    lateinit var alternativaEscolhida: String
//    private val qtdMaxPerguntas = 4
//    private var pontuacao = 0

//    var perguntas = arrayListOf<Pergunta>(
//        Pergunta("Quanto é 1 + 1?",
//            arrayListOf("2", "-1", "1", "0")),
//        Pergunta("Which is the Independence day of Bangladesh?",
//            arrayListOf("26 March","21 Feb","14th April","16 December") ),
//        Pergunta("Who is the first man landed on moon?",
//            arrayListOf("Neil Armstrong","Edwin Aldrin", "Michael Collins", "Yuri Gregory")),
//        Pergunta("Socrates is best known for - ",
//            arrayListOf("Philosophy","Mathmetics","Physiology","Astrology")),
//        Pergunta("How many states does USA have? ",
//            arrayListOf("50","45","55","49")),
//        Pergunta("Which is not an Europian Country? ",
//            arrayListOf("Combodia","Estonia","Lithunia","Moldova")),
//        Pergunta("Who is the first President of USA? ",
//            arrayListOf("George Washington","William Henry Harrison","Abraham Lincoln","Franklin D. Roosevelt")),
//        Pergunta("Which one is the largest ocean? ",
//            arrayListOf("Pacific","Atlantic","Mediterian","Arctic")),
//        Pergunta("What country has a town named Marathon? ",
//            arrayListOf("USA","GREECE","ITALY","FRANCE")),
//        Pergunta("What well-known mountain pass connects Pakistan and Afghanistan? ",
//            arrayListOf("Khyber Pass","Malakand Pass","Ahmad Pass","Shandar Pass")),
//        Pergunta("What country was formerly known as Ceylon?",
//            arrayListOf("Sri Lanka","Sweden","Vietnam","Switzerland"))
//    )

    //Obtém uma pergunta entre as que há no arrayList
    //Obtém as respectivas alternativas dessa pergunta
    //Embaralha as posições das alternativas
//    private fun setObterPergunta() {
//        perguntaAtual = perguntas[perguntaIndex]
//        alternativas = ArrayList(perguntaAtual.alternativasDaPerguntaAtual)
//        alternativas.shuffle()
//        Log.d("ConjuntoDeAlternativas", alternativas[0] + " " + alternativas[1] +
//        " " + alternativas[2] + " " + alternativas[3])
//        Log.d("Resposta", perguntaAtual.alternativasDaPerguntaAtual[0])
//    }

    private fun obterResposta(resposta: String) {
            if (resposta.equals(viewModel._perguntaAtual.value!!.alternativasDaPerguntaAtual[0])) {
                viewModel.onCorrect()
            }

        viewModel.perguntaIndex++

        if (viewModel.perguntaIndex < viewModel.qtdMaxPerguntas){
            viewModel.setObterPergunta()
            binding.invalidateAll()
        } else {
            obterPontuacao()
        }
    }

    private fun obterPontuacao() {
        if(viewModel._pontuacao.value!! >= 3){
            Toast.makeText(activity, "Ganhou", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(activity, "Perdeu", Toast.LENGTH_SHORT).show()
        }
    }

    //Embaralha as perguntas e executa a função setObterPerguntas
//    private fun exibirPerguntaAleatoria() {
//        perguntas.shuffle()
//        setObterPergunta()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)


        Log.i("QuizFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        //Realiza o binding entre o layout fragment_quiz e esse fragment, por meio da propriedade
        //"name" presente na tag "data" no respectivo layout
        binding.quizViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

//        binding.exibirPerguntaAleatoria()

        return binding.root
    }

    //Vai chamar a função obterResposta para cada evento de clique entre as alternativas
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