package com.gustavolabos.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gustavolabos.myapplication.databinding.FragmentPessoaBinding
import com.gustavolabos.myapplication.service.model.Pessoa
import com.gustavolabos.myapplication.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root
        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.btnEnviar.setOnClickListener {
                val nome = binding.edtNome.editableText.toString()
                val anoNascimento = binding.edtAno.editableText.toString()
                var faixa = ""
                var sexo = ""

                if (binding.btnMale.isChecked){
                    sexo = "Homem"
                }else{
                    sexo = "Mulher"
                }

                if (nome != "" && anoNascimento !=""){
                    binding.tvNome.text = "Nome: ${nome}"

                    val anoAtual = LocalDateTime.now().year
                    val idade = anoAtual - anoNascimento.toInt()


                    binding.tvIdade.text = "Idade: ${idade}"

                    when (idade){
                        in 0..12 -> faixa = "Infantil"
                        in 13..17 -> faixa = "Adolecente"
                        in 18..64 -> faixa = "Adulto"
                        in 65..150 -> faixa = "Idoso"
                        else -> faixa = "Você está morto"
                    }

                    val pessoa = Pessoa(
                        nome = nome,
                        idade = idade,
                        sexo = sexo,
                        faixa = faixa
                    )

                    viewModel.insert(pessoa)

                    binding.edtNome.editableText.clear()
                    binding.edtAno.editableText.clear()
                    findNavController().navigateUp()
                }
                else{
                    Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
                }
            }
        }
}