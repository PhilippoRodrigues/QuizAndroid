package br.edu.infnet.assessment.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.assessment.models.Pergunta

class QuizViewModel : ViewModel() {

//    private lateinit var viewModel : QuizViewModel

    var perguntaIndex = 0

    val _pontuacao = MutableLiveData<Int>()
    val pontuacao: LiveData<Int>
    get() = _pontuacao

    val _perguntaAtual = MutableLiveData<Pergunta>()
    val perguntaAtual: LiveData<Pergunta>
        get() = _perguntaAtual

    lateinit var listaPerguntas: MutableList<Pergunta>

    lateinit var alternativas: MutableList<String>

    lateinit var alternativaEscolhida: String

    val qtdMaxPerguntas = 4
//    var pontuacao = 0

//    private fun exibirListaPerguntas() {
        var perguntas = mutableListOf(
            Pergunta("Quanto é 1 + 1?",
                arrayListOf("2", "-1", "1", "0")),
            Pergunta("Which is the Independence day of Bangladesh?",
                arrayListOf("26 March","21 Feb","14th April","16 December") ),
            Pergunta("Who is the first man landed on moon?",
                arrayListOf("Neil Armstrong","Edwin Aldrin", "Michael Collins", "Yuri Gregory")),
            Pergunta("Socrates is best known for - ",
                arrayListOf("Philosophy","Mathmetics","Physiology","Astrology")),
            Pergunta("How many states does USA have? ",
                arrayListOf("50","45","55","49")),
            Pergunta("Which is not an Europian Country? ",
                arrayListOf("Combodia","Estonia","Lithunia","Moldova")),
            Pergunta("Who is the first President of USA? ",
                arrayListOf("George Washington","William Henry Harrison","Abraham Lincoln","Franklin D. Roosevelt")),
            Pergunta("Which one is the largest ocean? ",
                arrayListOf("Pacific","Atlantic","Mediterian","Arctic")),
            Pergunta("What country has a town named Marathon? ",
                arrayListOf("USA","GREECE","ITALY","FRANCE")),
            Pergunta("What well-known mountain pass connects Pakistan and Afghanistan? ",
                arrayListOf("Khyber Pass","Malakand Pass","Ahmad Pass","Shandar Pass")),
            Pergunta("What country was formerly known as Ceylon?",
                arrayListOf("Sri Lanka","Sweden","Vietnam","Switzerland"))
        )
//        listaPerguntas.shuffle()
//    }


    init {
        Log.i("QuizViewModel", "GameViewModel created!")
        exibirPerguntaAleatoria()
        _pontuacao.value = 0
    }

    //Obtém uma pergunta entre as que há no arrayList
    //Obtém as respectivas alternativas dessa pergunta
    //Embaralha as posições das alternativas
    fun setObterPergunta() {
        _perguntaAtual.value = perguntas[perguntaIndex]
        alternativas = ArrayList(_perguntaAtual.value!!.alternativasDaPerguntaAtual)
        alternativas.shuffle()
        Log.d("ConjuntoDeAlternativas", alternativas[0] + " " + alternativas[1] +
                " " + alternativas[2] + " " + alternativas[3])
        Log.d("Resposta", _perguntaAtual.value!!.alternativasDaPerguntaAtual[0])
    }

    fun exibirPerguntaAleatoria() {
        perguntas.shuffle()
        setObterPergunta()
    }

    fun onCorrect() {
        _pontuacao.value = _pontuacao.value?.plus(1)
        exibirPerguntaAleatoria()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("QuizViewModel", "GameViewModel destroyed!")
    }
}