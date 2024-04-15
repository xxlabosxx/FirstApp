package com.gustavolabos.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gustavolabos.myapplication.databinding.ListItemPessoaBinding
import com.gustavolabos.myapplication.service.model.Pessoa

class PessoasAdapter(pessoa: List<Pessoa>?, val clickListListener: (Pessoa) -> Unit) :
    RecyclerView.Adapter<PessoasAdapter.PessoaViewHolder>() {
        private var pessoaList:List<Pessoa> = arrayListOf()
    class PessoaViewHolder(private val binding: ListItemPessoaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pessoa: Pessoa, clickListListener: (Pessoa) -> Unit) {
            binding.tvNome.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString()
            binding.tvFaixa.text = pessoa.faixa

            if (pessoa.sexo == "Homem"){
                binding.imgMale.visibility = View.VISIBLE
                binding.imgFemale.visibility = View.GONE
            }else if (pessoa.sexo == "Mulher"){
                binding.imgFemale.visibility = View.VISIBLE
                binding.imgMale.visibility = View.GONE
            }

            binding.root.setOnClickListener {
                clickListListener(pessoa)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding =
            ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }
    fun updatePessoas(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}