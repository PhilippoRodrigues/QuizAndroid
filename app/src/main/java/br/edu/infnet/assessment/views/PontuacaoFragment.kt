package br.edu.infnet.assessment.views

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import br.edu.infnet.assessment.R
import br.edu.infnet.assessment.databinding.FragmentPontuacaoBinding
import br.edu.infnet.assessment.viewModels.PontuacaoViewModel
import br.edu.infnet.assessment.viewModels.PontuacaoViewModelFactory
import kotlinx.android.synthetic.main.fragment_pontuacao.*

class PontuacaoFragment : Fragment() {

    private lateinit var viewModel : PontuacaoViewModel
    private lateinit var viewModelFactory: PontuacaoViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPontuacaoBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pontuacao,
            container,
            false
        )

        viewModelFactory =
            PontuacaoViewModelFactory(PontuacaoFragmentArgs.fromBundle(requireArguments()).pontuacao)


        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(PontuacaoViewModel::class.java)

        binding.pontuacaoViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        binding.textViewPontuacaoQuiz.text = viewModel.pontuacao.toString()

        viewModel.pontuacao.observe(viewLifecycleOwner, {
            textViewPontuacaoQuiz.text = it.toString()
        })

        binding.textViewPontuacaoQuiz.text = viewModel.pontuacao.toString()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        textViewCliqueAqui.setOnClickListener {


            val webpage: Uri = Uri.parse("https://www.google.com")
            val intent = Intent(Intent.ACTION_VIEW, webpage)

//            val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
//                putExtra(SearchManager.QUERY, Uri.parse("https://www.google.com"))
            if (intent.resolveActivity(requireContext().packageManager) != null) {
                startActivity(intent)
            }
            }
//        }

        btnLista.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_pontuacaoFragment_to_listaDePerguntasRecyclerFragment)
        }
    }
}