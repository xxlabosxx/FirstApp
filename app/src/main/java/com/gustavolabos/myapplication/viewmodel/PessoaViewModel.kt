package com.gustavolabos.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gustavolabos.myapplication.service.model.Pessoa
import com.gustavolabos.myapplication.service.repository.PessoaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PessoaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PessoaRepository(application)

    fun insert(pessoa: Pessoa){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertPessoa(pessoa)
        }
    }

    fun getPessoa(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPessoa(id)
        }
    }
    fun update(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePessoa(id)
        }
    }

}