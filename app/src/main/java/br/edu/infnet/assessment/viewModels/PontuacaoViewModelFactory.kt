package br.edu.infnet.assessment.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PontuacaoViewModelFactory(private val pontuacaoFinal: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PontuacaoViewModel::class.java)) {
            return PontuacaoViewModel(pontuacaoFinal) as T
        }
        throw IllegalArgumentException()
    }
}