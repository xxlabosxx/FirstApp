package com.gustavolabos.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.gustavolabos.myapplication.databinding.FragmentCalculoBinding
import com.gustavolabos.myapplication.service.model.Pessoa
import com.gustavolabos.myapplication.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentCalculoBinding? = null
    private val binding: FragmentCalculoBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCalculoBinding.inflate(inflater, container, false)
        return binding.root
        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.btnEnviar.setOnClickListener {
                val nome = binding.edtNome.editableText.toString()
                val anoNascimento = binding.edtAno.editableText.toString()

                if (nome != "" && anoNascimento !=""){
                    binding.tvNome.text = "Nome: ${nome}"

                    val anoAtual = LocalDateTime.now().year
                    val idade = anoAtual - anoNascimento.toInt()


                    binding.tvIdade.text = "Idade: ${idade}"

                    val pessoa = Pessoa(
                        nome = nome,
                        idade = idade
                    )
                    viewModel.insert(pessoa)

                    binding.edtNome.editableText.clear()
                    binding.edtAno.editableText.clear()
                }
                else{
                    Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
                }
            }
        }
}