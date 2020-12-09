package br.edu.infnet.assessment.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.assessment.models.Pergunta

class QuizViewModel : ViewModel() {

    var perguntaIndex = 0

    val _pontuacao = MutableLiveData<Int>()
    val pontuacao: LiveData<Int>
    get() = _pontuacao

    val _perguntaAtual = MutableLiveData<Pergunta>()
    val perguntaAtual: LiveData<Pergunta>
        get() = _perguntaAtual

    val _quizFinalizado = MutableLiveData<Boolean>()
    val quizFinalizado: LiveData<Boolean>
        get() = _quizFinalizado

    lateinit var listaPerguntas: MutableList<Pergunta>

    lateinit var alternativas: MutableList<String>

    lateinit var alternativaEscolhida: String

    val qtdMaxPerguntas = 11

    var perguntas = MutableLiveData<MutableList<Pergunta>>()


    init {
        _pontuacao.value = 0

        perguntas.value = mutableListOf (
            Pergunta("Quanto é 1 + 1?",
                arrayListOf("2", "-1", "1", "0")),
            Pergunta("Quanto é 2 + 2?",
                arrayListOf("4","22","1","333") ),
            Pergunta("Quanto é 4 + 4",
                arrayListOf("8", "1", "21", "4")),
            Pergunta("Quanto é 10 + 10?",
                arrayListOf("20","23","1","1010")),
            Pergunta("Quanto é 100 + 100?",
                arrayListOf("200","100100","12","10")),
            Pergunta("Quanto é 50 + 50?",
                arrayListOf("100", "5050", "5", "50")),
            Pergunta("Quanto é 3 + 3?",
                arrayListOf("6","9","32","2")),
            Pergunta("Quanto é 20 + 30?",
                arrayListOf("50","60","70","80")),
            Pergunta("Quanto é 30 + 40?",
                arrayListOf("70","60","50","40")),
            Pergunta("Quanto é 40 + 40?",
                arrayListOf("80","90","100","110")),
            Pergunta("Quanto é 60 + 60?",
                arrayListOf("120","100","130","140"))
        )
        exibirPerguntaAleatoria()
    }

    //Obtém uma pergunta entre as que há no arrayList
    //Obtém as respectivas alternativas dessa pergunta
    //Embaralha as posições das alternativas
    fun setObterPergunta() {
        _perguntaAtual.value = perguntas.value!![perguntaIndex]
        alternativas = ArrayList(_perguntaAtual.value!!.alternativasDaPerguntaAtual)
        alternativas.shuffle()
    }

    fun exibirPerguntaAleatoria() {
        perguntas.value!!.shuffle()
        setObterPergunta()
    }

     fun atualizarPontuacaoTotal(){
        _pontuacao.value = _pontuacao.value!!.plus(1)
        exibirPerguntaAleatoria()
    }

    fun onQuizCompleto() {
        _quizFinalizado.value = false
    }

    fun onQuizFinalizado() {
        _quizFinalizado.value = true
    }
}