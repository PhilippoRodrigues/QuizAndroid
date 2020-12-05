package br.edu.infnet.assessment.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import br.edu.infnet.assessment.R
import br.edu.infnet.assessment.databinding.FragmentTituloBinding

class TituloFragment : Fragment() {

    lateinit var binding: FragmentTituloBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_titulo, container, false)

        binding.btnIniciar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_tituloFragment_to_quizFragment)
        }

        return binding.root
    }
}