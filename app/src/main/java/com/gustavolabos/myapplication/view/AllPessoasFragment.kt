package com.gustavolabos.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gustavolabos.myapplication.R
import com.gustavolabos.myapplication.databinding.FragmentAllPessoasBinding
import com.gustavolabos.myapplication.view.adapter.PessoasAdapter
import com.gustavolabos.myapplication.viewmodel.AllPessoasViewModel


class AllPessoasFragment : Fragment() {

    // Chamar a viewmodel
    private val viewModel: AllPessoasViewModel by viewModels()

    //chamar o adapter
    private lateinit var adapter: PessoasAdapter

    // Criar o binding
    private var _binding: FragmentAllPessoasBinding? = null
    private val binding: FragmentAllPessoasBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Configurar o binding
        _binding = FragmentAllPessoasBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Quando clicar em algum item da lista vai ser redirecionado
        adapter = PessoasAdapter(viewModel.pessoaList.value){}


        //Configura a recycler
        val recycler = binding.rvPessoas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //obeserva
        viewModel.pessoaList.observe(viewLifecycleOwner){
            adapter.updatePessoas(it)
        }

        // Navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.PessoaFragment    )
        }

        // Carregar as pessoas cadastradas
        viewModel.loadPessoa()
    }

}
