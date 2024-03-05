package com.gustavolabos.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import com.gustavolabos.myapplication.databinding.ActivityMainBinding
import com.gustavolabos.myapplication.databinding.TelaLinearBinding
import java.time.LocalDate
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

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
//            var nome = binding.edtNome.editableText.toString()
//
//            binding.tvNome.text = "Nome: ${nome}"
//
//            var anoNascimento = binding.edtAno.editableText.toString()
//            val anoAtual = LocalDateTime.now().year
//            var idade = anoAtual - anoNascimento.toInt()
//
//            binding.tvIdade.text = "Idade: ${idade}"
//    }
//}
//}