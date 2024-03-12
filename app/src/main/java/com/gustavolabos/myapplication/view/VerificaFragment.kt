package com.gustavolabos.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gustavolabos.myapplication.R
import com.gustavolabos.myapplication.databinding.FragmentCalculoBinding
import com.gustavolabos.myapplication.databinding.FragmentVerificaBinding
class VerificaFragment : Fragment() {
    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentVerificaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {

            var telefone = binding.edtTelefone.editableText.toString()

            if (telefone.length == 11) {
                binding.tvTelefone.text = "O telefone ${telefone} é válido"
            } else {
                binding.tvTelefone.text = "O telefone ${telefone} está inválido"
            }

            var email = binding.edtEmail.editableText.toString()
            if (email.contains("@") && email.contains(".com")){
                binding.tvEmail.text = "O E-mail ${email} é válido."
            } else {
                binding.tvEmail.text = "Este E-mail não está desponível"
            }

        }
    }

}


