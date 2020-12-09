package br.edu.infnet.assessment.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PontuacaoViewModel(pontuacaoFinal: Int) : ViewModel() {

    private val _pontuacao = MutableLiveData<Int>()
    val pontuacao: LiveData<Int>
        get() = _pontuacao

    private val _telaDeInicio = MutableLiveData<Boolean>()
    val telaDeInicio: LiveData<Boolean>
        get() = _telaDeInicio

    init {
        _pontuacao.value = pontuacaoFinal
    }

    fun voltarTelaDeInicio() {
        _telaDeInicio.value = true
    }

    fun voltarTelaDeInicioFinalizada() {
        _telaDeInicio.value = false
    }
}